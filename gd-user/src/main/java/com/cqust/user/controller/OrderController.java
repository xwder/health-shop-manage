package com.cqust.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.PageBean;
import com.cqust.pojo.TUserinfo;
import com.cqust.user.pojo.OrderInfo;
import com.cqust.user.service.OrderService;
import com.cqust.user.util.RequestSessionUtil;

@Controller
@RequestMapping("/user")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order")
	public ModelAndView myOrder(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		
			//所有订单
			RequestSessionUtil.setAttributeFromSession(request, "orderStates", 0);
			PageBean<OrderInfo> allOrderPageBean = orderService.getAllOrders(1, 6, 0,userinfo.getId());
			RequestSessionUtil.setAttributeFromSession(request, "allOrderPageBean",allOrderPageBean);
			//待商家接单
			PageBean<OrderInfo> waitOrderPageBean = orderService.getAllOrders(1, 6, 1,userinfo.getId());
			RequestSessionUtil.setAttributeFromSession(request, "waitOrderPageBean",waitOrderPageBean);
			//商家拒接接单
			PageBean<OrderInfo> refuseOrderPageBean = orderService.getAllOrders(1, 6, 2,userinfo.getId());
			RequestSessionUtil.setAttributeFromSession(request, "refuseOrderPageBean",refuseOrderPageBean);
			//商家接单待配送
			PageBean<OrderInfo> dispatchingOrderPageBean = orderService.getAllOrders(1, 6, 3,userinfo.getId());
			RequestSessionUtil.setAttributeFromSession(request, "dispatchingOrderPageBean",dispatchingOrderPageBean);
			//已收货待评价
			PageBean<OrderInfo> receiptPageBean = orderService.getAllOrders(1, 6, 4,userinfo.getId());
			RequestSessionUtil.setAttributeFromSession(request, "receiptPageBean",receiptPageBean);
			//交易完成
			PageBean<OrderInfo> completePageBean = orderService.getAllOrders(1, 6, 5,userinfo.getId());
			RequestSessionUtil.setAttributeFromSession(request, "completePageBean",completePageBean);
		
		//订单状态
		String strOrderStates = request.getParameter("orderStates");
		String strPage = request.getParameter("page");
		Integer page = 1;
		Integer orderStates = 0;
		if(strOrderStates != null && strPage != null && !StringUtils.isBlank(strOrderStates) && !StringUtils.isBlank(strPage)){
			try {
				  page = Integer.parseInt(strPage);
				  orderStates = Integer.parseInt(strOrderStates);
			} catch (Exception e) {
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg","查询失败！");
				return modelAndView;
			}
			RequestSessionUtil.setAttributeFromSession(request, "orderStates", orderStates);
			switch (orderStates) {
			case  0:
					{
						//所有订单
						allOrderPageBean = orderService.getAllOrders(page, 6, 0,userinfo.getId());
						RequestSessionUtil.setAttributeFromSession(request, "allOrderPageBean",allOrderPageBean);
					}
				break;
			case  1:
					{
						//待商家接单
						waitOrderPageBean = orderService.getAllOrders(page, 6, 1,userinfo.getId());
						RequestSessionUtil.setAttributeFromSession(request, "waitOrderPageBean",waitOrderPageBean);
					}
				break;
			case  2:
					{
						//商家拒接接单
						refuseOrderPageBean = orderService.getAllOrders(page, 6, 2,userinfo.getId());
						RequestSessionUtil.setAttributeFromSession(request, "refuseOrderPageBean",refuseOrderPageBean);
					}
				break;
			case  3:
					{
						//商家接单待配送
						dispatchingOrderPageBean = orderService.getAllOrders(page, 6, 3,userinfo.getId());
						RequestSessionUtil.setAttributeFromSession(request, "dispatchingOrderPageBean",dispatchingOrderPageBean);
					}
				break;
			case  4:
					{
						//已收货待评价
						receiptPageBean = orderService.getAllOrders(page, 6, 4,userinfo.getId());
						RequestSessionUtil.setAttributeFromSession(request, "receiptPageBean",receiptPageBean);
					}
				break;
			case  5:
					{
						//交易完成
						completePageBean = orderService.getAllOrders(page, 6, 5,userinfo.getId());
						RequestSessionUtil.setAttributeFromSession(request, "completePageBean",completePageBean);
					}
				break;
				

			default:
				break;
			}
		}
		
		modelAndView.setViewName("/order");
		return modelAndView;
	}
	
	@RequestMapping("/updateorderstatus/{oid}/{status}")
	public ModelAndView updateOrderStatus(@PathVariable Integer oid,@PathVariable Integer status,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		Integer result = orderService.updateOrder(oid, status);
		if(result == 1){
			modelAndView.setViewName("redirect:/user/order");
		}else{
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}
}
