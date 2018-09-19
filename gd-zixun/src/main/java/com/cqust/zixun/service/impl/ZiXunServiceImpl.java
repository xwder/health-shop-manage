package com.cqust.zixun.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TZxbrowserecord;
import com.cqust.pojo.TZxtype;
import com.cqust.zixun.pojo.ZiXunInfo;
import com.cqust.zixun.service.ZiXunService;

import net.sf.json.JSONObject;

@Service
public class ZiXunServiceImpl implements ZiXunService {

	/**
	 * @Fields REST_BASE_URL
	 */
	@Value("${REST_BASE_URL}")
	public String REST_BASE_URL;

	@Value("${ZIXUNLIST_URL}")
	public String ZIXUNLIST_URL;

	@Value("${ZIXUNTYPE_URL}")
	public String ZIXUNTYPE_URL;

	@Value("${ZIXUN_URL}")
	public String ZIXUN_URL;
	
	@Value("${ZIXUN_BROWSE_RUL}")
	public String ZIXUN_BROWSE_RUL;
	
	

	@Override
	public ZiXunInfo getZiXunById(Integer id) {
		
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ZIXUN_URL + "/" + id);
			if (!StringUtils.isBlank(json)) {
				ZiXunInfo zXunInfo = JsonUtils.jsonToPojo(json, ZiXunInfo.class);
				return zXunInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public List<TZxtype> getZxTypeList() {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ZIXUNTYPE_URL);
			if (!StringUtils.isBlank(json)) {
				List<TZxtype> list = JsonUtils.jsonToList(json, TZxtype.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public PageBean<ZiXunInfo> getZiXunInfoByZxType(Integer zxtypeid, Integer page, Integer pagesize) {
		String url = null;
		if(zxtypeid != null){
			url = REST_BASE_URL + ZIXUNLIST_URL + "/" + page + "/" + pagesize + "/" + zxtypeid;
		}else{
			url = REST_BASE_URL + ZIXUNLIST_URL + "/" + page + "/" + pagesize ;
		}
		try {
			String json = HttpClientUtil
					.doGet(url);
			if (!StringUtils.isBlank(json)) {
				
				JSONObject jsonObject = JSONObject.fromObject(json);
				String jsonComments = jsonObject.getString("list");
				jsonComments = jsonComments+"}";
				List<ZiXunInfo> zxList = JsonUtils.jsonToList(jsonComments, ZiXunInfo.class);
				@SuppressWarnings("unchecked")
				PageBean<ZiXunInfo> pageBean = JsonUtils.jsonToPojo(json, PageBean.class);
				pageBean.setList(zxList);
				return pageBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public Integer addZiXunBrowse(TZxbrowserecord zxbrowserecord) {
		String strJson = JsonUtils.objectToJson(zxbrowserecord);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + ZIXUN_BROWSE_RUL, strJson);
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
