package com.cqust.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.PageBean;
import com.cqust.pojo.TUserinfo;
import com.cqust.user.pojo.OrderInfo;
import com.cqust.user.service.OrderService;
import com.cqust.user.service.UserService;

@Controller
@RequestMapping("/user")
public class PageController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;

	/**
	 * @Title: showUserIndxe
	 * @Description: 跳转到个人中心
	 * @return String @throws
	 */
	@RequestMapping("/userindex")
	public ModelAndView userIndex( HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		if(userinfo == null){
			modelAndView.setViewName("/error");
			return modelAndView;
		}
		
		PageBean<OrderInfo> allOrderPageBean = orderService.getallWwcOrderList(userinfo.getId(), 1, 2);
		
		modelAndView.addObject("userinfo", userinfo);
		modelAndView.addObject("allOrderPageBean", allOrderPageBean);
		request.getSession().setAttribute("userinfo",userinfo);
		modelAndView.setViewName("/userindex");
		return modelAndView;
	}
	
	@RequestMapping("/userindexorder")
	public ModelAndView userindexorder( HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		if(userinfo == null){
			modelAndView.setViewName("/error");
			return modelAndView;
		}
		
		String strPage = request.getParameter("page");
		Integer page = 0;
		try {
			page = Integer.parseInt(strPage);
		} catch (Exception e) {
			 
		}
		PageBean<OrderInfo> allOrderPageBean = orderService.getallWwcOrderList(userinfo.getId(), page, 2);
		modelAndView.addObject("userinfo", userinfo);
		modelAndView.addObject("allOrderPageBean", allOrderPageBean);
		modelAndView.setViewName("/userindex");
		return modelAndView;
	}
	
	/**
	 * @Title: showUserIndxe
	 * @Description: 跳转到个人中心
	 * @return String @throws
	 */
	@RequestMapping("/userinfo")
	public ModelAndView userInfoManager( HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		if(userinfo == null){
			modelAndView.setViewName("/error");
		}else{
			userinfo = userService.geTUserinfoById(userinfo.getId());
			modelAndView.addObject("userinfo", userinfo);
			request.getSession().setAttribute("userinfo", userinfo);
			modelAndView.setViewName("/userinfo");
		}
		return modelAndView;
	}
	
	/** 
	 * @Title: changepw 
	 * @Description: 跳转到修改密码页面
	 * @return      
	 * @throws 
	 */
	@RequestMapping("/updatepswd")
	public ModelAndView changepw(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/updatepswd");
		return modelAndView;
	}
}
