package com.cqust.user.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TStoreinfo;
import com.cqust.user.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	@Value("${ORDER_BY_ID}")
	private String ORDER_BY_ID;

	@Value("${ORDERITEM_BY_ID}")
	private String ORDERITEM_BY_ID;

	@Value("${STORE_BY_ID}")
	private String STORE_BY_ID;

	@Value("${UPDATE_ORDERITEMSTATUS}")
	private String UPDATE_ORDERITEMSTATUS;

	@Value("${ADDCOMMENT}")
	private String ADDCOMMENT;

	@Value("${PCOMMENT_ORDERITEMID}")
	private String PCOMMENT_ORDERITEMID;

	@Override
	public TOrderitem getTOrderItemById(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ORDERITEM_BY_ID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TOrderitem.class);
				if (gdResult.getStatus() == 200) {
					return (TOrderitem) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public TStoreinfo getStoreinfoById(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + STORE_BY_ID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TStoreinfo.class);
				if (gdResult.getStatus() == 200) {
					return (TStoreinfo) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public TOrder getOrderByid(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ORDER_BY_ID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TOrder.class);
				if (gdResult.getStatus() == 200) {
					return (TOrder) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public Integer updateOrderItemStatusById(TOrderitem orderitem) {
		String strJson = JsonUtils.objectToJson(orderitem);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + UPDATE_ORDERITEMSTATUS, strJson);
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

	@Override
	public Integer addPComment(TPcomment pcomment) {
		String strJson = JsonUtils.objectToJson(pcomment);
		try {
			String json = HttpClientUtil.doPostJson(REST_BASE_URL + ADDCOMMENT, strJson);
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

	@Override
	public TPcomment geTPcommentByOrderItemId(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + PCOMMENT_ORDERITEMID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TPcomment.class);
				if (gdResult.getStatus() == 200) {
					return (TPcomment) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
