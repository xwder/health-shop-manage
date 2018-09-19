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
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.rest.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/{oid}")
	@ResponseBody
	public Object getOrderByid(@PathVariable Integer oid) {
		return orderService.getOrderByid(oid);
	}

	@RequestMapping("/store/{sid}")
	@ResponseBody
	public Object getStoreInfoByid(@PathVariable Integer sid) {
		return orderService.getStoreinfoById(sid);
	}

	@RequestMapping("/orderitem/{id}")
	@ResponseBody
	public Object getOrderItemByid(@PathVariable Integer id) {
		return orderService.getTOrderItemById(id);
	}

	@RequestMapping("/changeorderitemstatus")
	@ResponseBody
	public Object changeOrderItemStatus(@RequestBody String requestBody, HttpServletRequest request) {
		TOrderitem orderitem = null;
		try {
			orderitem = JsonUtils.jsonToPojo(requestBody, TOrderitem.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (orderitem == null) {
			return GdResult.build(500, "参数错误！");
		}
		orderService.updateOrderItemStatus(orderitem);
		return orderService.updateOrderItemStatus(orderitem);
	}

	@ResponseBody
	@RequestMapping("/listOrder/{sid}/{orderstatus}/{page}/{pagesize}")
	public PageBean<TOrder> listStoreOrderByOrderStatus(@PathVariable Integer sid, @PathVariable Integer orderstatus,
			@PathVariable Integer page, @PathVariable Integer pagesize) {

		return orderService.listStoreOrderByOrderStatus(sid, orderstatus, page, pagesize);
	}
	
	@ResponseBody
	@RequestMapping("/listOrder")
	public PageBean<TOrder> listStoreOrderByOrderStatusAndDate(@RequestBody String jsonStr) {
		
		
		
		//return orderService.listStoreOrderByOrderStatus(sid, orderstatus, page, pagesize);
		return null;
	}

	
	
	@ResponseBody
	@RequestMapping("/listOrderItems/{ord}")
	public List<TOrderitem> listOrderItems(@PathVariable Integer oid){
		return orderService.listOrderItemsByOid(oid);
	}
}
