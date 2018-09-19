package com.cqust.mshop.util;

import java.util.ArrayList;
import java.util.List;

import com.cqust.mshop.pojo.CustomOrderItem;
import com.cqust.mshop.pojo.OrderStatus;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;

public class OrderUtils {

	public static final String ORDER_PENDING = "待处理";
	public static final String ORDER_REFUSE = "拒接单";
	public static final String ORDER_ACCEPT = "接单配送中";
	public static final String ORDER_DISTRIBUTION = "已收货";
	public static final String ORDER_COMPLETE = "交易完成";

	public static List<OrderStatus> orderStatusConverter(List<TOrder> list) {
		if (list != null & list.size() > 0) {
			List<OrderStatus> orderStatusList = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				OrderStatus orderStatus = new OrderStatus();
				TOrder order = list.get(i);
				orderStatus.setId(order.getId());
				orderStatus.setTotal(order.getTotal());
				orderStatus.setIntOrderstates(order.getOrderstates());
				orderStatus.setOrdertime(order.getOrdertime());
				orderStatus.setUsername(order.getUsername());
				orderStatus.setUserphone(order.getUserphone());
				orderStatus.setUseraddr(order.getUseraddr());
				orderStatus.setUserid(order.getUserid());
				orderStatus.setStoreid(order.getUserid());
				orderStatus.setMessage(order.getMessage());
				orderStatus.setDelstatus(order.getDelstatus());
				orderStatus.setOrdercomment(order.getOrdercomment());
				orderStatusList.add(orderStatus);
				switch (order.getOrderstates()) {
				case 1: {
					orderStatus.setOrderstates(OrderUtils.ORDER_PENDING);
					break;
				}
				case 2: {
					orderStatus.setOrderstates(OrderUtils.ORDER_REFUSE);
					break;
				}
				case 3: {
					orderStatus.setOrderstates(OrderUtils.ORDER_ACCEPT);
					break;
				}
				case 4: {
					orderStatus.setOrderstates(OrderUtils.ORDER_DISTRIBUTION);
					break;
				}
				case 5: {
					orderStatus.setOrderstates(OrderUtils.ORDER_COMPLETE);
					break;
				}

				default: {
					return null;
				}
				}
			}
			return orderStatusList;
		}
		return null;
	}

	public static List<CustomOrderItem> orderItemConverter(List<TOrderitem> list) {
		List<CustomOrderItem> orderItems = new ArrayList<>();
		if (list != null & list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				CustomOrderItem orderItem = new CustomOrderItem();
				TOrderitem tOrderitem = list.get(i);
				orderItem.setId(tOrderitem.getId());
				orderItem.setPname(tOrderitem.getPname());
				orderItem.setPpic(tOrderitem.getPpic());
				orderItem.setPprice(tOrderitem.getPprice());
				orderItem.setCount(tOrderitem.getCount());
				orderItem.setSubtotal(tOrderitem.getSubtotal());
				orderItem.setOrderid(tOrderitem.getOrderid());
				orderItem.setUid(tOrderitem.getUid());
				orderItem.setSid(tOrderitem.getSid());
				orderItem.setStatus(tOrderitem.getStatus());
				switch (tOrderitem.getStatus()) {
				case 1: {
					orderItem.setStrStatus(OrderUtils.ORDER_PENDING);
					break;
				}
				case 2: {
					orderItem.setStrStatus(OrderUtils.ORDER_REFUSE);
					break;
				}
				case 3: {
					orderItem.setStrStatus(OrderUtils.ORDER_PENDING);
					break;
				}
				case 4: {
					orderItem.setStrStatus(OrderUtils.ORDER_DISTRIBUTION);
					break;
				}
				case 5: {
					orderItem.setStrStatus(OrderUtils.ORDER_COMPLETE);
					break;
				}

				default: {
					return null;
				}
				}
				orderItems.add(orderItem);
			}
			return orderItems;
		}
		return null;
	}
}
