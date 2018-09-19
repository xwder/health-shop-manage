package com.cqust.nutritionist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.service.VipService;
import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipdietapplication;

@Controller
@RequestMapping("/vip")
public class VipController {
	@Autowired 
	private VipService vipService;	
	/**
	 * 获取会员的基本信息
	 * @Title: geTUserinfos 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getvipinfo/{id}")
	@ResponseBody
	public List<TUserinfo> geTUserinfos(@PathVariable Integer id){
		 return vipService.geTUserinfos(id);
	}
	/**
	 * 获取会员的健康信息
	 * @Title: geTUserhealthinfos 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getuserhealthinfo/{id}")
	@ResponseBody
	public GdResult geTUserhealthinfos(@PathVariable Integer id){
		GdResult result  = vipService.geTUserhealthinfos(id);
		return result;
	}
	/**
	 * 获取会员的申请信息
	 * @Title: getVipapplication 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getvipapplication/{id}")
	@ResponseBody
	public List<TVipdietapplication> getVipapplication(@PathVariable Integer id){
		return vipService.getVipapplication(id);
	}
    
	/**
	 * 更改会员申请状态
	 * @Title: updateVipapplication 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/updatevipapplication")
	@ResponseBody
	public GdResult updateVipapplication(HttpServletRequest httpServletRequest){
		TVipdietapplication tVipdietapplication = new TVipdietapplication();
		TUserinfo tUserinfo = new TUserinfo();
		tVipdietapplication.setId(Integer.parseInt(httpServletRequest.getParameter("id")));
		tVipdietapplication.setSqstatus(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		tUserinfo.setId(Integer.parseInt(httpServletRequest.getParameter("uid")));
		tUserinfo.setDietitianid(Integer.parseInt(httpServletRequest.getParameter("nid")));
		try {
			tUserinfo.setUpdatedtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("updatedTime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return vipService.updateVipapplication(tVipdietapplication, tUserinfo);
	}
	
	/**
	 * 为会员添加消息提醒
	 * @Title: addMessageremind 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/addmessageremind")
	@ResponseBody
	public GdResult addMessageremind(HttpServletRequest httpServletRequest){
		TMessageremind tMessageremind = new TMessageremind();
		tMessageremind.setUserid(Integer.parseInt(httpServletRequest.getParameter("uid")));
		tMessageremind.setNid(Integer.parseInt(httpServletRequest.getParameter("nid")));
		tMessageremind.setMessage(httpServletRequest.getParameter("message"));
		try {
			tMessageremind.setMessagetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("messagetime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vipService.addMessageremind(tMessageremind);
	}
	/**
	 * 营养师删除某一个会员
	 * @Title: deleteVip 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/deletevip/{uid}/{nid}")
	@ResponseBody
	public GdResult deleteVip(@PathVariable Integer uid,@PathVariable Integer nid){
		return vipService.deleteVip(uid,nid);		
	}
			
}
