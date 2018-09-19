package com.cqust.manager.service;

import java.util.List;

import com.cqust.pojo.TStoreinfo;

public interface StoreService {

	/**
	* @Title: getStores
	* @Description: 获取商家信息
	* @param  @return    
	* @return List<TStoreinfo>    
	* @throws
	*/
	List<TStoreinfo> getStores();
}
