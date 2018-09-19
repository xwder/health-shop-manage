package com.cqust.manager.service;

import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TStoreapplication;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;

public interface SellerService {
	/**
	 * 获得商家申请信息
	 * @Title: getSellerApplication 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */	
	public List<TStoreapplication> getSellerApplication();
	
	/**
	 * 更改商家申请状态
	 * @Title: updateSellerApplication 
	 * @Description: TODO
	 * @param tStoreapplication
	 * @return      
	 * @throws
	 */
	public GdResult updateSellerApplication(TStoreapplication tStoreapplication,TUserinfo tUserinfo);
	
	/**
	 * 获取商家信息
	 * @Title: getVipInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public List<TUserinfo> getSellerInfo();
	
	
	/** 
	 * @Title: addSellerInfo 
	 * @Description: 添加商家信息
	 * @param storeinfo
	 * @return      
	 * @throws 
	 */
	Integer addSellerInfo(TStoreinfo storeinfo);
	
	/** 
	 * @Title: getStoreAppInfoById 
	 * @Description: 根据申请表的ID获取申请信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TStoreapplication getStoreAppInfoById(Integer id);

}
