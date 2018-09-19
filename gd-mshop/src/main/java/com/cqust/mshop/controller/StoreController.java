package com.cqust.mshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.FileUploadResult;
import com.cqust.mshop.service.FileUploadService;
import com.cqust.mshop.service.StoreService;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;

@Controller
@RequestMapping("/manager")
public class StoreController {

	@Autowired
	private StoreService storeService;

	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * @Title: showUserIndxe
	 * @Description: 跳转到个人中心
	 * @return String @throws
	 */
	@RequestMapping("/store/storeinfo")
	public ModelAndView userInfoManager(HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");

		ModelAndView modelAndView = new ModelAndView();
		if (userinfo == null | storeinfo == null) {
			modelAndView.setViewName("/error");
		} else {
			modelAndView.addObject("userinfo", userinfo);
			modelAndView.addObject("storeinfo", storeinfo);
			modelAndView.setViewName("/user/storeinfo");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/store/updatestoreinfo", method = RequestMethod.POST)
	public ModelAndView updateStoreinfo(HttpServletRequest request, @RequestParam MultipartFile file) {
		ModelAndView modelAndView = new ModelAndView();
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		String storename = request.getParameter("storename");
		String sphone = request.getParameter("sphone");
		String saddr = request.getParameter("saddr");
		String sdz = request.getParameter("sdz");

		storeinfo.setStorename(storename);
		storeinfo.setSphone(sphone);
		storeinfo.setSdz(sdz);
		storeinfo.setSaddr(saddr);

		if (file != null && file.getSize() != 0) {
			FileUploadResult result = fileUploadService.uploadShopPicture(file);
			if (result.getStatus() == 200) {
				String imageUrl = (String) result.getFileUrl();
				storeinfo.setStorelogoimg(imageUrl);
			}
		}

		int r = storeService.updateStoreinfo(storeinfo);
		if (r != 1) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg","修改失败！！");
			return modelAndView;
		}

		request.getSession().setAttribute("storeinfo", storeinfo);
		modelAndView.setViewName("redirect:/manager/store/storeinfo.html");
		return modelAndView;
	}

}
