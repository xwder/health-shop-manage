package com.cqust.zixun.service;

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
}