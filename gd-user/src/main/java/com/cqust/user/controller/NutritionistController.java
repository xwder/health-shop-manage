package com.cqust.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.DateUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TSportplan;
import com.cqust.pojo.TUncomment;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipdietapplication;
import com.cqust.user.service.NutritionistService;

@Controller
@RequestMapping("/nutritionist")
public class NutritionistController {
	@Autowired
	NutritionistService nutritionistService;
    
	/**
	 * 页面跳转
	 * @Title: showPage 
	 * @Description: TODO
	 * @param url
	 * @return      
	 * @throws
	 */
	@RequestMapping("/nutritionist/{url}")
	public String showPage(@PathVariable String url) {
		return url;
	}

	/**
	 * 获取所有营养师信息 @Title: getallnutritionist @Description: TODO @return @throws
	 */
	@RequestMapping("/getallnutritionist")
	@ResponseBody
	public List<TUserinfo> getallnutritionist() {
		return nutritionistService.getallnutritionist();
	}

	/**
	 * 获取会员专属营养师 @Title: getmynutritionist @Description: TODO @param
	 * id @return @throws
	 */
	@RequestMapping("/getmynutritionist/{id}")
	@ResponseBody
	public List<TUserinfo> getmynutritionist(@PathVariable Integer id) {
		List<TUserinfo> tUserinfos = new ArrayList<TUserinfo>();
		tUserinfos.add(nutritionistService.getmynutritionist(id));
		return tUserinfos;
	}

	/**
	 * 会员选择营养师 @Title: selectnutritionist @Description: TODO @return @throws
	 */
	@RequestMapping("/selectnutritionist")
	@ResponseBody
	public GdResult selectnutritionist(HttpServletRequest httpServletRequest) {       
		TUserinfo userinfo = (TUserinfo) httpServletRequest.getSession().getAttribute("userinfo");
		if(userinfo.getIsVip()!=1)
			return GdResult.build(200, "对不起,您不是高级会员，不能选择营养师!");
		TVipdietapplication tVipdietapplication = new TVipdietapplication();
		tVipdietapplication.setUserid(Integer.parseInt(httpServletRequest.getParameter("userId")));
		tVipdietapplication.setUsername(httpServletRequest.getParameter("userName"));
		try {
			tVipdietapplication.setSqdate(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("sqDate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tVipdietapplication.setSqstatus(Integer.parseInt(httpServletRequest.getParameter("sqStatus")));
		tVipdietapplication.setDietitianid(Integer.parseInt(httpServletRequest.getParameter("dietitianId")));
		return nutritionistService.selectnutritionist(tVipdietapplication);
	}

	/**
	 * 保存会员留言 @Title: comment @Description: TODO @param
	 * httpServletRequest @return @throws
	 */
	@RequestMapping("/comment")
	@ResponseBody
	public GdResult comment(HttpServletRequest httpServletRequest) {
		TUncomment tUncomment = new TUncomment();
		tUncomment.setNid(Integer.parseInt(httpServletRequest.getParameter("nid")));
		tUncomment.setUid(Integer.parseInt(httpServletRequest.getParameter("uid")));
		tUncomment.setCommentcontent(httpServletRequest.getParameter("commentcontent"));
		tUncomment.setIsreply(0);
		try {
			tUncomment.setCommenttime(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("commenttime")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return nutritionistService.savecomment(tUncomment);
	}

	/**
	 * 获取会员留言记录 @Title: getcommentrecord @Description: TODO @return @throws
	 */
	@RequestMapping("/getcommentrecord/{id}")
	@ResponseBody
	public List<TUncomment> getcommentrecord(@PathVariable Integer id) {
        return nutritionistService.getcommentrecord(id);
	}
    
	/**
	 * 获取每一条留言记录
	 * @Title: getsinglecomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsinglecomment/{id}")
	@ResponseBody
	public TUncomment getsinglecomment(@PathVariable Integer id) {
        return nutritionistService.getsinglecomment(id);
	}
	
	/**
	 * 获取消息提醒
	 * @Title: messageremind 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
    @RequestMapping("/messageremind/{id}")
	@ResponseBody
	public List<TMessageremind> messageremind(@PathVariable Integer id){
		return nutritionistService.messageremind(id);
	}
    
    /**
	 * 获得饮食计划索引（营养师制定的饮食计划）
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getdietplanindex/{id}")
	@ResponseBody
	public List<TPlanindex> getdietplanindex(@PathVariable Integer id){
		return nutritionistService.getdietplanindex(id);
	}
    
	/**
	 * 获得运动计划索引（营养师制定的运动计划）
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsportplanindex/{id}")
	@ResponseBody
	public List<TPlanindex> getsportplanindex(@PathVariable Integer id){
		return nutritionistService.getsportplanindex(id);
	}
    
	/**
	 * 根据饮食计划索引获取每一天的饮食计划（营养师制定的饮食计划）
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
			return nutritionistService.geteverydaydietplan(uid, nid, planid, date);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据运动计划索引获取每一天的运动计划（营养师制定的运动计划）
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
			return nutritionistService.geteverydaysportplan(uid, nid, planid, date);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		return null;
	}
    
}
