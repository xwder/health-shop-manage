package com.cqust.mshop.service;

import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.mshop.pojo.CustomLoginLog;
import com.cqust.pojo.TUserinfo;

public interface UserService {

	/** 
	 * @Title: getUserByToken 
	 * @Description: 根据用户token获取用户信息
	 * @param token
	 * @return      用户信息
	 * @throws 
	 */
	TUserinfo getUserByToken(String token);
	
	/** 
	 * @Title: getUserinfoByid 
	 * @Description: 根据用户ID获取用户信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TUserinfo getUserinfoByid(Integer id); 
	
	/** 
	 * @Title: updateUserinfo 
	 * @Description: 更新用户信息
	 * @param userinfo
	 * @return      
	 * @throws 
	 */
	Integer updateUserinfo(TUserinfo userinfo);
	
	/** 
	 * @Title: getLoginLogByUid 
	 * @Description: 获取用户登录日志
	 * @param uid
	 * @return      
	 * @throws 
	 */
	List<CustomLoginLog> getLoginLogByUid(Integer uid,String username);
	
	/** 
	 * @Title: changepw 
	 * @Description: TODO
	 * @param id
	 * @param oldpw
	 * @param newpw
	 * @return      
	 * @throws 
	 */
	GdResult changepw(Integer id,String oldpw,String newpw);
	}
