package com.cqust.user.mapper;

import java.util.List;

import com.cqust.pojo.TDietplanbyself;
import com.cqust.pojo.TPlanindexbyself;

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
	List<TDietplanbyself> getTDietplans(Integer uid);
	
	
	/**
	 * 获取最新的饮食计划索引(添加饮食计划时用到)
	 * @Title: getFoodplanIndex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	TPlanindexbyself getFoodplanIndex();
	
	/**
	 * 获取最新的运动计划索引(添加运动计划时用到)
	 * @Title: getSportplanIndex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	TPlanindexbyself getSportplanIndex();
		
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
