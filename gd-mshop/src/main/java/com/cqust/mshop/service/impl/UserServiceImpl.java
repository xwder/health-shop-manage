package com.cqust.mshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.mapper.TUserlogMapper;
import com.cqust.mshop.pojo.CustomLoginLog;
import com.cqust.mshop.service.UserService;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserlog;
import com.cqust.pojo.TUserlogExample;
import com.cqust.pojo.TUserlogExample.Criteria;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * @Fields SSO_BASE_URL : 用户服务基层url
	 */
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;

	/**
	 * @Fields SSO_DOMAIN_BASE_USRL : 用户服务基层url
	 */
	@Value("${SSO_DOMAIN_BASE_USRL}")
	public String SSO_DOMAIN_BASE_USRL;

	/**
	 * @Fields SSO_USER_TOKEN : 根据token获取用户信息 url
	 */
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;

	/**
	 * @Fields SSO_PAGE_LOGIN : 登录页面url
	 */
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	
	/**
	 * @Fields SSO_LOGIN : 登录url
	 */
	@Value("${SSO_LOGIN}")
	public String SSO_LOGIN;
	
	/**
	 * @Fields SSO_MANAGER_LOGIN : 管理员登录url
	 */
	@Value("${SSO_MANAGER_LOGIN}")
	public String SSO_MANAGER_LOGIN;
	
	@Value("${SSO_USER_CHANGEPW}")
	public String SSO_USER_CHANGEPW;
	
	@Autowired
	private TUserinfoMapper userinfoMapper;
	
	@Autowired
	private TUserlogMapper userlogMapper;
	

	@Override
	public GdResult changepw(Integer id, String oldpw, String newpw) {
		GdResult result = null;
		String url = SSO_BASE_URL + SSO_USER_CHANGEPW + id.toString() + "/" + oldpw + "/" + newpw;
		try {
			String json = HttpClientUtil.doGet(url);
			result = GdResult.formatToPojo(json, GdResult.class);
		} catch (Exception e) {
			e.printStackTrace();
			result = GdResult.build(400, e.toString());
		}
		return result;
	}

	/**
	 * <p>
	 * Title: getUserByToken
	 * </p>
	 * <p>
	 * Description: 根据用户token获取用户信息
	 * </p>
	 * 
	 * @param token
	 *            用户token
	 * @return 用户信息
	 * @see com.cqust.portal.service.UserService#getUserByToken(java.lang.String)
	 */
	@Override
	public TUserinfo getUserByToken(String token) {
		try {
			// 调用sso系统的服务，根据token取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
			// 把json转换成TaotaoREsult
			GdResult result = GdResult.formatToPojo(json, TUserinfo.class);
			if (result.getStatus() == 200) {
				TUserinfo user = (TUserinfo) result.getData();
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TUserinfo getUserinfoByid(Integer id) {
		TUserinfo userinfo = userinfoMapper.selectByPrimaryKey(id);
		if(userinfo!=null){
			userinfo.setPassword("");
		}
		return userinfo;
	}

	@Override
	public Integer updateUserinfo(TUserinfo userinfo) {
		Integer result = userinfoMapper.updateByPrimaryKeySelective(userinfo);
		return result;
	}

	@Override
	public List<CustomLoginLog> getLoginLogByUid(Integer uid,String username) {
		TUserlogExample example = new TUserlogExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		//criteria.andUidEqualTo(uid);
		List<TUserlog> list = userlogMapper.selectByExample(example);
		if(list!=null & list.size() > 0){
			List<CustomLoginLog> customLoginLogs = new ArrayList<>();
			TUserlog userlog = null;
			for(int i=0;i<list.size();i++){
				CustomLoginLog customLoginLog = new CustomLoginLog();
				userlog = list.get(i);
				customLoginLog.setId(userlog.getId());
				customLoginLog.setUid(userlog.getUid());
				customLoginLog.setLogindate(userlog.getLogindate());
				customLoginLog.setLoginip(userlog.getLoginip());
				customLoginLog.setUsername(userlog.getUsername());
				customLoginLog.setLoginstatus(userlog.getLoginstatus());
				customLoginLog.setLoginps(userlog.getLoginps());
				if(userlog.getLoginstatus() == 1){
					customLoginLog.setStrloginstatus("登录成功");
				}else{
					customLoginLog.setStrloginstatus("登录失败");
				}
				customLoginLogs.add(customLoginLog);
			}
			return customLoginLogs;
		}
		return null;
	}

}