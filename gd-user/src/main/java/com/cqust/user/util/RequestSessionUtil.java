package com.cqust.user.util;

import javax.servlet.http.HttpServletRequest;

public class RequestSessionUtil {
	
	public static Object getAttributeFromSession(HttpServletRequest request,String attributeName){
		return request.getSession().getAttribute(attributeName);
	}
	public static Integer setAttributeFromSession(HttpServletRequest request,String attributeName,Object attribute){
		request.getSession().setAttribute(attributeName,attribute);
		return 1;
	}
	

}
