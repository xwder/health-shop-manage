package com.cqust.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TSportsoptionMapper;
import com.cqust.user.service.PlanItemService;
import com.cqust.pojo.TSportsoption;
import com.cqust.pojo.TSportsoptionExample;
@Service
public class PlanItemServiceImpl implements PlanItemService {
    @Autowired
    TSportsoptionMapper tSportsoptionMapper;
    
	/**
	 * 获取全部的运动项目
	 */
	@Override
	public GdResult getSportItem() {
		// TODO Auto-generated method stub
		TSportsoptionExample example = new TSportsoptionExample();
		try{
			List<TSportsoption> tSportsoptions = tSportsoptionMapper.selectByExample(example);
			if(tSportsoptions!=null)
				return GdResult.build(200, "获取成功!",tSportsoptions);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return GdResult.build(400, "获取失败!",null);
	}
    
	/**
	 * 根据id获取某一项运动项目
	 */
	@Override
	public GdResult getSportItemById(Integer id) {
		
		try {
			TSportsoption tSportsoption = tSportsoptionMapper.selectByPrimaryKey(id);
			if(tSportsoption!=null)
				return GdResult.build(200, "获取成功!",tSportsoption);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return GdResult.build(400, "获取失败!",null);
	}

}
