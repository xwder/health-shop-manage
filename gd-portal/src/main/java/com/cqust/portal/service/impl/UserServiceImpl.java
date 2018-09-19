package com.cqust.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.pojo.TUserinfo;
import com.cqust.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
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
	* @Fields SSO_PAGE_LOGIN : 登录url
	*/ 
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;

	/**  
	* <p>Title: getUserByToken</p> 
	* <p>Description: 根据用户token获取用户信息</p> 
	* @param token	用户token
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

}
