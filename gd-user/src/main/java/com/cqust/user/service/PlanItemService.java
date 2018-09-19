package com.cqust.user.service;

import com.cqust.commom.utils.GdResult;

public interface PlanItemService {
	
	/**
	 * 获取全部的运动项目
	 * @Title: getSportItem 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	GdResult getSportItem();

	/**
	 * 根据id获取某一项运动项目
	 * @Title: getSportItemById 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	GdResult getSportItemById(Integer id);
	
}
