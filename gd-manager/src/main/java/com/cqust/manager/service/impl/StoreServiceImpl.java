package com.cqust.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.manager.service.StoreService;
import com.cqust.mapper.TStoreinfoMapper;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TStoreinfoExample;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private TStoreinfoMapper storeinfoMapper;

	@Override
	public List<TStoreinfo> getStores() {
		TStoreinfoExample example = new TStoreinfoExample();
		List<TStoreinfo> list = storeinfoMapper.selectByExample(example);
		return list;
	}

}
