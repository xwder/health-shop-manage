package com.cqust.portal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.portal.service.PotalBrowseService;

@Service
public class PotalBrowseServiceImpl implements PotalBrowseService {

	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${ADD_POTAL_BROWSERECORD}")
	private String ADD_POTAL_BROWSERECORD;

	@Override
	public Integer addPotalBrowse(TPotalbrowserecord potalbrowserecord) {

		String strJson = JsonUtils.objectToJson(potalbrowserecord);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + ADD_POTAL_BROWSERECORD, strJson);
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
