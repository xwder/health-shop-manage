package com.cqust.manager.service;

import java.util.List;

import com.cqust.pojo.TUserinfo;

public interface UserService {
	
	/**
	* @Title: getUsersByType
	* @Description: 获取会员列表
	* @param  @param type 是否高级会员
	* @param  @return    
	* @return List<TProduct>    
	* @throws
	*/
	List<TUserinfo> getUsersByType(Integer type);
	
	/** 
	 * @Title: getUserByToken 
	 * @Description: 根据用户token获取用户信息
	 * @param token
	 * @return      用户信息
	 * @throws 
	 */
	TUserinfo getUserByToken(String token);
}
