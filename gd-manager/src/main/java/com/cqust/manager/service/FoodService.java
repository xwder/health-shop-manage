package com.cqust.manager.service;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TFood;
import com.cqust.pojo.TFoodnutrition;

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
     /**
      * 根据id删除每一种食物
      * @Title: delFood 
      * @Description: TODO
      * @param id
      * @return      
      * @throws
      */
     GdResult delFood(Integer id);
     /**
      * 根据id修改每一种食物
      * @Title: modifyFood 
      * @Description: TODO
      * @param food
      * @return      
      * @throws
      */
     GdResult modifyFood(TFood food);
     /**
      * 根据id修改每一种食物的营养成分
      * @Title: modifyFoodnutrition 
      * @Description: TODO
      * @param food
      * @return      
      * @throws
      */
     GdResult modifyFoodnutrition(TFoodnutrition foodnutrition);   
     /**
      * 添加食物
      * @Title: addFood 
      * @Description: TODO
      * @param food
      * @param foodnutrition
      * @return      
      * @throws
      */
     GdResult addFood(TFood food);
     /**
      * 添加食物营养成分
      * @Title: addFoodnutrition 
      * @Description: TODO
      * @param foodnutrition
      * @return      
      * @throws
      */
     GdResult addFoodnutrition(TFoodnutrition foodnutrition);
     /**
      * 获取最新添加的食物信息
      * @Title: geTFood 
      * @Description: TODO
      * @return      
      * @throws
      */
     TFood geTFood();
}
