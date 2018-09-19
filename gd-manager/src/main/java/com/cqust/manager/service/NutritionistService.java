package com.cqust.manager.service;

import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TDietapplication;
import com.cqust.pojo.TDietitian;
import com.cqust.pojo.TUserinfo;

public interface NutritionistService {
	/**
	 * 获取营养师申请信息
	 * @Title: geTDietApplication 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public List<TDietapplication> getDietApplication();
    
	/**
	 * 更改营养师申请状态
	 * @Title: updateDietApplication 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public GdResult updateDietApplication(TDietapplication tDietapplication,TUserinfo tUserinfo);
	
	/**
	 * 获取营养师信息
	 * @Title: getNutritionistInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public List<TUserinfo> getNutritionistInfo();
	
	/** 
	 * @Title: AddNutritionInfo 
	 * @Description: 添加营养师信息
	 * @param dietitian
	 * @return      
	 * @throws 
	 */
	Integer AddNutritionInfo(TDietitian dietitian);
	
	/** 
	 * @Title: getDietitianAppInfoById 
	 * @Description: 根据ID获取营养师申请信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TDietapplication getDietitianAppInfoById(Integer id);
	
	/** 
	 * @Title: addDietitianInfo 
	 * @Description: 营养师申请通过保存营养师信息
	 * @param dietitian
	 * @return      
	 * @throws 
	 */
	Integer addDietitianInfo(TDietitian dietitian);
	
	/**
	* @Title: geTDietitians
	* @Description: 获取所有营养师列表
	* @param  @return    
	* @return List<TDietitian>    
	* @throws
	*/
	List<TDietitian> geTDietitians();
}
