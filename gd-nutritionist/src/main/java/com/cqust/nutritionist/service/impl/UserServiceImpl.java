package com.cqust.nutritionist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.nutritionist.mapper.UserMapper;
import com.cqust.nutritionist.pojo.NutritionistInfo;
import com.cqust.nutritionist.service.UserService;
import com.cqust.pojo.TUserinfo;

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
	TUserinfoMapper tUserinfoMapper;
	@Autowired
	UserMapper userMapper;
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
	public GdResult updateuserinfo(TUserinfo tUserinfo) {
		try {
			if(tUserinfoMapper.updateByPrimaryKeySelective(tUserinfo)==1)
				return GdResult.build(200, "修改成功");
		} catch (Exception e) {
			return GdResult.build(400, "修改失败");
		}
		return GdResult.build(400, "修改失败");
	}

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

	@Override
	public NutritionistInfo geTUserinfo(Integer id) {
		NutritionistInfo nutritionistInfo = userMapper.geTUserinfo(id);
		return nutritionistInfo;
	}


}
