package com.cqust.nutritionist.service;

import java.util.Date;
import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TSportplan;
import com.cqust.pojo.TUserhealthinfo;

public interface HealthPlanService {
	/**
	 * 根据饮食计划索引获取每一天的饮食计划
	 * @Title: geteverydaydietplan 
	 * @Description: TODO
	 * @param uid
	 * @param nid
	 * @param planid
	 * @param plandate
	 * @return      
	 * @throws
	 */
	List<TDietplan> geteverydaydietplan(Integer uid,Integer nid,Integer planid,Date plandate);
	
	/**
	 * 根据运动计划索引获取每一天的运动计划
	 * @Title: geteverydaysportplan 
	 * @Description: TODO
	 * @param uid
	 * @param nid
	 * @param planid
	 * @param plandate
	 * @return      
	 * @throws
	 */
	List<TSportplan> geteverydaysportplan(Integer uid,Integer nid,Integer planid,Date plandate);
		
	/**
     * 添加饮食计划索引
     * @Title: addFoodplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    GdResult addFoodplanIndex(TPlanindex tPlanindex);
	
    /**
     * 修改饮食计划索引
     * @Title: addFoodplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    GdResult updateFoodplanIndex(TPlanindex tPlanindex);
    
    /**
     * 获取最新饮食计划索引
     * @Title: getFoodplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    TPlanindex getFoodplanIndex();
    
    /**
     * 获取最新运动计划索引
     * @Title: getSportplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    TPlanindex getSportplanIndex();
    
    
	/**
     * 添加饮食计划
     * @Title: addFoodplan 
     * @Description: TODO
     * @param tDietplan
     * @return      
     * @throws
     */
    GdResult addFoodplan(TDietplan tDietplan);
  
    /**
     * 添加运动计划
     * @Title: addFoodplan 
     * @Description: TODO
     * @param tDietplan
     * @return      
     * @throws
     */
    GdResult addSportplan(TSportplan tSportplan);
    
    /**
     * 获取会员的基本信息
     * @Title: getVipBasicInfo 
     * @Description: TODO
     * @param id
     * @return      
     * @throws
     */
    List<TUserhealthinfo> getVipBasicInfo(Integer id);
    
    
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
