package com.cqust.portal.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.pojo.THotsearch;
import com.cqust.portal.service.HotSearchService;

@Service
public class HotSearchServiceImpl implements HotSearchService {

	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	//热搜词列表url
	@Value("${HOTSEARCH_URL}")
	private String HOTSEARCH_URL;
	
	/**  
	* <p>Title: getTHotSearchList</p> 
	* <p>Description: 获得首页热搜词列表</p> 
	* @return 热搜词列表
	* @see com.cqust.portal.service.HotSearchService#getTHotSearchList() 
	*/
	@Override
	public List<THotsearch> getTHotSearchList() {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + HOTSEARCH_URL);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToList(json, THotsearch.class);
				if (gdResult.getStatus() == 200) {
					@SuppressWarnings("unchecked")
					List<THotsearch> tHotsearchList = (List<THotsearch>) gdResult.getData();
					return tHotsearchList;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
