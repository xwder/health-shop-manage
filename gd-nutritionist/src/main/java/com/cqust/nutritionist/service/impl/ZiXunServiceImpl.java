package com.cqust.nutritionist.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.nutritionist.pojo.ZiXunInfo;
import com.cqust.nutritionist.service.ZiXunService;
import com.cqust.pojo.TZxinfo;
import com.cqust.pojo.TZxtype;

@Service
public class ZiXunServiceImpl implements ZiXunService {

	/**
	 * @Fields REST_BASE_URL : 服务基层url
	 */
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	/**
	 * @Fields ZIXUNTYPE_URL : 资讯类型url
	 */
	@Value("${ZIXUNTYPE_URL}")
	private String ZIXUNTYPE_URL;
	
	/**
	 * @Fields ZIXUN_URL : 资讯url
	 */
	@Value("${ZIXUN_URL}")
	private String ZIXUN_URL;

	/**
	 * @Fields ZIXUNBYID_URL : 根据id获取某一条资讯url
	 */
	@Value("${ZIXUNBYID_URL}")
	private String ZIXUNBYID_URL;
	
	/**
	 * @Fields ADDZIXUN_URL : 添加资讯url
	 */
	@Value("${ADDZIXUN_URL}")
	private String ADDZIXUN_URL;
 
	/**
	 * @Fields UPDATEZIXUN_URL : 修改资讯url
	 */
	@Value("${UPDATEZIXUN_URL}")
	private String UPDATEZIXUN_URL;
	
	/**
	 * @Fields DELZIXUN_URL : 删除资讯url
	 */
	@Value("${DELZIXUN_URL}")
	private String DELZIXUN_URL;
	
	@Override
	public List<ZiXunInfo> getzixuninfos(Integer page, Integer pagesize, Integer type,String name) {
		String json=null;
		if (type != null) {	
			json = HttpClientUtil.doGet(REST_BASE_URL + ZIXUN_URL + "/" + page + "/" + pagesize+"/"+type);	
						
		} else {			
			json = HttpClientUtil.doGet(REST_BASE_URL + ZIXUN_URL + "/" + page + "/" + pagesize);	
		}
		try {
			if (!StringUtils.isBlank(json)) {
				List<ZiXunInfo> tZxinfos = JsonUtils.jsonToList(json, ZiXunInfo.class);
				//每个营养师只能获取自己编写的资讯
				List<ZiXunInfo> list = new ArrayList<ZiXunInfo>();
				for(int i=0;i<tZxinfos.size();i++){
					if(tZxinfos.get(i).getAuthor().equals(name))
						list.add(tZxinfos.get(i));
				}
				return list;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
}

	@Override
	public ZiXunInfo getSinglezixun(Integer id) {		
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ZIXUNBYID_URL + "/" + id);	
			if (!StringUtils.isBlank(json)) {
				ZiXunInfo tZxinfo = JsonUtils.jsonToPojo(json, ZiXunInfo.class);
				return tZxinfo;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GdResult delzixun(Integer id) {
		String strJson = JsonUtils.objectToJson(id);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + DELZIXUN_URL, strJson);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = JsonUtils.jsonToPojo(json, GdResult.class);
				return gdResult;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GdResult.build(400, "删除失败!");
	}

	@Override
	public GdResult addzixun(TZxinfo record) {	
		String strJson = JsonUtils.objectToJson(record);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + ADDZIXUN_URL, strJson);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = JsonUtils.jsonToPojo(json, GdResult.class);
				return gdResult;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GdResult.build(400, "添加失败!");
	}

	@Override
	public GdResult updatezixun(TZxinfo record) {	
		String strJson = JsonUtils.objectToJson(record);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + UPDATEZIXUN_URL, strJson);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = JsonUtils.jsonToPojo(json, GdResult.class);
				return gdResult;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GdResult.build(400, "修改失败!");
	}

	@Override
	public List<TZxtype> getzxtype() {		
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ZIXUNTYPE_URL);	
			if (!StringUtils.isBlank(json)) {
				List<TZxtype> tZxtypes= JsonUtils.jsonToList(json, TZxtype.class);
				return tZxtypes;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
	}    
}