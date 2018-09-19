package com.cqust.user.service;

import java.util.Date;
import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TDietplanbyself;
import com.cqust.pojo.TPlanindexbyself;
import com.cqust.pojo.TSportplanbyself;

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
	List<TDietplanbyself> geteverydaydietplan(Integer uid,Integer planid,Date plandate);
	
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
	List<TSportplanbyself> geteverydaysportplan(Integer uid,Integer planid,Date plandate);
		
	/**
     * 添加饮食计划索引
     * @Title: addFoodplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    GdResult addFoodplanIndex(TPlanindexbyself tPlanindexbyself);
	
    /**
     * 修改饮食计划索引
     * @Title: addFoodplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    GdResult updateFoodplanIndex(TPlanindexbyself tPlanindexbyself);
    
    /**
     * 获取最新饮食计划索引
     * @Title: getFoodplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    TPlanindexbyself getFoodplanIndex();
    
    /**
     * 获取最新运动计划索引
     * @Title: getSportplanIndex 
     * @Description: TODO
     * @param tPlanindex
     * @return      
     * @throws
     */
    TPlanindexbyself getSportplanIndex();
    
    
	/**
     * 添加饮食计划
     * @Title: addFoodplan 
     * @Description: TODO
     * @param tDietplan
     * @return      
     * @throws
     */
    GdResult addFoodplan(TDietplanbyself tDietplanbyself);
  
    /**
     * 添加运动计划
     * @Title: addFoodplan 
     * @Description: TODO
     * @param tDietplan
     * @return      
     * @throws
     */
    GdResult addSportplan(TSportplanbyself tSportplanbyself);    
    
    /**
	 * 根据用户id获取饮食计划索引
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @param id
	 * @param nid
	 * @return      
	 * @throws
	 */
	List<TPlanindexbyself> getdietplanindex(Integer id);
	
	/**
	 * 根据用户id获取运动计划索引
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @param id
	 * @param nid
	 * @return      
	 * @throws
	 */
	List<TPlanindexbyself> getsportplanindex(Integer id);
	
	
	/**
	 * 根据用户id和日期获取饮食计划索引（获取今日饮食计划）
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @param id
	 * @param nid
	 * @return      
	 * @throws
	 */
	List<TPlanindexbyself> getdietplanindexBydate(Integer id,String date);
	/**
	 * 根据用户id和日期获取运动计划索引（获取今日运动计划）
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @param id
	 * @param date
	 * @return      
	 * @throws
	 */
	List<TPlanindexbyself> getsportplanindexBydate(Integer id,String date);
    
}
