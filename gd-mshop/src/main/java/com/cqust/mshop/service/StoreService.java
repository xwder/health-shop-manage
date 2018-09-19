package com.cqust.mshop.service;

import com.cqust.pojo.TStoreinfo;

public interface StoreService {
	/** 
	 * @Title: geTStoreinfoByUserid 
	 * @Description: 根据用户ID获取用户信息
	 * @param uid
	 * @return      
	 * @throws 
	 */
	public TStoreinfo geTStoreinfoByUserid(Integer uid);
	
	/** 
	 * @Title: updateStoreinfo 
	 * @Description: 更新商家信息
	 * @param storeinfo
	 * @return      
	 * @throws 
	 */
	Integer updateStoreinfo(TStoreinfo storeinfo);
	
	
}
