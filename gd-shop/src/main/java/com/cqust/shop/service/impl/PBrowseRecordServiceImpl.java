package com.cqust.shop.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TPbrowserecord;
import com.cqust.shop.service.PBrowseRecordService;

@Service
public class PBrowseRecordServiceImpl implements PBrowseRecordService {
	
	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${ADDPRODUCT_BROWSERECORD}")
	private String ADDPRODUCT_BROWSERECORD;

	@Override
	public Integer addPBrowseRecordService(TPbrowserecord pbrowserecord) {

		String strJson = JsonUtils.objectToJson(pbrowserecord);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + ADDPRODUCT_BROWSERECORD, strJson);
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
