package com.cqust.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TSearchrecordMapper;
import com.cqust.pojo.TSearchrecord;
import com.cqust.rest.service.PSearchRecordService;

@Service
public class PSearchRecordServiceImpl implements PSearchRecordService {
	
	@Autowired
	private TSearchrecordMapper searchrecordMapper;

	@Override
	public Integer addSearchRecord(TSearchrecord searchrecord) {
		if(searchrecord != null)
			return searchrecordMapper.insert(searchrecord);
		return 0;
	}

}
