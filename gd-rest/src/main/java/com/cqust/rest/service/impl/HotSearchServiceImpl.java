package com.cqust.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.pojo.THotsearch;
import com.cqust.rest.mapper.HotSearchMapper;
import com.cqust.rest.service.HotSearchService;

@Service
public class HotSearchServiceImpl implements HotSearchService {

	@Autowired
	private HotSearchMapper hotSearchMapper;

	/**  
	* <p>Title: geTHotsearchs</p> 
	* <p>Description: 获取热搜词列表</p> 
	* @return 热搜词列表
	* @see com.cqust.rest.service.HotSearchService#geTHotsearchs() 
	*/
	@Override
	public List<THotsearch> geTHotsearchs() {
		List<THotsearch> list = hotSearchMapper.geTHotsearchs();
		return list;
	}

}
