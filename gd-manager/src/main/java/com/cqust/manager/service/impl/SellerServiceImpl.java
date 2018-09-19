package com.cqust.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.manager.service.SellerService;
import com.cqust.mapper.TStoreapplicationMapper;
import com.cqust.mapper.TStoreinfoMapper;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.pojo.TStoreapplication;
import com.cqust.pojo.TStoreapplicationExample;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserinfoExample;
import com.cqust.pojo.TStoreapplicationExample.Criteria;
import com.cqust.pojo.TStoreinfo;
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	TStoreapplicationMapper tStoreapplicationMapper;
	@Autowired
	TUserinfoMapper tUserinfoMapper;
	@Autowired
	TStoreinfoMapper storeInfoMapper;
	/**
	 * 获取商家申请信息
	 */
	@Override	
	public List<TStoreapplication> getSellerApplication() {
		// TODO Auto-generated method stub
		TStoreapplicationExample example = new TStoreapplicationExample();
		Criteria criteria =  example.createCriteria();
		criteria.andSqstatusEqualTo(2);
		List<TStoreapplication> tStoreapplications = tStoreapplicationMapper.selectByExample(example);
		return tStoreapplications;
	}
    /**
     * 更改商家申请状态
     */
	@Override
	public GdResult updateSellerApplication(TStoreapplication tStoreapplication,TUserinfo tUserinfo) {
		// TODO Auto-generated method stub
		try{
			if(tStoreapplicationMapper.updateByPrimaryKeySelective(tStoreapplication)==1&&tUserinfoMapper.updateByPrimaryKeySelective(tUserinfo)==1)
				return GdResult.build(200, "审核成功!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "审核失败!");
	}
	/**
	 * 获取商家信息
	 */
	@Override
	public List<TUserinfo> getSellerInfo() {
		// TODO Auto-generated method stub
		TUserinfoExample example = new TUserinfoExample();
		com.cqust.pojo.TUserinfoExample.Criteria criteria = example.createCriteria();
		criteria.andIsstoreEqualTo(1);
		List<TUserinfo> tUserinfos = tUserinfoMapper.selectByExample(example);
		return tUserinfos;
	}
	@Override
	public Integer addSellerInfo(TStoreinfo storeinfo) {
		return storeInfoMapper.insert(storeinfo);
	}
	@Override
	public TStoreapplication getStoreAppInfoById(Integer id) {
		 
		return tStoreapplicationMapper.selectByPrimaryKey(id);
	}
    
}
