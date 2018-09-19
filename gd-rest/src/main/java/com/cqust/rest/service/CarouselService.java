package com.cqust.rest.service;

import java.util.List;

import com.cqust.pojo.TPicture;

/** 
 * @ClassName: CarouselService 
 * @Description: 轮播图片
 * @author Joe  
 * @date 2017年3月14日 上午11:17:56 
 *  
 */
public interface CarouselService {


	/** 
	 * @Title: getCarouseList 
	 * @Description: 获取分类轮播列表
	 * @param CarouseType  类型
	 * @return      
	 * @throws 
	 */
	List<TPicture> getCarouseList(String carouseType);
	
	
}
