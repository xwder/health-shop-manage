package com.cqust.nutritionist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.DateUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.nutritionist.pojo.Food;
import com.cqust.nutritionist.pojo.Sport;
import com.cqust.nutritionist.service.HealthPlanService;
import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TSportplan;
import com.cqust.pojo.TUserhealthinfo;

@Controller
@RequestMapping("/plan")
public class HealthPlanController {
		
	@Autowired
	HealthPlanService healthPlanService;
	
	/**
	 * 显示饮食计划索引
	 * @Title: showdietplanindex 
	 * @Description: TODO
	 * @param id
	 * @param nid
	 * @return      
	 * @throws
	 */
	@RequestMapping("/showdietplanindex/{id}/{nid}")	
	public ModelAndView showdietplanindex(@PathVariable Integer id,@PathVariable Integer nid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.addObject("nid", nid);
		modelAndView.setViewName("/showdietplanindex");
		return modelAndView;
	}
	
	/**
	 * 显示运动计划索引
	 * @Title: showsportplanindex 
	 * @Description: TODO
	 * @param id
	 * @param nid
	 * @return      
	 * @throws
	 */
	@RequestMapping("/showsportplanindex/{id}/{nid}")	
	public ModelAndView showsportplanindex(@PathVariable Integer id,@PathVariable Integer nid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.addObject("nid", nid);
		modelAndView.setViewName("/showsportplanindex");
		return modelAndView;
	}
	
	
	/**
	 * 获取会员的基本信息
	 * @Title: getVipBasicInfo 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getVipBasicInfo/{id}")
	@ResponseBody
	public List<TUserhealthinfo> getVipBasicInfo(@PathVariable Integer id){
		return healthPlanService.getVipBasicInfo(id);
	}
	
	/**
	 * 添加饮食计划
	 * @Title: addFoodplan 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/addfoodplan")
	@ResponseBody
	public GdResult addFoodplan(HttpServletRequest httpServletRequest){		 			
		TPlanindex tPlanindex = (TPlanindex) httpServletRequest.getSession().getAttribute("dietindex");
		if(tPlanindex==null){
		   tPlanindex = new TPlanindex();
		   tPlanindex.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
		   tPlanindex.setNutritionistid(Integer.parseInt(httpServletRequest.getParameter("nutritionistid")));	
			try{
				tPlanindex.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
				tPlanindex.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		   tPlanindex.setPlantype(0);
		   healthPlanService.addFoodplanIndex(tPlanindex);
		   tPlanindex = healthPlanService.getFoodplanIndex();
		   httpServletRequest.getSession().setAttribute("dietindex", tPlanindex);
		}
		tPlanindex = (TPlanindex) httpServletRequest.getSession().getAttribute("dietindex");				
		try {
			Date plandate = new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate"));
			List<Food> foods = JsonUtils.jsonToList(httpServletRequest.getParameter("food"), Food.class);
			for (int i = 0; i < foods.size(); i++) {
				TDietplan tDietplan = new TDietplan();
				tDietplan.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
				tDietplan.setFoodid(foods.get(i).getId());
				tDietplan.setNutritionistid(Integer.parseInt(httpServletRequest.getParameter("nutritionistid")));
				tDietplan.setFoodname(foods.get(i).getFoodname());
				tDietplan.setFoodquantity(foods.get(i).getFoodquantity());
				tDietplan.setActualweight(0.0);
				tDietplan.setType(foods.get(i).getType());
				tDietplan.setPlandate(plandate);
				tDietplan.setPlanid(tPlanindex.getId());
				healthPlanService.addFoodplan(tDietplan);
			}
			tPlanindex.setEnddate(plandate);
			healthPlanService.updateFoodplanIndex(tPlanindex);
			return GdResult.build(200, "添加成功!");
		} catch (ParseException e) {
			e.printStackTrace();
		}			
		return GdResult.build(400, "添加失败!");
	}
	
	/**
	 * 添加运动计划
	 * @Title: addSportplan 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/addsportplan")
	@ResponseBody
	public GdResult addSportplan(HttpServletRequest httpServletRequest){
		TPlanindex tPlanindex = (TPlanindex) httpServletRequest.getSession().getAttribute("sportindex");
		if(tPlanindex==null){
		   tPlanindex = new TPlanindex();
		   tPlanindex.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
		   tPlanindex.setNutritionistid(Integer.parseInt(httpServletRequest.getParameter("nutritionistid")));	
			try{
				tPlanindex.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
				tPlanindex.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		   tPlanindex.setPlantype(1);
		   healthPlanService.addFoodplanIndex(tPlanindex);
		   tPlanindex = healthPlanService.getSportplanIndex();
		   httpServletRequest.getSession().setAttribute("sportindex", tPlanindex);
		}
		tPlanindex = (TPlanindex) httpServletRequest.getSession().getAttribute("sportindex");				
		try {
			Date plandate = new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate"));
			List<Sport> sports = JsonUtils.jsonToList(httpServletRequest.getParameter("sport"), Sport.class);
			for (int i = 0; i < sports.size(); i++) {
				TSportplan tSportplan = new TSportplan();
				tSportplan.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
				tSportplan.setSportid(sports.get(i).getId());
				tSportplan.setNutritionistid(Integer.parseInt(httpServletRequest.getParameter("nutritionistid")));
				tSportplan.setSportname(sports.get(i).getSportname());
				tSportplan.setSportdescribe(sports.get(i).getSportdescribe());
				tSportplan.setPlandate(plandate);
				tSportplan.setPlanid(tPlanindex.getId());
				healthPlanService.addSportplan(tSportplan);
			}
			tPlanindex.setEnddate(plandate);
			healthPlanService.updateFoodplanIndex(tPlanindex);
			return GdResult.build(200, "添加成功!");
		} catch (ParseException e) {			
			e.printStackTrace();
		}					
		return GdResult.build(400, "添加失败!");
	}
			
    /**
     * 清空饮食计划索引
     * @Title: deldietplanIndex 
     * @Description: TODO
     * @param httpServletRequest
     * @return      
     * @throws
     */
	@RequestMapping("/deldietplanindex")
	@ResponseBody
	public void deldietplanIndex(HttpServletRequest httpServletRequest){		
		httpServletRequest.getSession().removeAttribute("dietindex");		
	}
	 /**
     * 清空运动计划索引
     * @Title: delsportplanIndex 
     * @Description: TODO
     * @param httpServletRequest
     * @return      
     * @throws
     */
	@RequestMapping("/delsportplanindex")
	@ResponseBody
	public void delsportplanIndex(HttpServletRequest httpServletRequest){		
		httpServletRequest.getSession().removeAttribute("sportindex");		
	}
	
	
	/**
	 * 获得饮食计划索引
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getdietplanindex/{id}/{nid}")
	@ResponseBody
	public List<TPlanindex> getdietplanindex(@PathVariable Integer id,@PathVariable Integer nid){
		return healthPlanService.getdietplanindex(id, nid);
	}
	
	/**
	 * 获得运动计划索引
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsportplanindex/{id}/{nid}")
	@ResponseBody
	public List<TPlanindex> getsportplanindex(@PathVariable Integer id,@PathVariable Integer nid){
		return healthPlanService.getsportplanindex(id, nid);
	}
	
	/**
	 * 根据饮食计划索引获取每一天的饮食计划
	 * @Title: geteverydaydietplan 
	 * @Description: TODO
	 * @param uid
	 * @param nid
	 * @param planid
	 * @param plandate
	 * @return      
	 * @throws
	 */
	@RequestMapping("/geteverydaydietplan/{uid}/{nid}/{planid}/{plandate}")
	@ResponseBody
	public List<TDietplan> geteverydaydietplan(@PathVariable Integer uid,@PathVariable Integer nid,@PathVariable Integer planid,@PathVariable String plandate){
		Date date;
		try {
			date = DateUtil.stringToDate(plandate, "yyyy-MM-dd");
			return healthPlanService.geteverydaydietplan(uid, nid, planid, date);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据运动计划索引获取每一天的运动计划
	 * @Title: geteverydaysportplan 
	 * @Description: TODO
	 * @param uid
	 * @param nid
	 * @param planid
	 * @param plandate
	 * @return      
	 * @throws
	 */
	@RequestMapping("/geteverydaysportplan/{uid}/{nid}/{planid}/{plandate}")
	@ResponseBody
	public List<TSportplan> geteverydaysportplan(@PathVariable Integer uid,@PathVariable Integer nid,@PathVariable Integer planid,@PathVariable String plandate){
		Date date;
		try {
			date = DateUtil.stringToDate(plandate, "yyyy-MM-dd");
			return healthPlanService.geteverydaysportplan(uid, nid, planid, date);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		return null;
	}
}
