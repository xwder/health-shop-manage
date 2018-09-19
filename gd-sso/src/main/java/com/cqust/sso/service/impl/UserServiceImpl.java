package com.cqust.sso.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.cqust.commom.utils.CookieUtils;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.IpUtils;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.mapper.TUserlogMapper;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserinfoExample;
import com.cqust.pojo.TUserinfoExample.Criteria;
import com.cqust.pojo.TUserlog;
import com.cqust.sso.dao.JedisClient;
import com.cqust.sso.pojo.LoginResult;
import com.cqust.sso.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO 用户管理Service
 * @author Joe
 * @date 2016年12月18日 下午9:56:31
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TUserinfoMapper userinfoMapper;

	@Autowired
	private JedisClient jedisClient;

	@Autowired
	private TUserlogMapper tUserlogMapper;

	/**
	 * @Fields REDIS_USER_SESSION_KEY : 用户session在redis中保存的key
	 */
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;

	/**
	 * @Fields DEFAULT_HEAD_IMAGE : 用户注册默认头像
	 */
	@Value("${DEFAULT_HEAD_IMAGE}")
	private String DEFAULT_HEAD_IMAGE;

	/**
	 * @Fields SSO_SESSION_EXPIRE : Session的过期时间30分钟
	 */
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;

	@Override
	public GdResult checkData(String content, Integer type) {
		// 创建查询条件
		TUserinfoExample example = new TUserinfoExample();
		Criteria criteria = example.createCriteria();
		// 对数据进行校验：1、2、3分别代表username、phone、email
		// 用户名校验
		if (1 == type) {
			criteria.andUsernameEqualTo(content);
			// 电话校验
		} else if (2 == type) {
			criteria.andPhoneEqualTo(content);
			// email校验
		} else {
			criteria.andEmailEqualTo(content);
		}
		// 执行查询
		List<TUserinfo> list = userinfoMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return GdResult.ok(true);
		}
		return GdResult.ok(false);
	}

	@SuppressWarnings("unused")
	@Override
	public GdResult createUser(TUserinfo user) {
		user.setCreatedtime(new java.sql.Date(new java.util.Date().getTime()));
		user.setUpdatedtime(new java.sql.Date(new java.util.Date().getTime()));

		if (user != null) {
			user.setSex(1);
			// 设置激活状态
			user.setState(1);
			// 设置激活码
			// user.setStatecode(UUID.randomUUID().toString());
			user.setStatecode("");
			// md5加密
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			// 设置是否有所属营养师
			user.setDietitianid(0);
			// 设置是否VIP
			user.setIsVip(0);
			// 设置默认头像
			user.setImage(DEFAULT_HEAD_IMAGE);
			// 设置是否是营养师 否
			user.setIsstore(0);;
			// 设置是否是商家 否
			user.setIsdiet(0);
			// 设置是否是管理员 否
			user.setIsadmin(0);
			
			userinfoMapper.insert(user);
			user.setPassword("");

			return GdResult.ok(user);
		}

		return GdResult.build(400, "注册失败！");
	}

	@Override
	public GdResult userLogin(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {

		String loginIp = IpUtils.getIpAddr(request);
		TUserlog userlog = new TUserlog();
		userlog.setLogindate(new Date());
		userlog.setLoginip(loginIp);
		
		
		TUserinfoExample example = new TUserinfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TUserinfo> list = userinfoMapper.selectByExample(example);
		// 如果没有此用户名
		if (null == list || list.size() <= 0) {
			
			userlog.setLoginps("用户名错误");
			userlog.setUid(null);
			userlog.setUsername(username);
			userlog.setLoginstatus(2);
			tUserlogMapper.insert(userlog);
			return GdResult.build(400, "用户名或密码错误");
		}
		TUserinfo user = list.get(0);
		// 比对密码
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			userlog.setLoginps("密码错误");
			userlog.setUid(null);
			userlog.setUsername(username);
			userlog.setLoginstatus(2);
			tUserlogMapper.insert(userlog);
			return GdResult.build(400, "用户名或密码错误");
		}

		try {
			 userlog.setUid(user.getId());
			 userlog.setUsername(username);
			 userlog.setLoginstatus(1);
			 userlog.setLoginps("登录成功！");
			 tUserlogMapper.insert(userlog);
		} catch (Exception e) {
		}

		// 生成token
		String token = UUID.randomUUID().toString();
		// 保存用户之前，把用户对象中的密码清空。
		user.setPassword(null);
		// 把用户信息写入redis
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		// 设置session的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);

		// 添加写cookie的逻辑，cookie的有效期是关闭浏览器就失效。
		CookieUtils.setCookie(request, response, "GD_TOKEN", token);

		// 返回token
		return GdResult.ok(token);
	}

	@Override
	public GdResult getUserByToken(String token) {

		// 根据token从redis中查询用户信息
		String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
		// 判断是否为空
		if (StringUtils.isBlank(json)) {
			return GdResult.build(400, "此session已经过期，请重新登录");
		}
		// 更新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		// 返回用户信息
		return GdResult.ok(JsonUtils.jsonToPojo(json, TUserinfo.class));
	}

	@Override
	public GdResult logout(String token) {
		// 更新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, 0);
		// 返回用户信息
		return GdResult.ok("");
	}

	@Override
	public GdResult changepw(Integer id, String oldpw, String newpw) {

		TUserinfo user = userinfoMapper.selectByPrimaryKey(id);
		// 比对密码
		if (!DigestUtils.md5DigestAsHex(oldpw.getBytes()).equals(user.getPassword())) {
			return GdResult.build(400, "原密码错误！");
		}
		if (newpw != null && newpw.length() != 0) {
			TUserinfo userinfo = userinfoMapper.selectByPrimaryKey(id);
			if (userinfo.getPassword().equals(DigestUtils.md5DigestAsHex(oldpw.getBytes()))) {
				String md5pw = DigestUtils.md5DigestAsHex(newpw.getBytes());
				user.setPassword(md5pw);
				userinfoMapper.updateByPrimaryKey(user);
				return GdResult.build(200, "修改成功！");
			} else {
				return GdResult.build(400, "修改失败！");
			}
		}

		return null;
	}

	@Override
	public GdResult userManagerLogin(String username, String password, Integer identity, HttpServletRequest request,
			HttpServletResponse response) {
		TUserlog record = new TUserlog();
		String loginIp = IpUtils.getIpAddr(request);
		record.setLoginip(loginIp);
		TUserinfoExample example = new TUserinfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TUserinfo> list = userinfoMapper.selectByExample(example);
		// 如果没有此用户名
		if (null == list || list.size() <= 0) {
			record.setLoginps("用户名错误");
			record.setUid(null);
			record.setUsername(username);
			record.setLoginstatus(2);
			tUserlogMapper.insert(record);
			return GdResult.build(400, "用户名或密码错误");
		}
		TUserinfo user = list.get(0);
		// 比对密码
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			record.setLoginps("密码错误");
			record.setUid(null);
			record.setUsername(username);
			record.setLoginstatus(2);
			tUserlogMapper.insert(record);
			return GdResult.build(400, "用户名或密码错误");
		}
		
		if(identity == 1){
			if(user.getIsstore() != 1){
				return GdResult.build(400, "身份错误,您不是商家！");
			}
		}else if(identity == 2){
			if(user.getIsdiet() != 1){
				return GdResult.build(400, "身份错误,您不是营养师！");
			}
		}else if(identity == 3){
			if(user.getIsadmin() != 1){
				return GdResult.build(400, "身份错误,您不是系统管理员！");
			}
		}else {
			return GdResult.build(400, "身份错误！");
		}


		try {
			record.setUid(user.getId());
			record.setUsername(user.getUsername());
			record.setLoginstatus(1);
			record.setLogindate(new java.sql.Date(new java.util.Date().getTime()));
			record.setLoginps("登录成功！");
			tUserlogMapper.insert(record);
		} catch (Exception e) {
			System.out.println(e);
		}

		// 生成token
		String token = UUID.randomUUID().toString();
		// 保存用户之前，把用户对象中的密码清空。
		user.setPassword(null);
		// 把用户信息写入redis
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		// 设置session的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);

		// 添加写cookie的逻辑，cookie的有效期是关闭浏览器就失效。
		
		if(identity == 1){
			CookieUtils.setCookie(request, response, "MSHOP_TOKEN", token);
		}else if(identity == 2){
			CookieUtils.setCookie(request, response, "YYS_TOKEN", token);
		}else if(identity == 3){
			CookieUtils.setCookie(request, response, "ADMIN_TOKEN", token);
		}
		LoginResult result = new LoginResult();
		result.setIdentity(identity);
		result.setToken(token);
		// 返回token
		return GdResult.ok(result);
	}

}
