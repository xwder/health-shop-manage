package com.cqust.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.ExceptionUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.THotsearch;
import com.cqust.rest.service.HotSearchService;

@Controller
@RequestMapping("/hotsearch")
public class HotSearchController {
	@Autowired
	private HotSearchService hotSearchService;
	
	/** 
	 * @Title: getHealthInfo 
	 * @Description: 获取热搜词列表
	 * @return      热搜词列表
	 * @throws 
	 */
	@RequestMapping("/gethotsearch")
	@ResponseBody
	public GdResult getHotSearch() {
		try {
			List<THotsearch> list = hotSearchService.geTHotsearchs();
			return GdResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return GdResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
