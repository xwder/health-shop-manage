package com.cqust.shop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.ItemCollocationUtil;
import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TItemcollocationMapper;
import com.cqust.mapper.TProductMapper;
import com.cqust.pojo.TItemcollocation;
import com.cqust.pojo.TItemcollocationExample;
import com.cqust.pojo.TItemcollocationExample.Criteria;
import com.cqust.pojo.TProduct;
import com.cqust.shop.dao.JedisClient;
import com.cqust.shop.mapper.MyItemMapper;
import com.cqust.shop.pojo.ItemInfo;
import com.cqust.shop.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl  implements ItemService{

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
	private MyItemMapper myItemMapper;
	
	@Autowired 
	private TItemcollocationMapper itemcollocationMapper;
	
	
	@Override
	public TProduct getItemBaseInfo(Integer itemId) {
		try {
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":base");
			//判断是否有值
			if (!StringUtils.isBlank(json)) {
				//把json转换成java对象
				TProduct item = JsonUtils.jsonToPojo(json, TProduct.class);
				return item;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据商品id查询商品信息
		TProduct item = productMapper.selectByPrimaryKey(itemId);
		try {
			//把商品信息写入缓存
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":base", JsonUtils.objectToJson(item));
			//设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":base", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}

	@Override
	public PageBean<ItemInfo> getItemList(Map<Object, Object> map) {		
		if(map.get("page") == null){
			map.put("page",1);
		}
		PageHelper.startPage((Integer)map.get("page"), (Integer)map.get("rows"));
		
		List<ItemInfo> list = myItemMapper.getItemList(map);
		
		PageBean<ItemInfo> result = new PageBean<>();
		result.setList(list);
		PageInfo<ItemInfo> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		result.setPageSize((Integer)map.get("rows"));
		Integer t=  (int) pageInfo.getTotal();
		if(t % (Integer)map.get("rows") == 0){
			result.setPages(t/(Integer)map.get("rows"));
		}else{
			result.setPages(t/(Integer)map.get("rows")+1);
		}
		result.setPageNum((Integer)map.get("page"));
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TProduct> getItemCollocations(Integer itemId) {
		
		try {
			//添加缓存逻辑
			//从缓存中取商品推荐信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEMCOLLOCATION_KEY+ ":" + itemId + ":base");
			//判断是否有值
			if (!StringUtils.isBlank(json)) {
				//把json转换成java对象
				GdResult gdResult  = JsonUtils.jsonToPojo(json, GdResult.class);
				return (List<TProduct>) gdResult.getData();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据商品id查询商品推荐信息
		TItemcollocationExample example = new TItemcollocationExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(itemId);
		List<TItemcollocation> list = itemcollocationMapper.selectByExample(example);
		if(list.size() > 0 & list != null){
			TItemcollocation itemcollocation = list.get(0);
			ItemCollocationUtil itemCollocationUtil =  JsonUtils.jsonToPojo(itemcollocation.getCollocation(), ItemCollocationUtil.class);
			List<TProduct> itemList = new ArrayList<>();
			if(itemCollocationUtil != null && itemCollocationUtil.getList().size() > 0){
				for(int i = 0; i<itemCollocationUtil.getList().size();i++){
					TProduct product = new TProduct();
					product = productMapper.selectByPrimaryKey(itemCollocationUtil.getList().get(i));
					itemList.add(product);
				}
			}
			try {
				//把商品信息写入缓存
				jedisClient.set(REDIS_ITEMCOLLOCATION_KEY + ":" + itemId + ":base", JsonUtils.objectToJson(GdResult.ok(itemList)));
				//设置key的有效期
				jedisClient.expire(REDIS_ITEMCOLLOCATION_EXPIRE + ":" + itemId + ":base", REDIS_ITEMCOLLOCATION_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return itemList;
		}
		return null;
	}

	@Override
	public List<TProduct> getItemsBySellCount(String sortType,Integer sid) {
		Map<Object, Object> map = new HashMap<>();
		map.put("sortType", sortType);
		map.put("sid", sid);
		List<TProduct> list = null;
		list = myItemMapper.getItemsBySellCount(sortType,sid);
		return list;
	}
}
