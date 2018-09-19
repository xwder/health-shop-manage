package com.cqust.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TProductMapper;
import com.cqust.pojo.TProduct;
import com.cqust.rest.dao.JedisClient;
import com.cqust.rest.mapper.ItemMapper;
import com.cqust.rest.pojo.CustomItem;
import com.cqust.rest.service.ItemService;
import com.github.pagehelper.PageHelper;

@Service
public class ItemServiceImpl implements ItemService {

	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;
	@Value("${REDIS_ITEMCOLLOCATION_KEY}")
	private String REDIS_ITEMCOLLOCATION_KEY;
	@Value("${REDIS_ITEMCOLLOCATION_EXPIRE}")
	private Integer REDIS_ITEMCOLLOCATION_EXPIRE;

	@Autowired
	private JedisClient jedisClient;

	@Autowired
	private TProductMapper productMapper;

	@Autowired
	private ItemMapper customItemMapper;

	@Override
	public TProduct getItemInfo(Integer itemId) {
		try {
			// 添加缓存逻辑
			// 从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":base");
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				TProduct item = JsonUtils.jsonToPojo(json, TProduct.class);
				return item;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据商品id查询商品信息
		TProduct item = productMapper.selectByPrimaryKey(itemId);
		try {
			// 把商品信息写入缓存
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":base", JsonUtils.objectToJson(item));
			// 设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":base", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}

	@Override
	public List<TProduct> getHotItemList() {
		return customItemMapper.getHotItemList();
	}

	@Override
	public List<TProduct> getHotItemListByType(String itemType) {
		PageHelper.startPage(1, 6);
		List<TProduct> list = customItemMapper.getHotItemListByType(itemType);
		return list;
	}

	@Override
	public List<TProduct> bestSellersItems() {
		PageHelper.startPage(1, 6);
		List<TProduct> list = customItemMapper.bestSellersItems();
		return list;
	}

	@Override
	public List<TProduct> newestItems() {
		PageHelper.startPage(1, 6);
		List<TProduct> list = customItemMapper.newestItems();
		return list;
	}

	@Override
	public List<TProduct> commentItems() {
		PageHelper.startPage(1, 6);
		List<CustomItem> customItems = customItemMapper.commentItems();
		List<TProduct> list = new ArrayList<>();
		if (customItems != null && customItems.size() > 0) {
			for (int i = 0; i < customItems.size(); i++) {
				TProduct product = new TProduct();
				product = getItemInfo(customItems.get(i).getPid());
				list.add(product);
			}
		}

		return list;
	}

	@Override
	public List<TProduct> panicBuyItems() {
		PageHelper.startPage(1, 6);
		List<CustomItem> customItems = customItemMapper.panicBuyItems();
		List<TProduct> list = new ArrayList<>();
		if (customItems != null && customItems.size() > 0) {
			for (int i = 0; i < customItems.size(); i++) {
				TProduct product = new TProduct();
				product = getItemInfo(customItems.get(i).getPid());
				list.add(product);
			}
		}
		return list;
	}

	@Override
	public List<TProduct> userlikeItems(Integer uid) {
		PageHelper.startPage(1, 6);
		List<CustomItem> customItems = customItemMapper.userlikeItems(uid);
		List<TProduct> list = new ArrayList<>();
		if (customItems != null && customItems.size() > 0) {
			for (int i = 0; i < customItems.size(); i++) {
				TProduct product = new TProduct();
				product = getItemInfo(customItems.get(i).getPid());
				list.add(product);
			}
		}
		if (list != null && list.size() < 6) {
			List<TProduct> items = bestSellersItems();
			for(int i = list.size();i<6;i++){
				list.add(items.get(i));
			}
		}
		return list;
	}

}
