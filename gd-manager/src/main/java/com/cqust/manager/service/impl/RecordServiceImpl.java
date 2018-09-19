package com.cqust.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.manager.mapper.ProductBrowseMapper;
import com.cqust.manager.pojo.ProductBrowseRecord;
import com.cqust.manager.service.RecordService;
import com.cqust.mapper.TPotalbrowserecordMapper;
import com.cqust.mapper.TSearchrecordMapper;
import com.cqust.mapper.TUserlogMapper;
import com.cqust.mapper.TZxbrowserecordMapper;
import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.pojo.TPotalbrowserecordExample;
import com.cqust.pojo.TSearchrecord;
import com.cqust.pojo.TSearchrecordExample;
import com.cqust.pojo.TUserlog;
import com.cqust.pojo.TUserlogExample;
import com.cqust.pojo.TZxbrowserecord;
import com.cqust.pojo.TZxbrowserecordExample;
@Service
public class RecordServiceImpl implements RecordService {
    
	@Autowired
	TUserlogMapper tUserlogMapper;
	@Autowired
	ProductBrowseMapper productBrowseMapper;
	@Autowired
	TSearchrecordMapper tSearchrecordMapper;
	@Autowired
	TZxbrowserecordMapper tZxbrowserecordMapper;
	@Autowired
	TPotalbrowserecordMapper tPotalbrowserecordMapper;
	
	@Override
	public List<TUserlog> getuserlogrecord() {
		TUserlogExample example = new TUserlogExample();
		List<TUserlog> tUserlogs = tUserlogMapper.selectByExample(example);		
		return tUserlogs;
	}

	@Override
	public List<ProductBrowseRecord> getproductrecord() {		
		List<ProductBrowseRecord> tPbrowserecords = productBrowseMapper.getproductrecord();		
		return tPbrowserecords;
	}

	@Override
	public List<TSearchrecord> getsearchrecord() {
		TSearchrecordExample example = new TSearchrecordExample();
		List<TSearchrecord> tSearchrecords = tSearchrecordMapper.selectByExample(example);
		return tSearchrecords;
	}

	@Override
	public List<TZxbrowserecord> getzxrecord() {
		TZxbrowserecordExample example = new TZxbrowserecordExample();
		List<TZxbrowserecord> tZxbrowserecords = tZxbrowserecordMapper.selectByExample(example);
		return tZxbrowserecords;
	}

	@Override
	public List<TPotalbrowserecord> getpotalbrowserecord() {
		TPotalbrowserecordExample example = new TPotalbrowserecordExample();
		List<TPotalbrowserecord> tPotalbrowserecords = tPotalbrowserecordMapper.selectByExample(example);
		return tPotalbrowserecords;
	}

}
