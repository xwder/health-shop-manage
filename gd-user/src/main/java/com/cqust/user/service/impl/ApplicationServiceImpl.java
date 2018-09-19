package com.cqust.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TDietapplicationMapper;
import com.cqust.mapper.TStoreapplicationMapper;
import com.cqust.mapper.TVipapplicationMapper;
import com.cqust.pojo.TDietapplication;
import com.cqust.pojo.TDietapplicationExample;
import com.cqust.pojo.TStoreapplication;
import com.cqust.pojo.TStoreapplicationExample;
import com.cqust.pojo.TVipapplication;
import com.cqust.pojo.TVipapplicationExample;
import com.cqust.pojo.TVipapplicationExample.Criteria;
import com.cqust.user.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private TVipapplicationMapper vipApplicationMapper;

	@Autowired
	private TDietapplicationMapper dietApplicationMapper;
	
	@Autowired
	private TStoreapplicationMapper storeApplicationMapper;

	@Override
	public GdResult addUserVipApplication(TVipapplication app) {

		TVipapplicationExample example = new TVipapplicationExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(app.getUserid());
		List<TVipapplication> list = vipApplicationMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TVipapplication vipapplication = list.get(0);
			if(vipapplication.getSqstatus() == 0){
				vipapplication.setSqstatus(2);
				int r = vipApplicationMapper.updateByPrimaryKeySelective(vipapplication);
				if(r == 1){
					return GdResult.build(200, "申请表再次提交成功！");
				}
			}
			if(vipapplication.getSqstatus() == 2){
				return GdResult.build(400, "申请表已经提交，请勿再提交！");
			}
		}
		
		
		Integer result = vipApplicationMapper.insert(app);
		if (result == 1) {
			return GdResult.build(200, "申请表提交成功！");
		} else
			return GdResult.build(400, "申请表提交失败！");
	}

	@Override
	public TVipapplication getVipApplication(Integer userid) {

		TVipapplicationExample example = new TVipapplicationExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<TVipapplication> list = vipApplicationMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public TDietapplication getDeitApplication(Integer userid) {
		TDietapplicationExample example = new TDietapplicationExample();
		com.cqust.pojo.TDietapplicationExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);

		List<TDietapplication> list = dietApplicationMapper.selectByExample(example);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public GdResult addDietApplication(TDietapplication dietapp) {
		
		TDietapplicationExample example = new TDietapplicationExample();
		com.cqust.pojo.TDietapplicationExample.Criteria criteria =  example.createCriteria();
		criteria.andUseridEqualTo(dietapp.getUserid());
		
		List<TDietapplication> list = dietApplicationMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			
			TDietapplication application = list.get(0);
			if(application.getSqstatus() == 0){
				application.setSqstatus(2);
				int r = dietApplicationMapper.updateByPrimaryKeySelective(application);
				if(r == 1){
					return GdResult.build(200, "申请表再次提交成功！");
				}
			}
			if(application.getSqstatus() == 2){
				return GdResult.build(400, "申请表已经提交，请勿再提交！");
			}
		}
		
		Integer result = dietApplicationMapper.insert(dietapp);
		if (result == 1) {
			return GdResult.build(200, "申请表提交成功！");
		} else
			return GdResult.build(400, "申请表提交失败！");
	}

	@Override
	public TStoreapplication geTStoreapplication(Integer userid) {
		TStoreapplicationExample example = new TStoreapplicationExample();
		com.cqust.pojo.TStoreapplicationExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		
		List<TStoreapplication> list = storeApplicationMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public GdResult addStoreApplication(TStoreapplication storeapp) {
		
		TStoreapplicationExample example = new TStoreapplicationExample();
		com.cqust.pojo.TStoreapplicationExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(storeapp.getUserid());
		
		List<TStoreapplication> list = storeApplicationMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			TStoreapplication application = list.get(0);
			if(application.getSqstatus() == 0){
				application.setSqstatus(2);
				int r = storeApplicationMapper.updateByPrimaryKeySelective(application);
				if(r == 1){
					return GdResult.build(200, "申请表再次提交成功！");
				}
			}
			if(application.getSqstatus() == 2){
				return GdResult.build(400, "申请表已经提交，请勿再提交！");
			}
		}
		
		Integer result = storeApplicationMapper.insert(storeapp);
		if (result == 1) {
			return GdResult.build(200, "申请表提交成功！");
		} else
			return GdResult.build(400, "申请表提交失败！");
	}

}
