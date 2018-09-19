package com.cqust.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.pojo.TUserinfo;
import com.cqust.shop.service.UserService;

@Controller
@RequestMapping("/shop")
public class ShopCartController {
	
	@Autowired
	private UserService  userService;

	@RequestMapping("/cart/{id}")
	public ModelAndView showCart(@PathVariable Integer id, HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		if(userinfo == null){
			userinfo = userService.geTUserinfoById(id);
		}
		request.getSession().setAttribute("userinfo", userinfo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/shopcart");
		return modelAndView;
	}
}
