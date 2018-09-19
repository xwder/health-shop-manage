package com.cqust.shop.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TStoreinfoMapper;
import com.cqust.pojo.TStoreinfo;
import com.cqust.shop.dao.JedisClient;
import com.cqust.shop.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Value("${REDIS_STORE_KEY}")
	private String REDIS_STORE_KEY;
	@Value("${REDIS_STORE_EXPIRE}")
	private Integer REDIS_STORE_EXPIRE;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Autowired
	TStoreinfoMapper storeMapper;

	@Override
	public TStoreinfo getStoreInfoId(Integer storeid) {
		try {
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_STORE_KEY + ":" + storeid + ":base");
			//判断是否有值
			if (!StringUtils.isBlank(json)) {
				//把json转换成java对象
				TStoreinfo storeinfo = JsonUtils.jsonToPojo(json, TStoreinfo.class);
				return storeinfo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据商品id查询商品信息
		TStoreinfo storeinfo = storeMapper.selectByPrimaryKey(storeid);
		try {
			//把商品信息写入缓存
			jedisClient.set(REDIS_STORE_KEY + ":" + storeid + ":base", JsonUtils.objectToJson(storeinfo));
			//设置key的有效期
			jedisClient.expire(REDIS_STORE_KEY + ":" + storeid + ":base", REDIS_STORE_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storeinfo;
	}

}
