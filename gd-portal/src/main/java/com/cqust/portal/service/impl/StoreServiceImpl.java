package com.cqust.portal.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TStoreinfo;
import com.cqust.portal.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	
	/**
	 * @Fields REST_BASE_URL : 服务基层url
	 */
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${STORELIST_URL}")
	private String STORELIST_URL;

	@Override
	public List<TStoreinfo> storeinfosByStype(String stype) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + STORELIST_URL+stype);
			if (!StringUtils.isBlank(json)) {
				List<TStoreinfo> list = JsonUtils.jsonToList(json, TStoreinfo.class);
				return list;
			}
		} catch (Exception e) {
		}
		return null;
	}

}
