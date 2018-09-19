package com.cqust.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.FileUploadResult;
import com.cqust.commom.pojo.HealthStatus;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TUserhealthinfo;
import com.cqust.pojo.TUserinfo;
import com.cqust.user.service.FileUploadService;
import com.cqust.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private FileUploadService fileUploadService;

	@Autowired
	private UserService userService;

	/** 
	 * @Title: updataUserInfo 
	 * @Description: 更新用户信息
	 * @param request 请求域
	 * @param file 用户上传文件(头像)
	 * @return
	 * @throws MultipartException      
	 * @throws 
	 */
	@RequestMapping(value = "/updateuserinfo", method = RequestMethod.POST)
	public ModelAndView updataUserInfo(HttpServletRequest request, @RequestParam MultipartFile file)
			throws MultipartException {
		ModelAndView modelAndView = new ModelAndView();

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		if (userinfo == null) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg","请登录！");
			return modelAndView;
		}
		if (file != null && file.getSize() != 0) {
			FileUploadResult result = fileUploadService.uploadHeadPicture(file);
			if(result.getStatus() == 200){
				String imageUrl = (String) result.getFileUrl();
				userinfo.setImage(imageUrl);
			}
		}

		 
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		Integer intSex = 0;
		try {
			intSex = Integer.parseInt(sex);
		} catch (Exception e) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg","性别错误！！");
			return modelAndView;
		}

		userinfo.setUsername(username);
		userinfo.setName(name);
		userinfo.setEmail(email);
		userinfo.setSex(intSex);
		
		
		modelAndView.addObject("userinfo", userinfo);
		userService.updateTUserInfoById(userinfo);
		request.getSession().setAttribute("userinfo", userinfo);
		modelAndView.setViewName("redirect:/user/userinfo.html");
		return modelAndView;
	}
	
	
	

	/** 
	 * @Title: changepw 
	 * @Description: 修改密码
	 * @param id	用户id
	 * @param oldpw 原密码
	 * @param newpw	新密码
	 * @param request	请求域
	 * @return      
	 * @throws 
	 */
	@RequestMapping("/changepw")
	@ResponseBody
	public GdResult changepw(Integer id, String oldpw, String newpw, HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		
		if (id != null && oldpw != null && newpw != null) {
			GdResult result = userService.changepw(userinfo.getId(), oldpw, newpw);
			return result;
		}
		return GdResult.build(400, "修改失败！");
	}

	
	/** 
	 * @Title: getUserHealthInfo 
	 * @Description: 跳转到健康表页面显示健康表
	 * @param id	用户id
	 * @param request
	 * @return      
	 * @throws 
	 */
	@RequestMapping("/userhealthinfo")
	public ModelAndView getUserHealthInfo(HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		if (userinfo == null) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg","请登录!");
			return modelAndView;
		} else {
			TUserhealthinfo userhealthinfo = userService.getUserHealthInfoByUId(userinfo.getId());
			modelAndView.addObject("userinfo", userinfo);
			request.getSession().setAttribute("userinfo", userinfo);
			modelAndView.setViewName("/healthinfo");
			request.getSession().setAttribute("healthinfo", userhealthinfo);
		}
		return modelAndView;
	}

	
	
	
	/** 
	 * @Title: updateUserHealthInfo 
	 * @Description: 更新用户健康表信息
	 * @param request 请求域
	 * @return      
	 * @throws 
	 */
	@RequestMapping(value = "/updateuserhealthinfo")
	@ResponseBody
	public Object updateUserHealthInfo(HttpServletRequest request) {
		
		GdResult result;
		
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		TUserhealthinfo healthinfo = new TUserhealthinfo();

		healthinfo.setUserid(userinfo.getId());
		healthinfo.setUsername(request.getParameter("username"));
		healthinfo.setHeight(Double.parseDouble(request.getParameter("height")));
		healthinfo.setWeight(Double.parseDouble(request.getParameter("weight")));
		healthinfo.setSex(Integer.parseInt(request.getParameter("sex")));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		healthinfo.setBirthday(date);
		healthinfo.setDietprefe(request.getParameter("dietprefe"));

		if ("0".equals(request.getParameter("healstatus"))) {
			healthinfo.setHealstatus(HealthStatus.HEALTHY);
		} else if ("1".equals(request.getParameter("healstatus"))) {
			healthinfo.setHealstatus(HealthStatus.SUBHEALTHY);
		} else if ("2".equals(request.getParameter("healstatus"))) {
			healthinfo.setHealstatus(HealthStatus.UNHEALTHY);
		}

		healthinfo.setSenfoods(request.getParameter("senfoods"));
		healthinfo.setMedhis(request.getParameter("medhis"));
		healthinfo.setNotlikefoods(request.getParameter("notlikefoods"));

		if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
			result = userService.addUserHealthInfo(healthinfo);
		} else {
			healthinfo.setId(Integer.parseInt(request.getParameter("id")));
			result = userService.updateUserHealthInfo(healthinfo);
		}

		request.getSession().setAttribute("userinfo", userinfo);
		request.getSession().setAttribute("healthinfo", healthinfo);
		return result;
	}
}
