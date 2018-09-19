package com.cqust.shop.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TSearchrecord;
import com.cqust.shop.service.PSearchRecordService;

@Service
public class PSearchRecordServiceImpl implements PSearchRecordService{
	
	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${ADDPRODUCT_SEARCHRECORD}")
	private String ADDPRODUCT_SEARCHRECORD;

	@Override
	public Integer addSearchRecord(TSearchrecord searchrecord) {
		String strJson = JsonUtils.objectToJson(searchrecord);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + ADDPRODUCT_SEARCHRECORD, strJson);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = JsonUtils.jsonToPojo(json, GdResult.class);
				if (gdResult.getStatus() == 200) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}


}
