package com.cqust.shop.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TPcomment;
import com.cqust.shop.service.CommentService;

import net.sf.json.JSONObject;

@Service
public class CommentServiceImpl implements CommentService {

	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	@Value("${COMMENTS}")
	private String COMMENTS;

	@Override
	public PageBean<TPcomment> getPcommentPages(Integer pid, Integer pagenum, Integer pagesize) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + COMMENTS + pid + "/" + pagenum + "/" + pagesize);
			if (!StringUtils.isBlank(json)) {
				JSONObject jsonObject = JSONObject.fromObject(json);
				String jsonComments = jsonObject.getString("list");
				jsonComments = jsonComments+"}";
				List<TPcomment> pcomments = JsonUtils.jsonToList(jsonComments, TPcomment.class);
				@SuppressWarnings("unchecked")
				PageBean<TPcomment> pageBean = JsonUtils.jsonToPojo(json, PageBean.class);
				pageBean.setList(pcomments);
				return pageBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
