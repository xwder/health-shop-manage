package com.cqust.nutritionist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TMessageremindMapper;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.mapper.TVipdietapplicationMapper;
import com.cqust.nutritionist.mapper.VipMapper;
import com.cqust.nutritionist.service.VipService;
import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TUserhealthinfo;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipdietapplication;

@Service
public class VipServiceImpl implements VipService {
	@Autowired
	VipMapper vipMapper;
	@Autowired
    TVipdietapplicationMapper  tVipdietapplicationMapper;
	@Autowired
    TUserinfoMapper tUserinfoMapper;
	@Autowired
    TMessageremindMapper tMessageremindMapper;
	
	
	@Override		
	/**
	 * 获取会员基本信息
	 */
	public List<TUserinfo> geTUserinfos(Integer id) {
		// TODO Auto-generated method stub
		try {
			return vipMapper.geTUserinfos(id);			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 获取会员健康信息
     */
	@Override
	public GdResult geTUserhealthinfos(Integer id) {
		// TODO Auto-generated method stub
		try {
			List<TUserhealthinfo> tUserhealthinfos = vipMapper.geTUserhealthinfos(id);
			if(tUserhealthinfos.size()!= 0)
			return GdResult.build(200, "获取成功!", tUserhealthinfos.get(0));
			return GdResult.build(400, "暂无此会员的健康信息!", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GdResult.build(400, "获取失败!", null);
	}
    /**
     * 获取会员的申请信息
     */
	@Override
	public List<TVipdietapplication> getVipapplication(Integer id) {
		// TODO Auto-generated method stub
		try {
			return vipMapper.getVipapplication(id);			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 更改会员申请状态
     */
	@Override
	public GdResult updateVipapplication(TVipdietapplication tVipdietapplication, TUserinfo tUserinfo) {
		// TODO Auto-generated method stub
		try{
			if(tVipdietapplicationMapper.updateByPrimaryKeySelective(tVipdietapplication)==1&&tUserinfoMapper.updateByPrimaryKeySelective(tUserinfo)==1){
				return GdResult.build(200, "审核成功!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "审核失败!");
	}
    /**
     * 为会员添加消息提醒
     */
	@Override
	public GdResult addMessageremind(TMessageremind tMessageremind) {
		// TODO Auto-generated method stub
		try{
			if(tMessageremindMapper.insertSelective(tMessageremind)==1)
				return GdResult.build(200, "发送成功!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "发送失败!");
	}
    /**
     * 营养师删除某个会员
     */
	@Override
	public GdResult deleteVip(Integer uid,Integer nid) {
		// TODO Auto-generated method stub
		try{
			vipMapper.deleteVip(uid,nid);
			return GdResult.build(200, "删除成功!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400, "删除失败!");
	}
		 
}
