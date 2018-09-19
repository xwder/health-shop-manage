package com.cqust.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TPotalbrowserecordMapper;
import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.rest.service.PotalBrowseService;

@Service
public class PotalBrowseServiceImpl implements PotalBrowseService{
	
	@Autowired
	private TPotalbrowserecordMapper potalbrowserecordMapper;

	@Override
	public Integer addPotalBrowse(TPotalbrowserecord potalbrowserecord) {
		
		return potalbrowserecordMapper.insert(potalbrowserecord);
	}

}
