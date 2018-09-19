package com.cqust.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.manager.service.NutritionistService;
import com.cqust.mapper.TDietapplicationMapper;
import com.cqust.mapper.TDietitianMapper;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.pojo.TDietapplication;
import com.cqust.pojo.TDietapplicationExample;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserinfoExample;
import com.cqust.pojo.TDietapplicationExample.Criteria;
import com.cqust.pojo.TDietitian;
import com.cqust.pojo.TDietitianExample;
@Service
public class NutritionistServiceImpl implements NutritionistService {
    
	@Autowired
	TDietapplicationMapper tDietapplicationMapper;
	@Autowired
	TUserinfoMapper tUserinfoMapper;
	
	@Autowired
	TDietitianMapper dietitianMapper;
	
	/**
	 * 获取营养师申请信息
	 */
	@Override
	public List<TDietapplication> getDietApplication() {
		// TODO Auto-generated method stub
		TDietapplicationExample example = new TDietapplicationExample();
		Criteria criteria =  example.createCriteria();
		criteria.andSqstatusEqualTo(2);
		List<TDietapplication> tDietapplications = tDietapplicationMapper.selectByExample(example);
		return tDietapplications;
	}
	
	/**
	 * 更改营养师申请状态
	 */
    @Override
    public GdResult updateDietApplication(TDietapplication tDietapplication,TUserinfo tUserinfo) {
    	// TODO Auto-generated method stub
    	try{
    		if(tDietapplicationMapper.updateByPrimaryKeySelective(tDietapplication)==1&&tUserinfoMapper.updateByPrimaryKeySelective(tUserinfo)==1)
    			return GdResult.build(200, "审核成功!");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return GdResult.build(400, "审核失败!");
    }
    
    /**
     * 获取营养师信息
     */
    public List<TUserinfo> getNutritionistInfo(){
    	TUserinfoExample example = new TUserinfoExample();
    	com.cqust.pojo.TUserinfoExample.Criteria criteria = example.createCriteria();
    	criteria.andIsdietEqualTo(1);
    	List<TUserinfo> tUserinfos = tUserinfoMapper.selectByExample(example);
    	return tUserinfos;
    }

	@Override
	public Integer AddNutritionInfo(TDietitian dietitian) {
		
		return dietitianMapper.insert(dietitian);
	}

	@Override
	public TDietapplication getDietitianAppInfoById(Integer id) {
		return tDietapplicationMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer addDietitianInfo(TDietitian dietitian) {
		return dietitianMapper.insert(dietitian);
	}

	@Override
	public List<TDietitian> geTDietitians() {
		TDietitianExample example = new TDietitianExample();
		List<TDietitian> list = dietitianMapper.selectByExample(example);
		return list;
	}
}
