package com.cqust.mshop.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.GdResult;
import com.cqust.mshop.pojo.CustomOrderItem;
import com.cqust.mshop.pojo.OrderStatus;
import com.cqust.mshop.service.OrderService;
import com.cqust.mshop.service.UserService;
import com.cqust.mshop.util.OrderUtils;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;

@Controller
@RequestMapping("/manager")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@RequestMapping("/getorderlist/{status}")
	@ResponseBody
	public Object getorderlistBystatus(@PathVariable Integer status, HttpServletRequest request) {
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		List<TOrder> list = orderService.ordersBySid(storeinfo.getId(), status);
		List<OrderStatus> orderStatusList = OrderUtils.orderStatusConverter(list);
		return orderStatusList;
	}

	@RequestMapping("/order/orderlist/{status}")
	public ModelAndView orderlist(@PathVariable Integer status) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("status", status);
		modelAndView.setViewName("/orderlist");
		return modelAndView;
	}

	@RequestMapping("/order/orderitem/{id}/{status}")
	public ModelAndView orderitempage(@PathVariable Integer id, @PathVariable Integer status) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("oid", id);
		modelAndView.addObject("status", status);
		modelAndView.setViewName("/orderitem");
		return modelAndView;
	}

	@RequestMapping("/getorderitemsbyoid/{id}")
	@ResponseBody
	public Object getorderitemsbypid(@PathVariable Integer id, HttpServletRequest request) {
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		List<TOrderitem> orderitems = orderService.orderItemsByOid(id);
		List<CustomOrderItem> list = OrderUtils.orderItemConverter(orderitems);
		if (list != null & list.size() > 0) {
			if (list.get(0).getSid() != storeinfo.getId()) {
				return null;
			}
		}
		return list;
	}

	@ResponseBody
	@RequestMapping("/order/refuseorder/{id}")
	public GdResult refuseOrder(@PathVariable Integer id) {
		Integer r = orderService.updateOrder(id, 2);
		if (r == 1) {
			return GdResult.ok();
		}
		return GdResult.build(500, "修改失败！");
	}

	@ResponseBody
	@RequestMapping("/order/acceptorder/{id}")
	public GdResult acceptOrder(@PathVariable Integer id) {
		Integer r = orderService.updateOrder(id, 3);
		if (r == 1) {
			return GdResult.ok();
		}
		return GdResult.build(500, "修改失败！");
	}

	@ResponseBody
	@RequestMapping("/order/fahuoorder/{id}")
	public GdResult fahuoorder(@PathVariable Integer id) {
		Integer r = orderService.updateOrder(id, 3);
		if (r == 1) {
			return GdResult.ok();
		}
		return GdResult.build(500, "修改失败！");
	}

	@RequestMapping("/order/comment/{orderitemid}/{orderid}")
	public ModelAndView getComment(@PathVariable Integer orderitemid, @PathVariable Integer orderid) {
		ModelAndView modelAndView = new ModelAndView();
		TOrderitem orderitem = orderService.getTOrderItemById(orderitemid);
		TOrder order = null;
		TStoreinfo storeinfo = null;
		if (orderitem != null) {
			order = orderService.getOrderByid(orderid);
			modelAndView.addObject("order", order);
			TPcomment pcomment = orderService.geTPcommentByOrderItemId(orderitemid);
			modelAndView.addObject("comment", pcomment);
			TUserinfo commentUser = userService.getUserinfoByid(pcomment.getUserid());
			modelAndView.addObject("commentUser", commentUser);

		}
		if (order != null) {
			storeinfo = orderService.getStoreinfoById(order.getStoreid());
			if (storeinfo != null) {
				modelAndView.addObject("storeinfo", storeinfo);
			}
		}
		modelAndView.addObject("item", orderitem);
		modelAndView.setViewName("/content/itemcomment");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/order/searchwithtime")
	public List<OrderStatus> searchwithtime(HttpServletRequest request) {
		String  strStatus = request.getParameter("status");
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		try {
			Date bDate =  sdf.parse(begintime); 
			Date eDate =   sdf.parse(endtime); 
			
			Integer status = Integer.parseInt(strStatus);
			if(bDate != null & eDate != null){
				List<TOrder> list = orderService.getOrdersBettwon(status, bDate, eDate);
				List<OrderStatus> orderStatusList = OrderUtils.orderStatusConverter(list);
				return orderStatusList;
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@ResponseBody
	@RequestMapping("/order/getorderbyoid/{orderid}")
	List<OrderStatus> getorderbyoid(@PathVariable Integer orderid){
		TOrder order = orderService.getOrderByid(orderid);
		List<TOrder> list = new ArrayList<>();
		list.add(order);
		List<OrderStatus> orderStatusList = OrderUtils.orderStatusConverter(list);
		return orderStatusList;
	}
	
}
