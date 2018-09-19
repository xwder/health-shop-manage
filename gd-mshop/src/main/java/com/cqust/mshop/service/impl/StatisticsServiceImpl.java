package com.cqust.mshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TPbrowserecordMapper;
import com.cqust.mshop.mapper.CustomOrderMapper;
import com.cqust.mshop.service.StatisticsService;
import com.cqust.mshop.util.DateUtil;
import com.cqust.pojo.TPbrowserecordExample;
import com.cqust.pojo.TPbrowserecordExample.Criteria;

@Service
public class StatisticsServiceImpl implements StatisticsService{
	
	@Autowired
	private TPbrowserecordMapper pbrowserecordMapper;
	
	@Autowired 
	private CustomOrderMapper customOrderMapper;

	@Override
	public List<Integer> pbrowseStatistics(Integer sid,Integer datenum) {
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			TPbrowserecordExample example = new TPbrowserecordExample();
			Criteria criteria = example.createCriteria();
			criteria.andSidEqualTo(sid);
			criteria.andBrowsetimeBetween(beginDate, endDate);
			int count = pbrowserecordMapper.countByExample(example);
			list.add(count);
		}
		return list;
	}

	@Override
	public List<Double> orderStatistics(Integer sid,Integer datenum) {
		List<Double> list = new ArrayList<>();
		Map<Object, Object> map = new HashMap<>();
		map.put("sid", sid);
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			map.put("beginDate", beginDate);
			map.put("endDate", endDate);
			Double  count = customOrderMapper.sumOrderTotal(map);
			if(count == null){
				list.add(0.0);
			}else{
				list.add(count);
			}
		}
		return list;
	}

}
