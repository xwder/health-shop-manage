package com.cqust.portal.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.portal.pojo.ZiXunInfo;
import com.cqust.portal.service.ZiXunService;

@Service
public class ZiXunServiceImpl implements ZiXunService {

	/** 
	* @Fields REST_BASE_URL : 服务基层url 
	*/ 
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	@Value("${ZIXUN_URL}")
	private String ZIXUN_URL;
 

	@Override
	public List<ZiXunInfo> getZXListByType(Integer zxtype,Integer page,Integer pagesize) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ZIXUN_URL  +"/"+page+"/"+pagesize+"/"+zxtype);
			if (!StringUtils.isBlank(json)) {
				List<ZiXunInfo> list = JsonUtils.jsonToList(json, ZiXunInfo.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
