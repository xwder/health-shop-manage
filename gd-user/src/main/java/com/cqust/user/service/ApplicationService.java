package com.cqust.user.service;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TDietapplication;
import com.cqust.pojo.TStoreapplication;
import com.cqust.pojo.TVipapplication;

/**
 * 申请处理
 * @ClassName: ApplicationService 
 * @Description: TODO 
 * @author Joe  
 * @date 2017年3月24日 下午4:58:44 
 *
 */
public interface ApplicationService {
	
	/** 
	 * @Title: getVipApplication 
	 * @Description: 估计用户ID 查询用户VIP申请表
	 * @param id	用户id
	 * @return      用户高级会员申请信息
	 * @throws 
	 */
	TVipapplication getVipApplication(Integer userid);

	/** 
	 * @Title: userVipApplication 
	 * @Description: 普通用户申请VIP用户表
	 * @param app 申请表
	 * @return      
	 * @throws 
	 */
	GdResult addUserVipApplication(TVipapplication app);
	
	/** 
	 * @Title: getDeitApplication 
	 * @Description: 根据用户ID查询营养师申请记录
	 * @param userid 用户id
	 * @return      用户营养师申请信息
	 * @throws 
	 */
	TDietapplication getDeitApplication(Integer userid);
	
	/** 
	 * @Title: addDietApplication 
	 * @Description: 添加营养师申请记录
	 * @param dietapp 申请信息
	 * @return      
	 * @throws 
	 */
	GdResult addDietApplication (TDietapplication dietapp);
	
	/** 
	 * @Title: geTStoreapplication 
	 * @Description: 根据用户ID查询店铺申请
	 * @param userid 用户id
	 * @return      
	 * @throws 
	 */
	TStoreapplication geTStoreapplication(Integer userid);
	
	/** 
	 * @Title: addStoreApplication 
	 * @Description: 添加店铺申请
	 * @param storeapp 店铺申请信息
	 * @return      
	 * @throws 
	 */
	GdResult addStoreApplication(TStoreapplication storeapp);
}
