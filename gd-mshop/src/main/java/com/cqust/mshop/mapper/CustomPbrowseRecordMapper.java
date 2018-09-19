package com.cqust.mshop.mapper;

import java.util.List;

import com.cqust.mshop.pojo.CustomPbrowseRecord;

public interface CustomPbrowseRecordMapper {
	
	List<CustomPbrowseRecord> getPbrowseRecordList(Integer sid);

}
