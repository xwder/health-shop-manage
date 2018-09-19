package com.cqust.mshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.mshop.service.StatisticsService;
import com.cqust.pojo.TStoreinfo;

@RequestMapping("/manager")
@Controller
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping("/statistics/pbrowse/{datenum}")
	@ResponseBody
	public List<Integer> getPastSevenDayPbrose(@PathVariable Integer datenum,HttpServletRequest request){
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		List<Integer> list = statisticsService.pbrowseStatistics(storeinfo.getId(),datenum);
		return list;
	}
	
	@RequestMapping("/statistics/order/{datenum}")
	@ResponseBody
	public List<Double> getOrderStatistics(@PathVariable Integer datenum,HttpServletRequest request){
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		List<Double> list = statisticsService.orderStatistics(storeinfo.getId(),datenum);
		return list;
	}
	
	@RequestMapping("/statistics/main")
	public ModelAndView index(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/statistics/statistics");
		return modelAndView;
	}
}
