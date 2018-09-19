package com.cqust.user.service;

import com.cqust.commom.utils.GdResult;

public interface FoodService {
	/**
	 * 获取食材分类
	 * @Title: getMaterial 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
     GdResult getMaterial();
     /**
 	 * 根据食材类别获取每一类食物
 	 * @Title: getMaterial 
 	 * @Description: TODO
 	 * @return      
 	 * @throws
 	 */
     GdResult getFoods(Integer id);
      /**
   	 * 根据食物id获取每一种食物
   	 * @Title: getMaterial 
   	 * @Description: TODO
   	 * @return      
   	 * @throws
   	 */
     GdResult getFood(Integer id);
     /**
      * 根据食物id获取每一种食物的营养成分
      * @Title: getFoodnutrition 
      * @Description: TODO
      * @param id
      * @return      
      * @throws
      */
     GdResult getFoodnutrition(Integer id);
     /**
      * 获取全部食物    
      * @Title: getAllFood 
      * @Description: TODO
      * @return      
      * @throws
      */
     GdResult getAllFood();
}
