package com.cqust.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TSearchrecord;
import com.cqust.rest.service.PSearchRecordService;

@Controller
@RequestMapping("/searchRecord")
public class PSearchRecordController {

	@Autowired
	private PSearchRecordService searchRecordService;
	
	@ResponseBody
	@RequestMapping("/addSearchRecord")
	public GdResult addSearchRecord(@RequestBody String jsonStrRecord){
		TSearchrecord searchrecord = null;
		try {
			searchrecord  = JsonUtils.jsonToPojo(jsonStrRecord, TSearchrecord.class);
		} catch (Exception e) {
			return GdResult.build(400, "参数错误");
		}
		Integer result = searchRecordService.addSearchRecord(searchrecord);
		if(result != null && result == 1){
			return GdResult.ok();
		}else{
			GdResult.build(500, "添加失败！");
		}
		return null;
	}
}
