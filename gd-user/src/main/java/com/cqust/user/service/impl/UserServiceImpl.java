package com.cqust.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.mapper.TUserhealthinfoMapper;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.pojo.TUserhealthinfo;
import com.cqust.pojo.TUserhealthinfoExample;
import com.cqust.pojo.TUserhealthinfoExample.Criteria;
import com.cqust.pojo.TUserinfo;
import com.cqust.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	@Value("${SSO_DOMAIN_BASE_USRL}")
	public String SSO_DOMAIN_BASE_USRL;
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	@Value("${SSO_USER_CHANGEPW}")
	public String SSO_USER_CHANGEPW;

	@Autowired
	private TUserinfoMapper tUserInfoMapper;

	@Autowired
	private TUserhealthinfoMapper tUserHealthInfoMapper;

	@Override
	public TUserinfo geTUserinfoById(Integer id) {
		TUserinfo userinfo = tUserInfoMapper.selectByPrimaryKey(id);
		userinfo.setPassword(null);
		return userinfo;
	}

	@Override
	public Integer updateTUserInfoById(TUserinfo tUserinfo) {
		return tUserInfoMapper.updateByPrimaryKeySelective(tUserinfo);
	}

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
	public GdResult changepw(Integer id, String oldpw, String newpw) {
		GdResult result = null;
		String url = SSO_BASE_URL + SSO_USER_CHANGEPW + id.toString() + "/" + oldpw + "/" + newpw;
		try {
			String json = HttpClientUtil.doGet(url);
			result = GdResult.formatToPojo(json, GdResult.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = GdResult.build(400, e.toString());
		}
		return result;
	}

	@Override
	public TUserhealthinfo getUserHealthInfoByUId(Integer id) {
		TUserhealthinfoExample example = new TUserhealthinfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		List<TUserhealthinfo> list = tUserHealthInfoMapper.selectByExample(example);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public GdResult updateUserHealthInfo(TUserhealthinfo userhealthinfo) {
		Integer result = tUserHealthInfoMapper.updateByPrimaryKey(userhealthinfo);
		if (result == 1)
			return GdResult.build(200, "修改成功！");
		return GdResult.build(400, "修改失败!");
	}

	@Override
	public GdResult addUserHealthInfo(TUserhealthinfo userhealthinfo) {
		Integer result = tUserHealthInfoMapper.insert(userhealthinfo);
		if (result == 1)
			return GdResult.build(200, "添加成功！");
		return GdResult.build(400, "添加失败!");
	}

}
