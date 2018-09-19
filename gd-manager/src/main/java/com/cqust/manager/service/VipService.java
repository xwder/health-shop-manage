package com.cqust.manager.service;

import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipapplication;

public interface VipService {
	/**
	 * 获取高级会员申请信息
	 * @Title: getVipApplication 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public List<TVipapplication> getVipApplication();
    
	/**
	 * 更改高级会员申请状态
	 * @Title: updateVipApplication 
	 * @Description: TODO
	 * @param tVipapplication
	 * @return      
	 * @throws
	 */
	public GdResult updateVipApplication(TVipapplication tVipapplication,TUserinfo tUserinfo);
	
	/**
	 * 获取会员信息
	 * @Title: getVipInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public List<TUserinfo> getVipInfo();
	
	/**
	 * 获取高级会员信息
	 * @Title: getSuperInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public List<TUserinfo> getSuperInfo();
}
