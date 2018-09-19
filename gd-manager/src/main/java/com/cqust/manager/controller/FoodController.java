package com.cqust.manager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.manager.service.FoodService;
import com.cqust.pojo.TFood;
import com.cqust.pojo.TFoodnutrition;

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
	/**
	 * 根据id删除每一种食物
	 * @Title: delFood 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/delfood/{id}")
	@ResponseBody
	public GdResult delFood(@PathVariable Integer id){
		return foodService.delFood(id);
	}	
	/**
	 * 根据id修改每一种食物
	 * @Title: modifyFood 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/modifyfood")
	@ResponseBody
	public GdResult modifyFood(HttpServletRequest httpServletRequest){
		TFood food  = new TFood();
		food.setId(Integer.parseInt(httpServletRequest.getParameter("id")));
		food.setFoodname(httpServletRequest.getParameter("foodname"));
		food.setFoodquantity(Double.valueOf(httpServletRequest.getParameter("foodquantity")));
		food.setMaterialid(Integer.parseInt(httpServletRequest.getParameter("materialid")));	
		return foodService.modifyFood(food);
	}
	/**
	 * 根据id修改每一种食物的营养成分
	 * @Title: modifyFoodnutrition 
	 * @Description: TODO
	 * @param foodnutrition
	 * @return      
	 * @throws
	 */
	@RequestMapping("/modifyfoodnutrition")
	@ResponseBody
	public GdResult modifyFoodnutrition(HttpServletRequest httpServletRequest){		
		TFoodnutrition foodnutrition = new TFoodnutrition();
		foodnutrition.setId(Integer.parseInt(httpServletRequest.getParameter("foodnutritionid")));
		foodnutrition.setEnergy(httpServletRequest.getParameter("nengliang"));
		foodnutrition.setWatercontent(httpServletRequest.getParameter("water"));
		foodnutrition.setProtein(httpServletRequest.getParameter("danbaizhi"));
		foodnutrition.setFat(httpServletRequest.getParameter("zhifang"));
		foodnutrition.setDietaryfiber(httpServletRequest.getParameter("xianwei"));
		foodnutrition.setCarbohydrate(httpServletRequest.getParameter("tanshui"));
		foodnutrition.setVitaminsa(httpServletRequest.getParameter("wA"));
		foodnutrition.setVitaminsb1(httpServletRequest.getParameter("wB1"));
		foodnutrition.setVitaminsb2(httpServletRequest.getParameter("wB2"));
		foodnutrition.setVitaminsc(httpServletRequest.getParameter("wC"));
		foodnutrition.setVitaminse(httpServletRequest.getParameter("wE"));
		foodnutrition.setNiacin(httpServletRequest.getParameter("yansuan"));
		foodnutrition.setNa(httpServletRequest.getParameter("na"));
		foodnutrition.setCalcium(httpServletRequest.getParameter("gai"));
		foodnutrition.setIron(httpServletRequest.getParameter("tie"));
		foodnutrition.setCholesterol(httpServletRequest.getParameter("danguchun"));
		return foodService.modifyFoodnutrition(foodnutrition);		
	}
	/**
	 * 添加食物
	 * @Title: addFood 
	 * @Description: TODO
	 * @param food
	 * @param foodnutrition
	 * @return      
	 * @throws
	 */
	@RequestMapping("/addfood")
	@ResponseBody
	public GdResult addFood(HttpServletRequest httpServletRequest) {
		TFood food = new TFood();
		food.setFoodname(httpServletRequest.getParameter("foodname"));
		food.setFoodquantity(Double.parseDouble(httpServletRequest.getParameter("foodquantity")));
		food.setMaterialid(Integer.parseInt(httpServletRequest.getParameter("materialid")));
		foodService.addFood(food);
		TFoodnutrition foodnutrition = new TFoodnutrition();
		foodnutrition.setFoodid(foodService.geTFood().getId());
		foodnutrition.setEnergy(httpServletRequest.getParameter("nengliang"));
		foodnutrition.setWatercontent(httpServletRequest.getParameter("water"));
		foodnutrition.setProtein(httpServletRequest.getParameter("danbaizhi"));
		foodnutrition.setFat(httpServletRequest.getParameter("zhifang"));
		foodnutrition.setDietaryfiber(httpServletRequest.getParameter("xianwei"));
		foodnutrition.setCarbohydrate(httpServletRequest.getParameter("tanshui"));
		foodnutrition.setVitaminsa(httpServletRequest.getParameter("wA"));
		foodnutrition.setVitaminsb1(httpServletRequest.getParameter("wB1"));
		foodnutrition.setVitaminsb2(httpServletRequest.getParameter("wB2"));
		foodnutrition.setVitaminsc(httpServletRequest.getParameter("wC"));
		foodnutrition.setVitaminse(httpServletRequest.getParameter("wE"));
		foodnutrition.setNiacin(httpServletRequest.getParameter("yansuan"));
		foodnutrition.setNa(httpServletRequest.getParameter("na"));
		foodnutrition.setCalcium(httpServletRequest.getParameter("gai"));
		foodnutrition.setIron(httpServletRequest.getParameter("tie"));
		foodnutrition.setCholesterol(httpServletRequest.getParameter("danguchun"));
		return foodService.addFoodnutrition(foodnutrition);		
	}	
}
