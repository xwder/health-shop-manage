package com.cqust.shop.service;

import java.util.List;

import com.cqust.pojo.TAddress;
import com.cqust.pojo.TUserinfo;

public interface UserService {
	/** 
	 * @Title: geTUserinfoById 
	 * @Description: 用户信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TUserinfo geTUserinfoById(Integer id);
	
	 

	/** 
	 * @Title: getUserByToken 
	 * @Description: 根据用户token获取用户信息
	 * @param token
	 * @return      用户信息
	 * @throws 
	 */
	TUserinfo getUserByToken(String token);
	
	/** 
	 * @Title: getUserAddress 
	 * @Description: 根据用户ID查询用户所有收货地址
	 * @param id
	 * @return      所有收货地址
	 * @throws 
	 */
	List<TAddress> getUserAddressList(Integer id);

	 
}
