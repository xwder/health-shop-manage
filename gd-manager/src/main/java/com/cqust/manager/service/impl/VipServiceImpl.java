package com.cqust.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.manager.service.VipService;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.mapper.TVipapplicationMapper;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserinfoExample;
import com.cqust.pojo.TVipapplication;
import com.cqust.pojo.TVipapplicationExample;
import com.cqust.pojo.TVipapplicationExample.Criteria;


@Service
public class VipServiceImpl implements VipService {
    @Autowired
    TVipapplicationMapper tVipapplicationMapper;
    @Autowired
    TUserinfoMapper tUserinfoMapper;
    /**
     * 获取高级会员申请信息
     */
	@Override
	public List<TVipapplication> getVipApplication() {
		// TODO Auto-generated method stub
		TVipapplicationExample example = new TVipapplicationExample();
		Criteria criteria = example.createCriteria();
	    criteria.andSqstatusEqualTo(2);
		List<TVipapplication> tVipapplications = tVipapplicationMapper.selectByExample(example);
		return tVipapplications;
	}
    /**
     * 更改高级会员申请状态
     */
	@Override
	public GdResult updateVipApplication(TVipapplication tVipapplication,TUserinfo tUserinfo) {
		// TODO Auto-generated method stub
		try{
			if(tVipapplicationMapper.updateByPrimaryKeySelective(tVipapplication)==1&&tUserinfoMapper.updateByPrimaryKeySelective(tUserinfo)==1)
				return GdResult.build(200, "审核成功!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "审核失败!");
	}
	
	/**
	 * 获取会员信息
	 */
	@Override
	public List<TUserinfo> getVipInfo() {
		// TODO Auto-generated method stub
		TUserinfoExample example = new TUserinfoExample();
	    com.cqust.pojo.TUserinfoExample.Criteria criteria = example.createCriteria();
	    criteria.andIdIsNotNull();
	    List<TUserinfo> tUserinfos = tUserinfoMapper.selectByExample(example); 		
		return tUserinfos;
	}
	@Override
	public List<TUserinfo> getSuperInfo() {
		// TODO Auto-generated method stub
		TUserinfoExample example = new TUserinfoExample();
	    com.cqust.pojo.TUserinfoExample.Criteria criteria = example.createCriteria();
	    criteria.andIsVipEqualTo(1);
	    List<TUserinfo> tUserinfos = tUserinfoMapper.selectByExample(example); 		
		return tUserinfos;
	}	
	
	
}
