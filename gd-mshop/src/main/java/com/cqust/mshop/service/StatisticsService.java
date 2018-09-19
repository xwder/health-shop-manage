package com.cqust.mshop.service;

import java.util.List;

public interface StatisticsService {
	
	
	/**
	* @Title: pbrowseStatistics
	* @Description: 过去七天的商品浏览量
	* @param  @param sid
	* @param  @return    
	* @return List<Integer>    
	* @throws
	*/
	List<Integer> pbrowseStatistics(Integer sid ,Integer datenum);
	
	/**
	* @Title: orderStatistics
	* @Description: 过去七天订单金额
	* @param  @param sid
	* @param  @return    
	* @return List<Double>    
	* @throws
	*/
	List<Double> orderStatistics(Integer sid,Integer datenum);
}
