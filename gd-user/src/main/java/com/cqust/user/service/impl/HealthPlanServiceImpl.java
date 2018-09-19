package com.cqust.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TDietplanbyselfMapper;
import com.cqust.mapper.TPlanindexbyselfMapper;
import com.cqust.mapper.TSportplanbyselfMapper;
import com.cqust.pojo.TDietplanbyself;
import com.cqust.pojo.TDietplanbyselfExample;
import com.cqust.pojo.TPlanindexbyself;
import com.cqust.pojo.TSportplanbyself;
import com.cqust.pojo.TSportplanbyselfExample;
import com.cqust.user.mapper.HealthPlanMapper;
import com.cqust.user.service.HealthPlanService;
@Service
public class HealthPlanServiceImpl implements HealthPlanService {
	@Autowired
	TDietplanbyselfMapper tDietplanbyselfMapper;
	@Autowired
	TSportplanbyselfMapper tSportplanbyselfMapper;
	@Autowired
	HealthPlanMapper healthPlanMapper;
    @Autowired
    TPlanindexbyselfMapper tPlanindexbyselfMapper;
	@Override
	/**
	 * 添加饮食计划
	 */
	public GdResult addFoodplan(TDietplanbyself tDietplanbyself) {	
		if (tDietplanbyselfMapper.insertSelective(tDietplanbyself) == 1) {
			return GdResult.build(200, "添加成功!");
		}
		return GdResult.build(400, "添加失败!");
	}

	/**
	 * 添加运动计划
	 */
	@Override
	public GdResult addSportplan(TSportplanbyself tSportplanbyself) {
	    if(tSportplanbyselfMapper.insertSelective(tSportplanbyself)==1){
	    	return GdResult.build(200, "添加成功!");
	    }
	    return GdResult.build(400, "添加失败!");	
	}
	
    /**
     * 添加饮食计划索引
     */
	@Override
	public GdResult addFoodplanIndex(TPlanindexbyself tPlanindexbyself) {	    
		if(tPlanindexbyselfMapper.insertSelective(tPlanindexbyself)==1)
			return GdResult.build(200, "添加成功!");
		else
			return GdResult.build(400, "添加失败!");		
	}
	 /**
     * 修改饮食计划索引
     */
	@Override
	public GdResult updateFoodplanIndex(TPlanindexbyself tPlanindexbyself) {
		if(tPlanindexbyselfMapper.updateByPrimaryKeySelective(tPlanindexbyself)==1)
			return GdResult.build(200, "修改成功!");
		else
			return GdResult.build(400, "修改失败!");	
		
	}
    /**
     * 获取最新的饮食计划索引
     */
	@Override
	public TPlanindexbyself getFoodplanIndex() {
		TPlanindexbyself tPlanindexbyself = healthPlanMapper.getFoodplanIndex();
		return tPlanindexbyself;
	}
    
	/**
     * 获取最新的运动计划索引
     */
	@Override
	public TPlanindexbyself getSportplanIndex() {
		TPlanindexbyself tPlanindexbyself = healthPlanMapper.getSportplanIndex();
		return tPlanindexbyself;
	}
	
	/**
	 * 根据用户id获取饮食计划索引
	 */
	@Override
	public List<TPlanindexbyself> getdietplanindex(Integer id) {
		List<TPlanindexbyself> tPlanindexbyselfs = healthPlanMapper.getdietplanindex(id);
		return tPlanindexbyselfs;
	}
    
	/**
	 * 根据用户id获取运动计划索引
	 */
	@Override
	public List<TPlanindexbyself> getsportplanindex(Integer id) {
		List<TPlanindexbyself> tPlanindexbyselfss = healthPlanMapper.getsportplanindex(id);
		return tPlanindexbyselfss;
	}
    
	/**
	 * 根据饮食计划索引获取每一天的饮食计划
	 */
	@Override
	public List<TDietplanbyself> geteverydaydietplan(Integer uid, Integer planid, Date plandate) {
		TDietplanbyselfExample example = new TDietplanbyselfExample();
		com.cqust.pojo.TDietplanbyselfExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid).andPlanidEqualTo(planid).andPlandateEqualTo(plandate);	
		List<TDietplanbyself> tDietplans = tDietplanbyselfMapper.selectByExample(example);
		return tDietplans;
	}
    /**
    * 根据运动计划索引获取每一天的运动计划
    */
	@Override
	public List<TSportplanbyself> geteverydaysportplan(Integer uid, Integer planid, Date plandate) {
		TSportplanbyselfExample example = new TSportplanbyselfExample();
		com.cqust.pojo.TSportplanbyselfExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid).andPlanidEqualTo(planid).andPlandateEqualTo(plandate);	
		List<TSportplanbyself> tSportplans = tSportplanbyselfMapper.selectByExample(example);
		return tSportplans;
	}
    /**
     * 根据用户id和日期获取饮食计划索引（获取今日饮食计划）
     */
	@Override
	public List<TPlanindexbyself> getdietplanindexBydate(Integer id, String date) {
		List<TPlanindexbyself> tPlanindexbyselfs = healthPlanMapper.getdietplanindexBydate(id, date);
		return tPlanindexbyselfs;
	}
    /**
     * 根据用户id和日期获取运动计划索引（获取今日运动计划）
     */
	@Override
	public List<TPlanindexbyself> getsportplanindexBydate(Integer id, String date) {
		List<TPlanindexbyself> tPlanindexbyselfss = healthPlanMapper.getsportplanindexBydate(id, date);
		return tPlanindexbyselfss;
	}
	
	
	
}
