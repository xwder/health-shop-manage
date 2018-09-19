package com.cqust.nutritionist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.pojo.NutritionistInfo;
import com.cqust.nutritionist.service.UserService;
import com.cqust.pojo.TUserinfo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/updateuserinfo")
	@ResponseBody
	GdResult updateuserinfo(HttpServletRequest httpServletRequest){
		TUserinfo tUserinfo = new TUserinfo();
		tUserinfo.setId(Integer.parseInt(httpServletRequest.getParameter("id")));
		tUserinfo.setPhone(httpServletRequest.getParameter("phone"));
		tUserinfo.setEmail(httpServletRequest.getParameter("email"));
		return userService.updateuserinfo(tUserinfo);
	}
	
	@RequestMapping("/changepw")
	@ResponseBody
	GdResult changepw(HttpServletRequest httpServletRequest){
		Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
		String oldpw = httpServletRequest.getParameter("oldpw");
		String newpw = httpServletRequest.getParameter("newpw");
		return userService.changepw(id, oldpw, newpw);		
	}
    
	@RequestMapping("/getuserinfo/{id}")
	@ResponseBody
	NutritionistInfo geTUserinfo(@PathVariable Integer id){
		return userService.geTUserinfo(id);
	}
}
