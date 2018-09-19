package com.cqust.mshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TStoreinfoMapper;
import com.cqust.mshop.dao.JedisClient;
import com.cqust.mshop.service.StoreService;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TStoreinfoExample;
import com.cqust.pojo.TStoreinfoExample.Criteria;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Value("${REDIS_STORE_KEY}")
	private String REDIS_STORE_KEY;
	@Value("${REDIS_STORE_EXPIRE}")
	private Integer REDIS_STORE_EXPIRE;
	
	@Autowired
	private JedisClient jedisClient;

	@Autowired
	private TStoreinfoMapper storeMapper;

	@Override
	public TStoreinfo geTStoreinfoByUserid(Integer uid) {
		TStoreinfoExample example = new TStoreinfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsCheckEqualTo(1);
		criteria.andUseridEqualTo(uid);

		List<TStoreinfo> list =  storeMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer updateStoreinfo(TStoreinfo storeinfo) {
		try {
			//设置key的有效期
			jedisClient.expire(REDIS_STORE_KEY + ":" + storeinfo.getId() + ":base", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int result = storeMapper.updateByPrimaryKeySelective(storeinfo);
		
		return result;
	}

}
