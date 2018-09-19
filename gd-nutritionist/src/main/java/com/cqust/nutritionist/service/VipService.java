package com.cqust.nutritionist.service;

import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipdietapplication;

public interface VipService {
	/**
	 * 获取会员基本信息
	 * @Title: geTUserinfos 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TUserinfo> geTUserinfos(Integer id);
	
	/**
	 * 获取会员健康信息
	 * @Title: geTUserhealthinfos 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	GdResult geTUserhealthinfos(Integer id);
	
	/**
	 * 获取会员的申请信息
	 * @Title: getVipapplication 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TVipdietapplication> getVipapplication(Integer id);
	
	/**
	 * 更改会员申请状态
	 * @Title: updateVipapplication 
	 * @Description: TODO
	 * @param tVipdietapplication
	 * @param tUserinfo
	 * @return      
	 * @throws
	 */
	GdResult updateVipapplication(TVipdietapplication tVipdietapplication,TUserinfo tUserinfo);
    
	/**
	 * 为会员添加消息提醒
	 * @Title: addMessageremind 
	 * @Description: TODO
	 * @param tMessageremind
	 * @return      
	 * @throws
	 */
	GdResult addMessageremind(TMessageremind tMessageremind);
	
	/**
	 * 营养师删除某个会员
	 * @Title: deleteVip 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	GdResult deleteVip(Integer uid,Integer nid);
	
}
