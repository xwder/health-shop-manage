package com.cqust.nutritionist.mapper;

import java.util.List;

import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TUserhealthinfo;

public interface HealthPlanMapper {
	/**
	 * 获取所有的饮食计划
	 * @Title: geTDietplans 
	 * @Description: TODO
	 * @param uid
	 * @param nid
	 * @return      
	 * @throws
	 */
	List<TDietplan> getTDietplans(Integer uid,Integer nid);
	
	/**
	 * 获取会员基本信息
	 */
	List<TUserhealthinfo> getVipBasicInfo(Integer id); 
	
	/**
	 * 获取最新的饮食计划索引(添加饮食计划时用到)
	 * @Title: getFoodplanIndex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	TPlanindex getFoodplanIndex();
	
	/**
	 * 获取最新的运动计划索引(添加运动计划时用到)
	 * @Title: getSportplanIndex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	TPlanindex getYundongplanIndex();
		
	/**
	 * 根据用户id获取饮食计划索引
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @param id
	 * @param nid
	 * @return      
	 * @throws
	 */
	List<TPlanindex> getdietplanindex(Integer id,Integer nid);
	
	/**
	 * 根据用户id获取运动计划索引
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @param id
	 * @param nid
	 * @return      
	 * @throws
	 */
	List<TPlanindex> getsportplanindex(Integer id,Integer nid);
}
