package com.cqust.shop.service;

import com.cqust.pojo.TStoreinfo;

public interface StoreService {
	
	/** 
	 * @Title: getStoreInfoByItemId 
	 * @Description: 根据商家ID获取商家信息
	 * @param itemid
	 * @return      
	 * @throws 
	 */
	TStoreinfo getStoreInfoId(Integer storeid);
}
