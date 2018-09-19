package com.cqust.user.controller;

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
import com.cqust.pojo.TDietplanbyself;
import com.cqust.pojo.TPlanindexbyself;
import com.cqust.pojo.TSportplanbyself;
import com.cqust.user.pojo.Food;
import com.cqust.user.pojo.Sport;
import com.cqust.user.service.HealthPlanService;

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
		TPlanindexbyself tPlanindexbyself = (TPlanindexbyself) httpServletRequest.getSession().getAttribute("dietindexbyself");
		if(tPlanindexbyself==null){
		   tPlanindexbyself = new TPlanindexbyself();
		   tPlanindexbyself.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));		   
			try{
				tPlanindexbyself.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
				tPlanindexbyself.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		   tPlanindexbyself.setPlantype(0);
		   healthPlanService.addFoodplanIndex(tPlanindexbyself);
		   tPlanindexbyself = healthPlanService.getFoodplanIndex();
		   httpServletRequest.getSession().setAttribute("dietindexbyself", tPlanindexbyself);
		}
		tPlanindexbyself = (TPlanindexbyself) httpServletRequest.getSession().getAttribute("dietindexbyself");				
		try {
			Date plandate = new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate"));
			List<Food> foods = JsonUtils.jsonToList(httpServletRequest.getParameter("food"), Food.class);
			for (int i = 0; i < foods.size(); i++) {
				TDietplanbyself tDietplanbyself = new TDietplanbyself();
				tDietplanbyself.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
				tDietplanbyself.setFoodid(foods.get(i).getId());			
				tDietplanbyself.setFoodname(foods.get(i).getFoodname());
				tDietplanbyself.setFoodquantity(foods.get(i).getFoodquantity());
				tDietplanbyself.setActualweight(0.0);
				tDietplanbyself.setType(foods.get(i).getType());
				tDietplanbyself.setPlandate(plandate);
				tDietplanbyself.setPlanid(tPlanindexbyself.getId());
				healthPlanService.addFoodplan(tDietplanbyself);
			}
			tPlanindexbyself.setEnddate(plandate);
			healthPlanService.updateFoodplanIndex(tPlanindexbyself);
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
		TPlanindexbyself tPlanindexbyself = (TPlanindexbyself) httpServletRequest.getSession().getAttribute("sportindexbyself");
		if(tPlanindexbyself==null){
		   tPlanindexbyself = new TPlanindexbyself();
		   tPlanindexbyself.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));		  
			try{
				tPlanindexbyself.setStartdate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
				tPlanindexbyself.setEnddate(new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate")));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		   tPlanindexbyself.setPlantype(1);
		   healthPlanService.addFoodplanIndex(tPlanindexbyself);
		   tPlanindexbyself = healthPlanService.getSportplanIndex();
		   httpServletRequest.getSession().setAttribute("sportindexbyself", tPlanindexbyself);
		}
		tPlanindexbyself = (TPlanindexbyself) httpServletRequest.getSession().getAttribute("sportindexbyself");				
		try {
			Date plandate = new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("plandate"));
			List<Sport> sports = JsonUtils.jsonToList(httpServletRequest.getParameter("sport"), Sport.class);
			for (int i = 0; i < sports.size(); i++) {
				TSportplanbyself tSportplanbyself = new TSportplanbyself();
				tSportplanbyself.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
				tSportplanbyself.setSportid(sports.get(i).getId());				
				tSportplanbyself.setSportname(sports.get(i).getSportname());
				tSportplanbyself.setSportdescribe(sports.get(i).getSportdescribe());
				tSportplanbyself.setPlandate(plandate);
				tSportplanbyself.setPlanid(tPlanindexbyself.getId());
				healthPlanService.addSportplan(tSportplanbyself);
			}
			tPlanindexbyself.setEnddate(plandate);
			healthPlanService.updateFoodplanIndex(tPlanindexbyself);
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
		httpServletRequest.getSession().removeAttribute("dietindexbyself");		
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
		httpServletRequest.getSession().removeAttribute("sportindexbyself");		
	}
	
	
	/**
	 * 获得饮食计划索引
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getdietplanindex/{id}")
	@ResponseBody
	public List<TPlanindexbyself> getdietplanindex(@PathVariable Integer id){
		return healthPlanService.getdietplanindex(id);
	}
	
	/**
	 * 获得运动计划索引
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsportplanindex/{id}")
	@ResponseBody
	public List<TPlanindexbyself> getsportplanindex(@PathVariable Integer id){
		return healthPlanService.getsportplanindex(id);
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
	@RequestMapping("/geteverydaydietplan/{uid}/{planid}/{plandate}")
	@ResponseBody
	public List<TDietplanbyself> geteverydaydietplan(@PathVariable Integer uid,@PathVariable Integer planid,@PathVariable String plandate){
		Date date;
		try {
			date = DateUtil.stringToDate(plandate, "yyyy-MM-dd");
			return healthPlanService.geteverydaydietplan(uid, planid, date);
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
	@RequestMapping("/geteverydaysportplan/{uid}/{planid}/{plandate}")
	@ResponseBody
	public List<TSportplanbyself> geteverydaysportplan(@PathVariable Integer uid,@PathVariable Integer planid,@PathVariable String plandate){
		Date date;
		try {
			date = DateUtil.stringToDate(plandate, "yyyy-MM-dd");
			return healthPlanService.geteverydaysportplan(uid, planid, date);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据用户id和日期获取饮食计划索引（获取今日饮食计划）
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getdietplanindexBydate/{id}/{date}")
	@ResponseBody
	public List<TPlanindexbyself> getdietplanindexBydate(@PathVariable Integer id,@PathVariable String date){
		return healthPlanService.getdietplanindexBydate(id, date);
	}
	
	/**
	 * 根据用户id和日期获取运动计划索引（获取今日运动计划）
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsportplanindexBydate/{id}/{date}")
	@ResponseBody
	public List<TPlanindexbyself> getsportplanindexBydate(@PathVariable Integer id,@PathVariable String date){
		return healthPlanService.getsportplanindexBydate(id, date);
	}
	
	
}
