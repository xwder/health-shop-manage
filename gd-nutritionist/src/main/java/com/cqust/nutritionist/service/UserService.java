package com.cqust.nutritionist.service;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.pojo.NutritionistInfo;
import com.cqust.pojo.TUserinfo;

public interface UserService {
	public TUserinfo getUserByToken(String token);
	
	GdResult updateuserinfo(TUserinfo tUserinfo);
	
	GdResult changepw(Integer id,String oldpw,String newpw);
    
	NutritionistInfo geTUserinfo(Integer id);
}
