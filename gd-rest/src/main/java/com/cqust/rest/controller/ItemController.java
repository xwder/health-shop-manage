package com.cqust.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.pojo.ItemType;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TProduct;
import com.cqust.rest.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/hotItem")
	@ResponseBody
	public GdResult getHotItemList(){
		try {
			List<TProduct> list = itemService.getHotItemList();
			if(list != null && list.size() >= 0){
				return GdResult.ok(list);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return GdResult.build(400, "服务器异常！");
		}
		return GdResult.build(400, "未查到商品信息！");
	}
	
	@RequestMapping(value="/hotItemByType/{type}")
	@ResponseBody
	public GdResult getHotItemListByType(@PathVariable String type){
		String t = null;
		if(type.equals("VEGETABLES")){
			t = ItemType.VEGETABLES;
		}else if(type.equals("FRUITS")){
			t = ItemType.FRUITS;
		}else if(type.equals("MEAT")){
			t = ItemType.MEAT;
		}else if(type.equals("COOKERFOOD")){
			t = ItemType.COOKERFOOD;
		}else if(type.equals("GRAIN")){
			t = ItemType.GRAIN;
		}else{
			return GdResult.build(400, "商品类型错误！");
		}
		
		try {
			List<TProduct> list = itemService.getHotItemListByType(t);
			if(list != null && list.size() >= 0){
				return GdResult.ok(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return GdResult.build(400, "服务器异常！");
		}
		return GdResult.build(400, "未查到商品信息！");
	}
	
	
	@RequestMapping("/bestselleritems")
	@ResponseBody
	public List<TProduct> bestselleritems(HttpServletRequest request){
		List<TProduct> list = itemService.bestSellersItems();
		return list;
	}
	@RequestMapping("/newestitems")
	@ResponseBody
	public List<TProduct> newestItems(HttpServletRequest request){
		List<TProduct> list = itemService.newestItems();
		return list;
	}
	@RequestMapping("/commentitems")
	@ResponseBody
	public List<TProduct> commentItems(HttpServletRequest request){
		List<TProduct> list = itemService.commentItems();
		return list;
	}
	@RequestMapping("/panicbuyitems")
	@ResponseBody
	public List<TProduct> panicBuyItems(HttpServletRequest request){
		List<TProduct> list = itemService.panicBuyItems();
		return list;
	}
	@RequestMapping("/userlikeitems/{uid}")
	@ResponseBody
	public List<TProduct> userlikeItems(@PathVariable Integer uid,HttpServletRequest request){
		List<TProduct> list = itemService.userlikeItems(uid);
		return list;
	}

}
