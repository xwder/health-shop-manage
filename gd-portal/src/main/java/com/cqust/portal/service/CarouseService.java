package com.cqust.portal.service;

import java.util.List;

import com.cqust.pojo.TPicture;

public interface CarouseService {
	/** 
	 * @Title: getCarouseList 
	 * @Description: 获取分类轮播列表
	 * @param CarouseType  类型
	 * @return      
	 * @throws 
	 */
	List<TPicture> getCarouseList(String carouseType);
}
