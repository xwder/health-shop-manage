package com.cqust.mshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.mshop.pojo.CustomPbrowseRecord;
import com.cqust.mshop.service.ItemService;
import com.cqust.pojo.TStoreinfo;

@RequestMapping("/manager")
@Controller
public class RecordController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/record/pbrowsepage")
	public ModelAndView pbrowsePage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/record/productrecord");
		return modelAndView;
	}
	
	@RequestMapping("/record/pbrowselist")
	@ResponseBody
	public List<CustomPbrowseRecord> pbrowselist(HttpServletRequest request){
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		List<CustomPbrowseRecord> list = itemService.geTPbrowserecords(storeinfo.getId());
		for(int i = 0;i<list.size();i++){
			CustomPbrowseRecord customPbrowseRecord = list.get(i);
			if(customPbrowseRecord.getUsertype() == 1){
				customPbrowseRecord.setStrusertype("游客");
			}else{
				customPbrowseRecord.setStrusertype("登录用户");
			}
		}
		
		return list;
	}

}
