package com.cqust.portal.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TProduct;
import com.cqust.portal.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	/**
	 * @Fields REST_BASE_URL : 服务基层url
	 */
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	/**
	 * @Fields HOTITEM_URL : 热门商品url
	 */
	@Value("${HOTITEM_URL}")
	private String HOTITEM_URL;

	/**
	 * @Fields HOTITEM_BY_TYPE : 热门商品根据商品类型url
	 */
	@Value("${HOTITEM_BY_TYPE}")
	private String HOTITEM_BY_TYPE;

	@Value("${ITEM_PANICBUYITEMS_URL}")
	private String ITEM_PANICBUYITEMS_URL;
	
	@Value("${ITEM_BESTSELLSERITEMS_URL}")
	private String ITEM_BESTSELLSERITEMS_URL;
	
	@Value("${ITEM_NEWESTITEMS_URL}")
	private String ITEM_NEWESTITEMS_URL;
	
	@Value("${ITEM_COMMENTITESM_URL}")
	private String ITEM_COMMENTITESM_URL;
	
	@Value("${ITEM_USERLIKEITEMS_URL}")
	private String ITEM_USERLIKEITEMS_URL;

	@Override
	public List<TProduct> getHotItemList() {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + HOTITEM_URL);
			if (!StringUtils.isBlank(json)) {
				GdResult result = GdResult.formatToList(json, TProduct.class);
				if (result.getStatus() == 200) {
					@SuppressWarnings("unchecked")
					List<TProduct> hotItemList = (List<TProduct>) result.getData();
					return hotItemList;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<TProduct> getHotItemListByType(String itemType) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + HOTITEM_BY_TYPE + "/" + itemType);
			if (!StringUtils.isBlank(json)) {
				GdResult result = GdResult.formatToList(json, TProduct.class);
				if (result.getStatus() == 200) {
					@SuppressWarnings("unchecked")
					List<TProduct> hotItemList = (List<TProduct>) result.getData();
					return hotItemList;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<TProduct> bestSellersItems() {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_BESTSELLSERITEMS_URL);
			if (!StringUtils.isBlank(json)) {
				List<TProduct> list = JsonUtils.jsonToList(json, TProduct.class);
				return list;
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<TProduct> newestItems() {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_NEWESTITEMS_URL);
			if (!StringUtils.isBlank(json)) {
				List<TProduct> list = JsonUtils.jsonToList(json, TProduct.class);
				return list;
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<TProduct> commentItems() {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_COMMENTITESM_URL);
			if (!StringUtils.isBlank(json)) {
				List<TProduct> list = JsonUtils.jsonToList(json, TProduct.class);
				return list;
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<TProduct> panicBuyItems() {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PANICBUYITEMS_URL);
			if (!StringUtils.isBlank(json)) {
				List<TProduct> list = JsonUtils.jsonToList(json, TProduct.class);
				return list;
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<TProduct> userlikeItems(Integer uid) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_USERLIKEITEMS_URL+uid);
			if (!StringUtils.isBlank(json)) {
				List<TProduct> list = JsonUtils.jsonToList(json, TProduct.class);
				return list;
			}
		} catch (Exception e) {
		}
		return null;
	}

}
