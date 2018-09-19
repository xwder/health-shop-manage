package com.cqust.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TPbrowserecord;
import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.pojo.TZxbrowserecord;
import com.cqust.rest.service.PBrowseService;
import com.cqust.rest.service.PotalBrowseService;
import com.cqust.rest.service.ZxBrowseService;

@Controller
@RequestMapping("/browserecord")
public class BrowseRecordController {
	
	@Autowired
	private PBrowseService pBrowseService;
	
	@Autowired
	private ZxBrowseService zxBrowseService;
	
	@Autowired
	private PotalBrowseService potalBrowseService;
	
	@RequestMapping(value="/addItemBrowseRecord")
	@ResponseBody
	public GdResult addItemBrowseRecord(@RequestBody String jsonBrowseRecord){
		TPbrowserecord pbrowserecord = null;
		try {
			pbrowserecord  = JsonUtils.jsonToPojo(jsonBrowseRecord, TPbrowserecord.class);
		} catch (Exception e) {
			return GdResult.build(400, "参数错误");
		}
		Integer result = pBrowseService.addPBrowseRecord(pbrowserecord);
		if(result != null && result == 1){
			return GdResult.ok();
		}else{
			GdResult.build(500, "添加失败！");
		}
		return null;
	}
	
	@RequestMapping(value="/addZxBrowseRecord")
	@ResponseBody
	public GdResult addZxBrowseRecord(@RequestBody String jsonBrowseRecord){
		TZxbrowserecord zxbrowserecord = null;
		try {
			zxbrowserecord  = JsonUtils.jsonToPojo(jsonBrowseRecord, TZxbrowserecord.class);
		} catch (Exception e) {
			return GdResult.build(400, "参数错误");
		}
		Integer result = zxBrowseService.addZxBrowseRecord(zxbrowserecord);
		if(result != null && result == 1){
			return GdResult.ok();
		}else{
			GdResult.build(500, "添加失败！");
		}
		return null;
	}
	
	@RequestMapping(value="/addPotalBrowseRecord")
	@ResponseBody
	public GdResult addPotalBrowseRecord(@RequestBody String jsonBrowseRecord){
		TPotalbrowserecord tPotalbrowserecord = null;
		try {
			tPotalbrowserecord  = JsonUtils.jsonToPojo(jsonBrowseRecord, TPotalbrowserecord.class);
		} catch (Exception e) {
			return GdResult.build(400, "参数错误");
		}
		Integer result = potalBrowseService.addPotalBrowse(tPotalbrowserecord);
		if(result != null && result == 1){
			return GdResult.ok();
		}else{
			GdResult.build(500, "添加失败！");
		}
		return null;
	}
}
