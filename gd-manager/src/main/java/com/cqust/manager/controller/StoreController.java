package com.cqust.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.manager.pojo.CustomStoreinfo;
import com.cqust.manager.service.StoreService;
import com.cqust.pojo.TStoreinfo;

@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/storelistpage")
	public ModelAndView storelistpage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/storelist");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/storelist")
	public List<CustomStoreinfo> allstore(HttpServletRequest request){
		List<TStoreinfo> list = storeService.getStores();
		List<CustomStoreinfo> customStoreinfos = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			CustomStoreinfo customStoreinfo = new CustomStoreinfo();
			TStoreinfo storeinfo = list.get(i);
			customStoreinfo.setId(storeinfo.getId());
			customStoreinfo.setUserid(storeinfo.getUserid());
			customStoreinfo.setStorelogoimg(storeinfo.getStorelogoimg());
			customStoreinfo.setStorename(storeinfo.getStorename());
			customStoreinfo.setSname(storeinfo.getSname());
			customStoreinfo.setSphone(storeinfo.getSphone());
			customStoreinfo.setSid(storeinfo.getSid());
			customStoreinfo.setSlicense(storeinfo.getSlicense());
			customStoreinfo.setSdz(storeinfo.getSdz());
			customStoreinfo.setSaddr(storeinfo.getSaddr());
			customStoreinfo.setIsCheck(storeinfo.getIsCheck());
			customStoreinfo.setStype(storeinfo.getStype());
			if(storeinfo.getIsCheck() == 1){
				customStoreinfo.setStrcheck("审核通过");
			}
			customStoreinfos.add(customStoreinfo);
		}
		return customStoreinfos;
	}

}
