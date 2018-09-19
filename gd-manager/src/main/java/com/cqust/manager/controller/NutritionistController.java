package com.cqust.manager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.GdResult;
import com.cqust.manager.service.NutritionistService;
import com.cqust.pojo.TDietapplication;
import com.cqust.pojo.TDietitian;
import com.cqust.pojo.TUserinfo;

@Controller
@RequestMapping("/nutritionist")
public class NutritionistController {
	
	@Autowired
	NutritionistService nutritionistService;
	
	/**
	 * 获取营养师申请信息
	 * @Title: geTDietApplication 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/geTDietApplication")
	@ResponseBody
	public List<TDietapplication> geTDietApplication(){
		return nutritionistService.getDietApplication();
	}
	/**
	 * 更改营养师申请状态
	 * @Title: updateDietApplication 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/updatedietapplication")
	@ResponseBody
	public GdResult updateDietApplication(HttpServletRequest httpServletRequest) {
		TDietapplication tDietapplication = new TDietapplication();
		TUserinfo tUserinfo = new TUserinfo();
		tDietapplication.setId(Integer.parseInt(httpServletRequest.getParameter("id")));		
		tDietapplication.setSqstatus(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		tUserinfo.setId(Integer.parseInt(httpServletRequest.getParameter("userid")));
		tUserinfo.setIsdiet(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		try {
			tUserinfo.setUpdatedtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("updatedTime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//保存营养师信息
		TDietapplication dietapplication = nutritionistService.getDietitianAppInfoById(Integer.parseInt(httpServletRequest.getParameter("id")));
		if(dietapplication == null){
			return GdResult.build(500, "修改失败！");
		}
		TDietitian dietitian = new TDietitian();
		dietitian.setUserid(dietapplication.getUserid());
		dietitian.setUsername(dietapplication.getUsername());
		dietitian.setUid(dietapplication.getUid());
		dietitian.setUidimageurl(dietapplication.getUidimagesurl());
		dietitian.setDietlicense(dietapplication.getDietlicense());
		dietitian.setDietimageurl(dietapplication.getDietimageurl());
		dietitian.setSqdate(dietapplication.getSqdate());
		dietitian.setStatus(1);
		int r = nutritionistService.addDietitianInfo(dietitian);
		GdResult result = nutritionistService.updateDietApplication(tDietapplication,tUserinfo);
		if(r == 1&& result.getStatus() == 200){
			return GdResult.ok();
		}
		
		return null;
	}
	/**
	 * 获取营养师信息
	 * @Title: getNutritionistInfo 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getnutritionistinfo")
	@ResponseBody
	public List<TUserinfo> getNutritionistInfo(){
		return nutritionistService.getNutritionistInfo();
	}
	
	@RequestMapping("/allnutritionist")
	@ResponseBody
	public List<TDietitian> allnutritionist(){
		List<TDietitian> list = nutritionistService.geTDietitians();
		return list;
	}
	
	@RequestMapping("/nutritionistlistpage")
	public ModelAndView nutritionistlistpage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/nutritionistlist");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/nutritionistlist")
	public List<TDietitian> nutritionistlist(HttpServletRequest request){
		List<TDietitian> list = nutritionistService.geTDietitians();
		return list;
	}

}
