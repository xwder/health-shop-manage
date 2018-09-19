package com.cqust.rest.mapper;

import java.util.List;

import com.cqust.pojo.THotsearch;

/** 
 * @ClassName: HotSearchMapper 
 * @Description: 热搜次
 * @author Joe  
 * @date 2017年3月13日 下午5:13:29 
 *  
 */
public interface HotSearchMapper {

	
	/** 
	 * @Title: geTHotsearchs 
	 * @Description: 获取热搜词列表
	 * @return      
	 * @throws 
	 */
	List<THotsearch> geTHotsearchs();
}
