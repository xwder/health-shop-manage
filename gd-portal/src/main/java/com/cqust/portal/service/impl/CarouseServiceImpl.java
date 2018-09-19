package com.cqust.portal.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.pojo.TPicture;
import com.cqust.portal.service.CarouseService;

@Service
public class CarouseServiceImpl implements CarouseService {

	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	// 轮播url
	@Value("${CAROUSE_URL}")
	private String CAROUSE_URL;

	/**  
	* <p>Title: getCarouseList</p> 
	* <p>Description: 获取首页轮播列表</p> 
	* @param carouseType 轮播类型
	* @return	轮播列表
	* @see com.cqust.portal.service.CarouseService#getCarouseList(java.lang.String) 
	*/
	@Override
	public List<TPicture> getCarouseList(String carouseType) {
		String url = REST_BASE_URL + CAROUSE_URL + "/" + carouseType;
		
		try {
			String json = HttpClientUtil.doGet(url);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToList(json, TPicture.class);
				if (gdResult.getStatus() == 200) {
					@SuppressWarnings("unchecked")
					List<TPicture> tPictureList = (List<TPicture>) gdResult.getData();
					return tPictureList;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
