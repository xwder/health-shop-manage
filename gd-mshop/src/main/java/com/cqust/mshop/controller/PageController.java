package com.cqust.mshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.ItemType;

@Controller
public class PageController {
	
	@RequestMapping("/manager/{url}")
	public ModelAndView home(@PathVariable String url,HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName(url);
		return modelAndView;
	}

	@RequestMapping("/index")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/manager/page/showitem/{itemtype}")
	public ModelAndView item(@PathVariable Integer itemtype){
		ModelAndView modelAndView = new ModelAndView();
		String  type=null;
		if(itemtype == 1){
			type=ItemType.VEGETABLES;
		}
		if(itemtype == 2){
			type=ItemType.FRUITS;
		}
		if(itemtype == 3){
			type=ItemType.MEAT;
		}
		if(itemtype == 4){
			type=ItemType.COOKERFOOD;
		}
		if(itemtype == 5){
			type=ItemType.GRAIN;
		}
		modelAndView.addObject("type", type);
		modelAndView.addObject("itemtype", itemtype);
		modelAndView.setViewName("/showitem");
		return modelAndView;
	}
}
