package com.cqust.manager.service;

import java.util.List;

public interface StatisticsService {
	/**
	* @Title: pbrowseStatistics
	* @Description: 过去七天的商品浏览量
	* @param  @return    
	* @return List<Integer>    
	* @throws
	*/
	List<Integer> pbrowseStatistics(Integer datenum);
	
	/**
	* @Title: orderStatistics
	* @Description: 过去七天订单金额
	* @param  @return    
	* @return List<Double>    
	* @throws
	*/
	List<Double> orderStatistics(Integer datenum);
	
	/**
	* @Title: userloginStatistics
	* @Description: 过去七天用户登录量
	* @param  @param datenum
	* @param  @return    
	* @return List<Integer>    
	* @throws
	*/
	List<Integer> userloginStatistics(Integer datenum);
	
	/**
	* @Title: searchStatistics
	* @Description: 商品搜索量
	* @param  @param datenum
	* @param  @return    
	* @return List<Integer>    
	* @throws
	*/
	List<Integer> searchStatistics(Integer datenum);
	
	/**
	* @Title: potalStatistics
	* @Description: 首页访问量
	* @param  @param datenum
	* @param  @return    
	* @return List<Integer>    
	* @throws
	*/
	List<Integer> potalStatistics(Integer datenum);
	
	/**
	* @Title: zixunStatistics
	* @Description: 资讯浏览量
	* @param  @param datenum
	* @param  @return    
	* @return List<Integer>    
	* @throws
	*/
	List<Integer> zixunStatistics(Integer datenum);
}
