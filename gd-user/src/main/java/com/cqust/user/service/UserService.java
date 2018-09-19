package com.cqust.user.service;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TUserhealthinfo;
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
	 * @Title: updateTUserInfoById 
	 * @Description: 根据用户ID更新用户信息
	 * @param tUserinfo
	 * @return      
	 * @throws 
	 */
	Integer updateTUserInfoById(TUserinfo tUserinfo);
	

	/** 
	 * @Title: getUserByToken 
	 * @Description: 根据用户token获取用户信息
	 * @param token
	 * @return      用户信息
	 * @throws 
	 */
	TUserinfo getUserByToken(String token);
	
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
	
	/** 
	 * @Title: getUserHealthInfoByUId 
	 * @Description: 根据用户ID查询用户健康信息表
	 * @param id     用户ID
	 * @return       健康信息表
	 * @throws 
	 */
	TUserhealthinfo getUserHealthInfoByUId(Integer id);
	
	
	/** 
	 * @Title: addUserHealthInfo 
	 * @Description: 添加用户健康信息
	 * @param userhealthinfo 用户健康信息
	 * @return      
	 * @throws 
	 */
	GdResult addUserHealthInfo(TUserhealthinfo userhealthinfo);
	
	
	
	/** 
	 * @Title: updateUserHealthInfo 
	 * @Description: 更新用户健康信息表
	 * @param userhealthinfo
	 * @return      
	 * @throws 
	 */
	GdResult updateUserHealthInfo(TUserhealthinfo userhealthinfo);
	

}
