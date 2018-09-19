package com.cqust.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.manager.service.UserService;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserinfoExample;
import com.cqust.pojo.TUserinfoExample.Criteria;

@Service
public class UserServiceImpl implements UserService{
	
	

	/**
	 * @Fields SSO_BASE_URL : 用户服务基层url
	 */
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;


	/**
	 * @Fields SSO_USER_TOKEN : 根据token获取用户信息 url
	 */
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;

	
	@Autowired
	private TUserinfoMapper userinfoMapper;
	
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
	public List<TUserinfo> getUsersByType(Integer type) {
		TUserinfoExample example = new TUserinfoExample();
		if(type != 2){
			Criteria criteria = example.createCriteria();
			criteria.andIsVipEqualTo(type);
		}
		List<TUserinfo> list = userinfoMapper.selectByExample(example);
		return list;
	}
	
	

}
