package com.cqust.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.manager.pojo.CustomUserinfo;
import com.cqust.manager.service.UserService;
import com.cqust.pojo.TUserinfo;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/userlistpage/{type}")
	public ModelAndView userlistpage(@PathVariable Integer type ,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/userlist");
		modelAndView.addObject("url", "/user/userlist/"+type);
		modelAndView.addObject("type", type);
		return modelAndView;
	}
	
	@RequestMapping("/userlist/{type}")
	@ResponseBody
	public List<CustomUserinfo> userlist(@PathVariable Integer type,HttpServletRequest request){
		List<TUserinfo> list = userService.getUsersByType(type);
		List<CustomUserinfo> customUserinfos = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			CustomUserinfo userinfo = new CustomUserinfo();
			TUserinfo user = list.get(i);
			userinfo.setId(user.getId());
			userinfo.setImage(user.getImage());
			userinfo.setSex(user.getSex());
			if(user.getSex() == 1){
				userinfo.setStrsex("男");
			}else{
				userinfo.setStrsex("女");
			}
			userinfo.setUsername(user.getUsername());
			userinfo.setPassword(null);
			userinfo.setName(user.getName());
			userinfo.setPhone(user.getPhone());
			userinfo.setEmail(user.getEmail());
			userinfo.setCreatedtime(user.getCreatedtime());
			userinfo.setUpdatedtime(user.getUpdatedtime());
			userinfo.setState(user.getState());
			userinfo.setDietitianid(user.getDietitianid());
			userinfo.setIsVip(user.getIsVip());
			if(user.getIsVip() == 1){
				userinfo.setStrvip("高级会员");
			}else{
				userinfo.setStrvip("普通会员");
			}
			userinfo.setIsstore(user.getIsstore());
			if(user.getIsstore() == 1){
				userinfo.setStrstore("是");
			}else{
				userinfo.setStrstore("否");
			}
			userinfo.setIsdiet(user.getIsdiet());
			if(user.getIsdiet() == 1){
				userinfo.setStrdiet("是");
			}else{
				userinfo.setStrdiet("否");
			}
			customUserinfos.add(userinfo);
		}
		return customUserinfos;
	}
}
