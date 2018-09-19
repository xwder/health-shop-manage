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
import com.cqust.manager.service.VipService;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipapplication;

@Controller
@RequestMapping("/vip")
public class VipController {
	@Autowired
	VipService vipService;
	
	/**
	 * 获取高级会员申请信息
	 * @Title: getVipApplication 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getvipapplication")
	@ResponseBody
	public List<TVipapplication> getVipApplication(){
		return vipService.getVipApplication();	
	}
	
	/**
	 * 更改高级会员申请状态
	 * @Title: updateVipApplication 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/updatevipapplication")
	@ResponseBody
	public GdResult updateVipApplication(HttpServletRequest httpServletRequest){
		TVipapplication tVipapplication = new TVipapplication();
		TUserinfo tUserinfo = new TUserinfo();
		tVipapplication.setId(Integer.parseInt(httpServletRequest.getParameter("id")));		
		tVipapplication.setSqstatus(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		tUserinfo.setId(Integer.parseInt(httpServletRequest.getParameter("userid")));
		tUserinfo.setIsVip(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		try {
			tUserinfo.setUpdatedtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("updatedTime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return vipService.updateVipApplication(tVipapplication,tUserinfo);
	}
	/**
	 * 获取会员信息
	 * @Title: getVipInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getvipinfo")
	@ResponseBody
	public List<TUserinfo> getVipInfo(){
		return vipService.getVipInfo();		
	}
    
	/**
	 * 获取高级会员信息
	 * @Title: getSuperVipInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsuperinfo")
	@ResponseBody
	public List<TUserinfo> getSuperVipInfo(){
		return vipService.getSuperInfo();		
	}
	
}
