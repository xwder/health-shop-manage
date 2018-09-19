package com.cqust.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.CookieUtils;
import com.cqust.pojo.TUserinfo;
import com.cqust.portal.service.UserService;

public class CommonInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 在Handler执行之前处理

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		if (userinfo == null) {
			// 从cookie中取token
			String token = CookieUtils.getCookieValue(request, "GD_TOKEN");
			// 根据token换取用户信息，调用sso系统的接口。
			TUserinfo user = userService.getUserByToken(token);
			if (user != null)
				request.getSession().setAttribute("userinfo", user);
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// handler执行之后，返回ModelAndView之前

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 返回ModelAndView之后。
		// 响应用户之后。

	}

}
