package com.cqust.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TZxbrowserecordMapper;
import com.cqust.pojo.TZxbrowserecord;
import com.cqust.rest.service.ZxBrowseService;

@Service
public class ZxBrowseServiceImpl implements ZxBrowseService{
	
	@Autowired
	private TZxbrowserecordMapper zxBrewseMapper;

	@Override
	public Integer addZxBrowseRecord(TZxbrowserecord zxbrowserecord) {
		
		if(zxbrowserecord != null){
			return zxBrewseMapper.insert(zxbrowserecord);
		}
		
		return 0;
	}

}
