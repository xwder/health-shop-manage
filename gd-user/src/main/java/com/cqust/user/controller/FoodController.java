package com.cqust.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.user.service.FoodService;


@Controller
@RequestMapping("/food")
public class FoodController {
	@Autowired
	FoodService foodService;
	/**
	 * 获取食材分类
	 * @Title: getMaterial 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getmaterial")
	@ResponseBody
	public GdResult getMaterial(){
		return foodService.getMaterial();
	}
	 /**
 	 * 根据食材类别获取每一类食物
 	 * @Title: getMaterial 
 	 * @Description: TODO
 	 * @return      
 	 * @throws
 	 */
	@RequestMapping("/getfoods/{id}")
	@ResponseBody
	public GdResult getFoods(@PathVariable Integer id){
		return foodService.getFoods(id);
	}
	/**
 	 * 根据食物id获取每一种食物
 	 * @Title: getMaterial 
 	 * @Description: TODO
 	 * @return      
 	 * @throws
 	 */
	@RequestMapping("/getfood/{id}")
	@ResponseBody
	public GdResult getFood(@PathVariable Integer id){
		return foodService.getFood(id);
	}
	/**
	 * 根据食物id获取每一种食物的营养成分
	 * @Title: getFoodnutrition 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getfoodnutrition/{id}")
	@ResponseBody
	public GdResult getFoodnutrition(@PathVariable Integer id){
		return foodService.getFoodnutrition(id);
	}
	/**
	 * 获取全部食物
	 * @Title: getAllFood 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getallfood")
	@ResponseBody
	public GdResult getAllFood(){
		return foodService.getAllFood();	
	}		
}
