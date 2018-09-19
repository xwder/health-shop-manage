package com.cqust.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.manager.service.StatisticsService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping("/statisticspage")
	public ModelAndView statisticspage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/statistics/statisticspage");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/orderstatistics/{datenum}")
	public List<Double> orderstatistics(@PathVariable Integer datenum,HttpServletRequest request){
		List<Double> list = statisticsService.orderStatistics(datenum);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping("/zixunstatistics/{datenum}")
	public List<Integer> zixunstatistics(@PathVariable Integer datenum,HttpServletRequest request){
		List<Integer> list = statisticsService.zixunStatistics(datenum);
		return list;
	}
	 
	@ResponseBody
	@RequestMapping("/potalstatistics/{datenum}")
	public List<Integer> potalstatistics(@PathVariable Integer datenum,HttpServletRequest request){
		List<Integer> list = statisticsService.potalStatistics(datenum);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/itemstatistics/{datenum}")
	public List<Integer> itemstatistics(@PathVariable Integer datenum,HttpServletRequest request){
		List<Integer> list = statisticsService.pbrowseStatistics(datenum);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/userlogstatistics/{datenum}")
	public List<Integer> userlogstatistics(@PathVariable Integer datenum,HttpServletRequest request){
		List<Integer> list = statisticsService.userloginStatistics(datenum);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/searchstatistics/{datenum}")
	public List<Integer> searchstatistics(@PathVariable Integer datenum,HttpServletRequest request){
		List<Integer> list = statisticsService.searchStatistics(datenum);
		return list;
	}
}
