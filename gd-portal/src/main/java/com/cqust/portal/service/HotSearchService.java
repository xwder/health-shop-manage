package com.cqust.portal.service;

import java.util.List;

import com.cqust.pojo.THotsearch;

/**
 * 首页搜索、热门搜索
* @ClassName: IndexContentService 
* @Description: TODO 
* @author Joe  
* @date 2017年3月7日 上午9:51:49 
*
 */
public interface HotSearchService {
	
	
	/** 
	 * @Title: getTHotSearchList 
	 * @Description: 获取热搜词列表
	 * @return       热搜词列表 降序排序
	 * @throws 
	 */
	List<THotsearch>  getTHotSearchList();
}
