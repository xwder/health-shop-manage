package com.cqust.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/** 
* @ClassName: PageController 
* @Description:页面跳转Controller
* @author Joe  
* @date 2016年12月18日 下午9:47:01 
*  
*/
@Controller
@RequestMapping("/page")
public class PageController {


	/** 
	* @Title: showRegister 
	* @Description:   跳转到注册页面
	* @return String    
	* @throws 
	*/
	@RequestMapping("/register")
	public String showRegister() {
		return "register";
	}
	/** 
	* @Title: showLogin 
	* @Description:  跳转到登录页面
	* @param  redirect 跳转到登录页面前的URL地址
	* @param model 
	* @return String    
	* @throws 
	*/
	@RequestMapping("/login")
	public String showLogin(String redirect, Model model) {
		model.addAttribute("redirect", redirect);
		return "login";
	}
	
	
	@RequestMapping("/managerlogin")
	public String showManagerLogin(String redirect, Model model) {
		model.addAttribute("redirect", redirect);
		return "mlogin";
	}
}
