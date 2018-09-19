package com.cqust.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TPbrowserecordMapper;
import com.cqust.pojo.TPbrowserecord;
import com.cqust.rest.service.PBrowseService;

@Service
public class PBrowseServiceImpl implements PBrowseService {

	@Autowired
	private TPbrowserecordMapper pBrowserecordMapper;

	@Override
	public Integer addPBrowseRecord(TPbrowserecord pbrowserecord) {

		return pBrowserecordMapper.insert(pbrowserecord);
	}

}
