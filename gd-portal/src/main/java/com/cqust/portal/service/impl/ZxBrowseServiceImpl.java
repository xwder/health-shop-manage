package com.cqust.portal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TZxbrowserecord;
import com.cqust.portal.service.ZxBrowseService;

@Service
public class ZxBrowseServiceImpl implements ZxBrowseService{
	
	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${ADDZX_BROWSERECORD}")
	private String ADDZX_BROWSERECORD;

	@Override
	public Integer addZxBrowseRecord(TZxbrowserecord zxbrowserecord) {

		String strJson = JsonUtils.objectToJson(zxbrowserecord);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + ADDZX_BROWSERECORD, strJson);
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
