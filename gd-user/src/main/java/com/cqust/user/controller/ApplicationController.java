package com.cqust.user.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.FileUploadResult;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TDietapplication;
import com.cqust.pojo.TStoreapplication;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipapplication;
import com.cqust.user.service.ApplicationService;
import com.cqust.user.service.FileUploadService;

@Controller
@RequestMapping("/user/app")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * 
	 * @Title: getUserVipApp
	 * @Description: 获取用户申请高级会员申请表信息
	 * @param id
	 *            会员ID
	 * @param request
	 * @return @throws
	 */
	@RequestMapping("/uservip")
	public ModelAndView getUserVipApp(HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		if (userinfo == null) {
			modelAndView.setViewName("/error");
		} else {
			TVipapplication uservipapp = applicationService.getVipApplication(userinfo.getId());
			modelAndView.addObject("userinfo", userinfo);
			request.getSession().setAttribute("userinfo", userinfo);
			request.getSession().setAttribute("uservipapp", uservipapp);
			modelAndView.setViewName("/uservipapplication");
		}
		return modelAndView;
	}

	/**
	 * @Title: addUserVipApplication @Description: 添加成为高级会员申请 @param
	 * request @return @throws
	 */
	@RequestMapping(value = "/uservipapp")
	@ResponseBody
	public Object addUserVipApplication(HttpServletRequest request) {
		TVipapplication app = new TVipapplication();
		String username = request.getParameter("username");
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		if (userinfo != null && username != null) {
			app.setSqstatus(2);
			app.setUserid(userinfo.getId());
			app.setUsername(username);
			app.setSqdate(new Date());
			return applicationService.addUserVipApplication(app);
		}
		return GdResult.build(400, "申请表提交失败！");
	}

	/**
	 * 
	 * @Title: getUserVipApp
	 * @Description: 获取用户申请高级会员申请表信息
	 * @param id
	 *            会员ID
	 * @param request
	 * @return @throws
	 */
	@RequestMapping("/dietapp")
	public ModelAndView getDietApp(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		request.getSession().setAttribute("userinfo", userinfo);
		modelAndView.addObject("userinfo", userinfo);
		if (userinfo == null) {
			modelAndView.setViewName("/error");
			return modelAndView;
		} else {
			TDietapplication dietapp = applicationService.getDeitApplication(userinfo.getId());
			modelAndView.addObject("dietapp", dietapp);
			modelAndView.setViewName("/dietapp");
		}

		return modelAndView;
	}

	/**
	 * @Title: addDietApp @Description: 添加营养师申请信息 @param request @param
	 * files @return @throws MultipartException @throws
	 */
	@RequestMapping(value = "/adddietapp", method = RequestMethod.POST)
	@ResponseBody
	public Object addDietApp(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile files[])
			throws MultipartException {
		TDietapplication dietapplication = new TDietapplication();
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		GdResult result;
		if (userinfo == null) {
			return GdResult.build(400, "申请表提交失败！");
		}
		for (int i = 0; i < files.length; i++) {
			// 文件上传
			if(files.length < 2){
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", "申请表提交失败!信息不完整");
				return modelAndView;
			}
			//上传身份证图片
			CommonsMultipartFile uidFile = files[0];
			if(uidFile != null & uidFile.getSize() > 0){
				FileUploadResult uidresult = fileUploadService.uploadUserInfoPicture(uidFile);
				if(uidresult.getStatus()==200){
					dietapplication.setUidimagesurl(uidresult.getFileUrl());
				}
			}
			//上传营业执照图片
			CommonsMultipartFile zzFile = files[1];
			if(zzFile != null & zzFile.getSize() > 0){
				FileUploadResult zzresult = fileUploadService.uploadUserInfoPicture(zzFile);
				if(zzresult.getStatus()==200){
					dietapplication.setDietimageurl(zzresult.getFileUrl());
				}
			}
		}
		
		String username = request.getParameter("username");
		String uid = request.getParameter("uid");
		String dietlicense = request.getParameter("dietlicense");
		if (username != null && uid != null && dietlicense != null && userinfo != null) {
			dietapplication.setUsername(username);
			dietapplication.setUserid(userinfo.getId());
			dietapplication.setUid(uid);
			dietapplication.setSqdate(new Date());
			dietapplication.setSqstatus(2);
			dietapplication.setDietlicense(dietlicense);
			result = applicationService.addDietApplication(dietapplication);
			if(result.getStatus() != 200){
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", result.getMsg());
				return modelAndView;
			}
			 
				modelAndView.setViewName("redirect:/user/app/dietapp.html");
				return modelAndView;
			 
		}
		
		return null;
	}

	@RequestMapping("/storeapp")
	public ModelAndView getStoreApp(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		request.getSession().setAttribute("userinfo", userinfo);
		modelAndView.addObject("userinfo", userinfo);
		if (userinfo == null) {
			modelAndView.setViewName("/error");
			return modelAndView;
		} else {
			TStoreapplication storeapp = applicationService.geTStoreapplication(userinfo.getId());
			modelAndView.addObject("storeapp", storeapp);
			modelAndView.setViewName("/storeapp");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/addstoreapp", method = RequestMethod.POST)
	@ResponseBody
	public Object addStoreApp(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile files[])
			throws MultipartException {

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		GdResult result;
		TStoreapplication storeapp = new TStoreapplication();
		if (userinfo == null) {
			return GdResult.build(400, "申请表提交失败！");
		}
		if (files != null & files.length > 0) {
			if(files.length < 3){
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", "申请表提交失败!信息不完整");
				return modelAndView;
			}
			try {
				//上传身份证图片
				CommonsMultipartFile uidFile = files[0];
				if(uidFile != null & uidFile.getSize() > 0){
					FileUploadResult uidresult = fileUploadService.uploadUserInfoPicture(uidFile);
					if(uidresult.getStatus()==200){
						storeapp.setUidimageurl(uidresult.getFileUrl());
					}
				}
				//上传营业执照图片
				CommonsMultipartFile zzFile = files[1];
				if(zzFile != null & zzFile.getSize() > 0){
					FileUploadResult zzresult = fileUploadService.uploadUserInfoPicture(zzFile);
					if(zzresult.getStatus()==200){
						storeapp.setLicenseimageurl(zzresult.getFileUrl());
					}
				}
				//上传店铺logo
				CommonsMultipartFile logoFile = files[2];
				if(logoFile != null & logoFile.getSize() > 0){
					FileUploadResult logoresult = fileUploadService.uploadUserInfoPicture(uidFile);
					if(logoresult.getStatus()==200){
						storeapp.setStorelogoimg(logoresult.getFileUrl());
					}
				}
			} catch (Exception e) {
				
			}
			
		}
		String ownname = request.getParameter("ownname");
		String phone = request.getParameter("phone");
		String uid = request.getParameter("uid");
		String storename = request.getParameter("storename");
		String storeaddr = request.getParameter("storeaddr");
		String detailaddr = request.getParameter("detailaddr");
		String storelicenseid = request.getParameter("storelicenseid");
		Integer storeType = Integer.parseInt(request.getParameter("storetype"));

		storeapp.setUserid(userinfo.getId());
		storeapp.setOwnname(ownname);
		storeapp.setPhone(phone);
		storeapp.setUid(uid);
		storeapp.setStorename(storename);
		storeapp.setStoreaddr(storeaddr);
		storeapp.setDetailaddr(detailaddr);
		storeapp.setStorelicenseid(storelicenseid);
		storeapp.setStoretype(storeType);
		storeapp.setSqdate(new Date());
		storeapp.setSqstatus(2);

		result = applicationService.addStoreApplication(storeapp);
		if (result.getStatus() == 200) {
			modelAndView.setViewName("redirect:/user/app/storeapp.html");
			return modelAndView;
		}
		modelAndView.setViewName("/error");
		modelAndView.addObject("msg", "申请表提交失败!");
		return modelAndView;
	}

}
