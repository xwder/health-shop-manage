package com.cqust.manager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.manager.service.SellerService;
import com.cqust.pojo.TStoreapplication;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;

@Controller
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	SellerService sellerService;
	
	
	@RequestMapping("/getsellerapplication")
	@ResponseBody
	/**
	 * 获取商家申请信息
	 * @Title: getSellerApplication 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	public List<TStoreapplication> getSellerApplication(){
		return sellerService.getSellerApplication();
	}
	/**
	 * 更改商家申请状态
	 * @Title: updateSellerApplication 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/updatesellerapplication")
	@ResponseBody
	public GdResult updateSellerApplication(HttpServletRequest httpServletRequest){
		TStoreapplication tStoreapplication = new TStoreapplication();
		TUserinfo tUserinfo = new TUserinfo();
		tStoreapplication.setId(Integer.parseInt(httpServletRequest.getParameter("id")));		
		tStoreapplication.setSqstatus(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		tUserinfo.setId(Integer.parseInt(httpServletRequest.getParameter("userid")));
		tUserinfo.setIsstore(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		try {
			tUserinfo.setUpdatedtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("updatedTime")));
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		//保存商家信息
		TStoreinfo storeinfo = new TStoreinfo();
		TStoreapplication storeapplication = sellerService.getStoreAppInfoById(Integer.parseInt(httpServletRequest.getParameter("id")));
		if(storeapplication == null){
			return GdResult.build(500, "修改失败！");
		}
		storeinfo.setUserid(storeapplication.getUserid());
		storeinfo.setStorelogoimg(storeapplication.getStorelogoimg());
		storeinfo.setStorename(storeapplication.getStorename());
		storeinfo.setSname(storeapplication.getOwnname());
		storeinfo.setSphone(storeapplication.getPhone());
		storeinfo.setSid(storeapplication.getUid());
		storeinfo.setSlicense(storeapplication.getStorelicenseid());
		storeinfo.setSdz(storeapplication.getStoreaddr());
		storeinfo.setSaddr(storeapplication.getDetailaddr());
		storeinfo.setIsCheck(1);
		switch (storeapplication.getStoretype()) {
		case 1:
			storeinfo.setStype("蔬菜类");
			break;
		case 2:
			storeinfo.setStype("水果类");
			break;
		case 3:
			storeinfo.setStype("肉类");
			break;
		case 4:
			storeinfo.setStype("熟食");
			break;
		case 5:
			storeinfo.setStype("谷物");
			break;
		case 6:
			storeinfo.setStype("综合");
			break;

		default:
			break;
		}
		Integer res = sellerService.addSellerInfo(storeinfo);
		GdResult r = sellerService.updateSellerApplication(tStoreapplication,tUserinfo);	
		if(res ==1 & r.getStatus() == 200)
			return GdResult.ok();
		
		return null;	
	}
	
	/**
	 * 获取商家信息
	 * @Title: getSellerInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("getsellerinfo")
	@ResponseBody
	public List<TUserinfo> getSellerInfo(){
		return sellerService.getSellerInfo();		
	}
}
