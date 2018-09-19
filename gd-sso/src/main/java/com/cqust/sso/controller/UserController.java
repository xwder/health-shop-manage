package com.cqust.sso.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.ExceptionUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TUserinfo;
import com.cqust.sso.service.UserService;


/** 
* @ClassName: UserController 
* @Description: TODO 用户Controller
* @author Joe  
* @date 2016年12月18日 下午9:50:30 
*  
*/
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	
	private UserService userService;

	/** 
	* @Title: checkData 校验数据合法性  用户名 电话 邮箱是否已存在
	* @Description: TODO 格式如：zhangsan/ 1，其中zhangsan是校验的数据，type为类型，
	* 							可选参数1、2、3分别代表username、phone、email
	* @param   param 参数
	* @param   type 参数类型 
	* @param   callback 是否有回调  jsonp跨域使用
	* @return Object    
	* @throws 
	*/
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable String param, @PathVariable Integer type, String callback) {

		GdResult result = null;
		String params = null;
		try {
			params = new String(param.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		// 参数有效性校验
		if (StringUtils.isBlank(params)) {
			result = GdResult.build(400, "校验内容不能为空");
		}
		if (type == null) {
			result = GdResult.build(400, "校验内容类型不能为空");
		}
		if (type != 1 && type != 2 && type != 3) {
			result = GdResult.build(400, "校验内容类型错误");
		}
		// 校验出错
		if (null != result) {
			if (null != callback) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			} else {
				return result;
			}
		}
		// 调用服务
		try {
			result = userService.checkData(params, type);

		} catch (Exception e) {
			result = GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		if (null != callback) {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		} else {
			return result;
		}
	}

	/** 
	* @Title: createUser 
	* @Description: TODO 创建用户
	* @param   user
	* @return GdResult    
	* @throws 
	*/
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public GdResult createUser(TUserinfo user) {

		try {
			GdResult result = userService.createUser(user);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public GdResult userLogin(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		try {

			GdResult result = userService.userLogin(username, password, request, response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	// 用户登录
	@RequestMapping(value = "/mlogin", method = RequestMethod.POST)
	@ResponseBody
	public GdResult userManagerLogin(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String strIdentity = request.getParameter("identity");
			Integer identity = Integer.parseInt(strIdentity);
			GdResult result = userService.userManagerLogin(username, password, identity,request, response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	/** 
	* @Title: getUserByToken 
	* @Description: TODO 根据用户token获取用户信息
	* @param   token
	* @param   callback
	* @return Object    
	* @throws 
	*/
	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback) {
		GdResult result = null;
		try {
			result = userService.getUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		// 判断是否为jsonp调用
		if (StringUtils.isBlank(callback)) {
			return result;
		} else {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}

	}

	/** 
	* @Title: logout 
	* @Description:   根据用户token退出登录 
	* @param   token
	* @param   callback
	* @return Object    
	* @throws 
	*/
	@RequestMapping("/logout/{token}")
	@ResponseBody
	public Object logout(@PathVariable String token, String callback) {
		GdResult result = null;
		try {
			result = userService.logout(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		// 判断是否为jsonp调用
		if (StringUtils.isBlank(callback)) {
			return result;
		} else {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
	}
	
	@RequestMapping("changepw/{id}/{oldpw}/{newpw}")
	@ResponseBody
	public Object changepw(@PathVariable Integer id,@PathVariable String  oldpw,@PathVariable String newpw){
		GdResult result = null;
		try {
			result = userService.changepw(id, oldpw, newpw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		return result;
	}
}
