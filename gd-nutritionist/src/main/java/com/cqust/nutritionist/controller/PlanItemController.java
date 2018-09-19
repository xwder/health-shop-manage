package com.cqust.nutritionist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.service.PlanItemService;

@Controller
@RequestMapping("/item")
public class PlanItemController {
	@Autowired
	PlanItemService planItemService;
	
	/**
	 * 获取全部的运动项目
	 * @Title: getSportItem 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/sport/getsportitem")
	@ResponseBody
	public GdResult getSportItem(){		
		return planItemService.getSportItem();
	}
	
	/**
	 * 根据id获取某一项运动项目
	 * @Title: getSportItemById 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/sport/getsportitembyid/{id}")
	@ResponseBody	
	public GdResult getSportItemById(@PathVariable Integer id){
		return planItemService.getSportItemById(id);
	}
	

}
