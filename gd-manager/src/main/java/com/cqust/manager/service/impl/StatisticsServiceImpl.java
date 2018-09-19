package com.cqust.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.manager.service.StatisticsService;
import com.cqust.manager.util.DateUtil;
import com.cqust.mapper.TOrderMapper;
import com.cqust.mapper.TPbrowserecordMapper;
import com.cqust.mapper.TPotalbrowserecordMapper;
import com.cqust.mapper.TSearchrecordMapper;
import com.cqust.mapper.TUserlogMapper;
import com.cqust.mapper.TZxbrowserecordMapper;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderExample;
import com.cqust.pojo.TPbrowserecordExample;
import com.cqust.pojo.TPbrowserecordExample.Criteria;
import com.cqust.pojo.TPotalbrowserecordExample;
import com.cqust.pojo.TSearchrecordExample;
import com.cqust.pojo.TUserlogExample;
import com.cqust.pojo.TZxbrowserecordExample;

@Service
public class StatisticsServiceImpl	implements StatisticsService {
	
	@Autowired
	private TPbrowserecordMapper pbrowserecordMapper;
	
	@Autowired
	private TUserlogMapper userlogMapper;
	
	@Autowired 
	private TOrderMapper orderMapper;
	
	@Autowired
	private TZxbrowserecordMapper zxbrowserecordMapper;
	
	@Autowired
	private TPotalbrowserecordMapper potalbrowserecordMapper;
	
	@Autowired
	private TSearchrecordMapper searchmapper;

	@Override
	public List<Integer> pbrowseStatistics(Integer datenum) {
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			TPbrowserecordExample example = new TPbrowserecordExample();
			Criteria criteria = example.createCriteria();
			criteria.andBrowsetimeBetween(beginDate, endDate);
			int count = pbrowserecordMapper.countByExample(example);
			list.add(count);
		}
		return list;
	}

	@Override
	public List<Double> orderStatistics(Integer datenum) {
		List<Double> list = new ArrayList<>();
		double sum = 0;
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			TOrderExample example = new TOrderExample();
			com.cqust.pojo.TOrderExample.Criteria criteria = example.createCriteria();
			criteria.andOrdertimeBetween(beginDate, endDate);
			List<TOrder> orders = orderMapper.selectByExample(example);
			if(orders != null & orders.size() > 0){
				for(int j=0;j<orders.size();j++){
					sum += orders.get(j).getTotal();
				}
				list.add(sum);
				sum =0;
			}
		}
		return list;
	}

	@Override
	public List<Integer> userloginStatistics(Integer datenum) {
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			TUserlogExample example = new TUserlogExample();
			com.cqust.pojo.TUserlogExample.Criteria criteria = example.createCriteria();
			criteria.andLogindateBetween(beginDate, endDate);
			int count = userlogMapper.countByExample(example);
			list.add(count);
		}
		return list;
	}

	@Override
	public List<Integer> searchStatistics(Integer datenum) {
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			TSearchrecordExample example = new TSearchrecordExample();
			com.cqust.pojo.TSearchrecordExample.Criteria criteria = example.createCriteria();
			criteria.andSearchtimeBetween(beginDate, endDate);
			int count = searchmapper.countByExample(example);
			list.add(count);
		}
		return list;
	}

	@Override
	public List<Integer> potalStatistics(Integer datenum) {
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			TPotalbrowserecordExample example = new TPotalbrowserecordExample();
			com.cqust.pojo.TPotalbrowserecordExample.Criteria criteria = example.createCriteria();
			criteria.andBrowsetimeBetween(beginDate, endDate);
			int count = potalbrowserecordMapper.countByExample(example);
			list.add(count);
		}
		return list;
	}

	@Override
	public List<Integer> zixunStatistics(Integer datenum) {
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<datenum+1;i++){
			Date beginDate = DateUtil.getPastBeginDate(i);
			Date endDate = DateUtil.getPastEndDate(i);
			TZxbrowserecordExample example = new TZxbrowserecordExample();
			com.cqust.pojo.TZxbrowserecordExample.Criteria criteria = example.createCriteria();
			criteria.andBrowsetimeBetween(beginDate, endDate);
			int count = zxbrowserecordMapper.countByExample(example);
			list.add(count);
		}
		return list;
	}

}
