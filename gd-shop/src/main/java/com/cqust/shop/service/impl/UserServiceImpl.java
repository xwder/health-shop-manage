package com.cqust.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.mapper.TAddressMapper;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.pojo.TAddress;
import com.cqust.pojo.TAddressExample;
import com.cqust.pojo.TAddressExample.Criteria;
import com.cqust.pojo.TUserinfo;
import com.cqust.shop.service.UserService;

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

	@Autowired
	private TUserinfoMapper tUserInfoMapper;
	
	@Autowired
	private TAddressMapper tAddressMapper;

	@Override
	public TUserinfo geTUserinfoById(Integer id) {
		TUserinfo userinfo = tUserInfoMapper.selectByPrimaryKey(id);
		userinfo.setPassword(null);
		return userinfo;
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
	public List<TAddress> getUserAddressList(Integer id) {

		TAddressExample example = new TAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);

		List<TAddress> list = tAddressMapper.selectByExample(example);
		return list;
	}

}
