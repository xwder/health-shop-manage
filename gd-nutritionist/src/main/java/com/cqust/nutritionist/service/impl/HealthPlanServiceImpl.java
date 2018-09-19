package com.cqust.nutritionist.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TDietplanMapper;
import com.cqust.mapper.TPlanindexMapper;
import com.cqust.mapper.TSportplanMapper;
import com.cqust.nutritionist.mapper.HealthPlanMapper;
import com.cqust.nutritionist.service.HealthPlanService;
import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TDietplanExample;
import com.cqust.pojo.TDietplanExample.Criteria;
import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TSportplan;
import com.cqust.pojo.TSportplanExample;
import com.cqust.pojo.TUserhealthinfo;
@Service
public class HealthPlanServiceImpl implements HealthPlanService {
	@Autowired
	TDietplanMapper tDietplanMapper;
	@Autowired
	TSportplanMapper tSportplanMapper;
	@Autowired
	HealthPlanMapper healthPlanMapper;
    @Autowired
    TPlanindexMapper tPlanindexMapper;
	@Override
	/**
	 * 添加饮食计划
	 */
	public GdResult addFoodplan(TDietplan tDietplan) {	
		if (tDietplanMapper.insertSelective(tDietplan) == 1) {
			return GdResult.build(200, "添加成功!");
		}
		return GdResult.build(400, "添加失败!");
	}

	/**
	 * 添加运动计划
	 */
	@Override
	public GdResult addSportplan(TSportplan tSportplan) {
	    if(tSportplanMapper.insertSelective(tSportplan)==1){
	    	return GdResult.build(200, "添加成功!");
	    }
	    return GdResult.build(400, "添加失败!");	
	}

	/**
	 * 获取会员基本信息
	 */
	@Override
	public List<TUserhealthinfo> getVipBasicInfo(Integer id) {
		// TODO Auto-generated method stub
		List<TUserhealthinfo> tUserhealthinfos = healthPlanMapper.getVipBasicInfo(id); 
		return tUserhealthinfos;
	}
	
    /**
     * 添加饮食计划索引
     */
	@Override
	public GdResult addFoodplanIndex(TPlanindex tPlanindex) {	    
		if(tPlanindexMapper.insertSelective(tPlanindex)==1)
			return GdResult.build(200, "添加成功!");
		else
			return GdResult.build(400, "添加失败!");		
	}
	 /**
     * 修改饮食计划索引
     */
	@Override
	public GdResult updateFoodplanIndex(TPlanindex tPlanindex) {
		if(tPlanindexMapper.updateByPrimaryKeySelective(tPlanindex)==1)
			return GdResult.build(200, "修改成功!");
		else
			return GdResult.build(400, "修改失败!");	
		
	}
    /**
     * 获取最新的饮食计划索引
     */
	@Override
	public TPlanindex getFoodplanIndex() {
		TPlanindex tPlanindex = healthPlanMapper.getFoodplanIndex();
		return tPlanindex;
	}
    
	/**
     * 获取最新的运动计划索引
     */
	@Override
	public TPlanindex getSportplanIndex() {
		TPlanindex tPlanindex = healthPlanMapper.getYundongplanIndex();
		return tPlanindex;
	}
	
	/**
	 * 根据用户id获取饮食计划索引
	 */
	@Override
	public List<TPlanindex> getdietplanindex(Integer id, Integer nid) {
		List<TPlanindex> tPlanindexs = healthPlanMapper.getdietplanindex(id, nid);
		return tPlanindexs;
	}
    
	/**
	 * 根据用户id获取运动计划索引
	 */
	@Override
	public List<TPlanindex> getsportplanindex(Integer id, Integer nid) {
		List<TPlanindex> tPlanindexs = healthPlanMapper.getsportplanindex(id, nid);
		return tPlanindexs;
	}
    
	/**
	 * 根据饮食计划索引获取每一天的饮食计划
	 */
	@Override
	public List<TDietplan> geteverydaydietplan(Integer uid, Integer nid, Integer planid, Date plandate) {
		TDietplanExample example = new TDietplanExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid).andNutritionistidEqualTo(nid).andPlanidEqualTo(planid).andPlandateEqualTo(plandate);	
		List<TDietplan> tDietplans = tDietplanMapper.selectByExample(example);
		return tDietplans;
	}
    /**
    * 根据运动计划索引获取每一天的运动计划
    */
	@Override
	public List<TSportplan> geteverydaysportplan(Integer uid, Integer nid, Integer planid, Date plandate) {
		TSportplanExample example = new TSportplanExample();
		com.cqust.pojo.TSportplanExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid).andNutritionistidEqualTo(nid).andPlanidEqualTo(planid).andPlandateEqualTo(plandate);	
		List<TSportplan> tSportplans = tSportplanMapper.selectByExample(example);
		return tSportplans;
	}
	
	
	
}
