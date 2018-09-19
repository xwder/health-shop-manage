package com.cqust.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.manager.pojo.ProductBrowseRecord;
import com.cqust.manager.service.RecordService;
import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.pojo.TSearchrecord;
import com.cqust.pojo.TUserlog;
import com.cqust.pojo.TZxbrowserecord;

@Controller
@RequestMapping("/record")
public class RecordController {
	@Autowired
	RecordService recordService;
	
	/**
	 * 获取用户登录记录
	 * @Title: getuserlogrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getuserlogrecord")
	@ResponseBody
	public List<TUserlog> getuserlogrecord(){
		return recordService.getuserlogrecord();
	}
	
	/**
	 * 获取商品浏览记录
	 * @Title: getproductrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getproductrecord")
	@ResponseBody
	public List<ProductBrowseRecord> getproductrecord(){
		return recordService.getproductrecord();
	}
    
	/**
	 * 获取搜索查找记录
	 * @Title: getsearchrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsearchrecord")
	@ResponseBody
	List<TSearchrecord> getsearchrecord(){
		return recordService.getsearchrecord();
	}
	
	/**
	 * 获取资讯浏览记录
	 * @Title: getzxrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getzxrecord")
	@ResponseBody
	List<TZxbrowserecord> getzxrecord(){
		return recordService.getzxrecord();
	}
	
	/**
	 * 获取首页访问记录
	 * @Title: getpotalbrowserecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getpotalbrowserecord")
	@ResponseBody
	List<TPotalbrowserecord> getpotalbrowserecord(){
		return recordService.getpotalbrowserecord();
	}
}
