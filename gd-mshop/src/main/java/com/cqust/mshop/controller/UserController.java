package com.cqust.mshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.FileUploadResult;
import com.cqust.commom.utils.GdResult;
import com.cqust.mshop.pojo.CustomLoginLog;
import com.cqust.mshop.service.FileUploadService;
import com.cqust.mshop.service.StoreService;
import com.cqust.mshop.service.UserService;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;

@Controller
@RequestMapping("/manager")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private StoreService storeService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	/**
	 * @Title: showUserIndxe
	 * @Description: 跳转到个人中心
	 * @return String @throws
	 */
	@RequestMapping("/user/userinfo")
	public ModelAndView userInfoManager( HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		userinfo = userService.getUserinfoByid(userinfo.getId());
		if(userinfo != null){
			request.getSession().setAttribute("userinfo", userinfo);
		}
		ModelAndView modelAndView = new ModelAndView();
		if(userinfo == null){
			modelAndView.setViewName("/error");
		}else{
			modelAndView.addObject("userinfo", userinfo);
			modelAndView.setViewName("/user/userinfo");
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/user/updateuserinfo", method = RequestMethod.POST)
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
		
		
		Integer result = userService.updateUserinfo(userinfo);
		if(result != 1){
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg","修改失败！！");
			return modelAndView;
		}
		modelAndView.addObject("userinfo", userinfo);
		request.getSession().setAttribute("userinfo", userinfo);
		modelAndView.setViewName("redirect:/manager/user/userinfo.html");
		return modelAndView;
	}

	@RequestMapping("/checklogin/{token}")
	public ModelAndView getUserInfo(@PathVariable String token, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if(token != null){
			TUserinfo user = userService.getUserByToken(token);
			
			if(user != null){
				request.getSession().setAttribute("user", user);
				TStoreinfo storeinfo = storeService.geTStoreinfoByUserid(user.getId());
				if(storeinfo == null){
					modelAndView.setViewName("/error");
					return modelAndView;
				}
				request.getSession().setAttribute("storeinfo", storeinfo);
				modelAndView.setViewName("redirect:/manager/main.html");
			}else{
				modelAndView.setViewName("/error");
			}
		}
		return modelAndView;
	}
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/main");
		return modelAndView;
	}
	
	
	@RequestMapping("/user/loginrecordpage")
	public ModelAndView loginrecordPage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/userloginlog");
		return modelAndView;
	}
	
	@RequestMapping("/user/loginrecord")
	@ResponseBody
	public List<CustomLoginLog> loginrecord(HttpServletRequest request){
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		List<CustomLoginLog> list = userService.getLoginLogByUid(userinfo.getId(),userinfo.getUsername());
		return list;
	}
	
	
	@RequestMapping("/user/changepwpage")
	public ModelAndView changepwpage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/changepd");
		return modelAndView;
	}
	
	@RequestMapping("/user/changepw")
	@ResponseBody
	public GdResult changepw(HttpServletRequest request){
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		String oldpswd = request.getParameter("oldpswd");
		String newpd = request.getParameter("newpd");
		GdResult r = userService.changepw(userinfo.getId(),oldpswd,newpd);
		return r;
	}
	
}
