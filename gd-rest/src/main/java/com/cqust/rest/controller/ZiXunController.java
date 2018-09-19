package com.cqust.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TZxinfo;
import com.cqust.pojo.TZxtype;
import com.cqust.rest.pojo.ZiXunInfo;
import com.cqust.rest.service.ZiXunService;

@Controller
@RequestMapping("/zixun")
public class ZiXunController {

	@Autowired
	private ZiXunService ziXunService;

	@RequestMapping("/zxtypelist")
	@ResponseBody
	public List<TZxtype> getZxTypeList() {
		return ziXunService.zxTypeList();
	}

	@ResponseBody
	@RequestMapping("/zxinfos/{page}/{pagesize}")
	public List<ZiXunInfo> geTZxinfos(@PathVariable Integer page, @PathVariable Integer pagesize) {
		return ziXunService.zxinfoListByType(page, pagesize, null).getList();
	}
	
	@ResponseBody
	@RequestMapping("/zxinfos/{page}/{pagesize}/{zxtype}")
	public List<ZiXunInfo> geTZxinfosByZxType(@PathVariable Integer page, @PathVariable Integer pagesize,
			@PathVariable Integer zxtype) {
		return ziXunService.zxinfoListByType(page, pagesize, zxtype).getList();
	}
	
	
	@ResponseBody
	@RequestMapping("/pagebeanzxinfos/{page}/{pagesize}")
	public PageBean<ZiXunInfo> geTZxinfosPageBean(@PathVariable Integer page, @PathVariable Integer pagesize) {
		return ziXunService.zxinfoListByType(page, pagesize,null);
	}
	
	@ResponseBody
	@RequestMapping("/pagebeanzxinfos/{page}/{pagesize}/{zxtype}")
	public PageBean<ZiXunInfo> geTZxinfosByZxTypePageBean(@PathVariable Integer page, @PathVariable Integer pagesize,
			@PathVariable Integer zxtype) {
		return ziXunService.zxinfoListByType(page, pagesize,zxtype);
	}
	
	@ResponseBody
	@RequestMapping("/zxinfo/{page}/{pagesize}")
	public List<ZiXunInfo> getZxinfos(@PathVariable Integer page, @PathVariable Integer pagesize
			) {
		return ziXunService.zxinfosByType( page, pagesize,null).getList();
	}
	
	@ResponseBody
	@RequestMapping("/zxinfo/{page}/{pagesize}/{zxtype}")
	public List<ZiXunInfo> getZxinfosByZxType(@PathVariable Integer page, @PathVariable Integer pagesize,
			@PathVariable Integer zxtype) {
		return ziXunService.zxinfosByType( page, pagesize,zxtype).getList();
	}
	
	
	@ResponseBody
	@RequestMapping("/pagebeanzxinfo/{page}/{pagesize}")
	public PageBean<ZiXunInfo> getZxinfosPageBean(@PathVariable Integer page, @PathVariable Integer pagesize) {
		return ziXunService.zxinfosByType(page, pagesize,null);
	}
	
	@ResponseBody
	@RequestMapping("/pagebeanzxinfo/{page}/{pagesize}/{zxtype}")
	public PageBean<ZiXunInfo> getZxinfosByZxTypePageBean(@PathVariable Integer page, @PathVariable Integer pagesize,
			@PathVariable Integer zxtype) {
		return ziXunService.zxinfosByType( page, pagesize,zxtype);
	}
	
	@ResponseBody
	@RequestMapping("/zxinfo/{id}")
	public ZiXunInfo getZxinfoById(@PathVariable Integer id){
		return ziXunService.getZxinfoById(id);
	}
	
	@ResponseBody
	@RequestMapping("/addzxinfo")
	public GdResult addzxinfo(@RequestBody String requestBody, HttpServletRequest request){
		TZxinfo zxinfo = null;
		try {
			zxinfo = JsonUtils.jsonToPojo(requestBody, TZxinfo.class);
		} catch (Exception e) {
			return GdResult.build(400, "添加失败!");
		}
		if(zxinfo != null){
			Integer result = ziXunService.addZxinfo(zxinfo);
			if(result == 1){
				return GdResult.build(200, "添加成功!");
			}
		}
		return GdResult.build(400, "添加失败!");
	}
	
	@ResponseBody
	@RequestMapping("/updatezxinfo")
	public GdResult updatezxinfo(@RequestBody String requestBody, HttpServletRequest request){
		TZxinfo zxinfo = null;
		try {
			zxinfo = JsonUtils.jsonToPojo(requestBody, TZxinfo.class);
		} catch (Exception e) {
			return GdResult.build(400, "修改失败!");
		}
		if(zxinfo != null){
			Integer result = ziXunService.updateZiInfoById(zxinfo);
			if(result == 1){
				return GdResult.build(200, "修改成功!");
			}
		}
		return GdResult.build(400, "修改失败!");
	}
	
}
