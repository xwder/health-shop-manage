package com.cqust.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TStoreinfoMapper;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TStoreinfoExample;
import com.cqust.pojo.TStoreinfoExample.Criteria;
import com.cqust.rest.service.StoreinfoService;

@Service
public class StoreinfoServiceImpl implements StoreinfoService{
	
	@Autowired
	private TStoreinfoMapper storeMapper;

	@Override
	public List<TStoreinfo> storeinfosByStype(String stype) {
		TStoreinfoExample example = new TStoreinfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andStypeLike(stype);
		
		List<TStoreinfo> list = storeMapper.selectByExample(example);
		return list;
	}

}
