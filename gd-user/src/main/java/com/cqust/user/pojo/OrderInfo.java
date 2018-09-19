package com.cqust.user.pojo;

import java.util.ArrayList;
import java.util.List;

import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;

public class OrderInfo {
	private List<TOrderitem> orderitemList = new ArrayList<>();
	private TOrder order;

	public List<TOrderitem> getOrderitemList() {
		return orderitemList;
	}

	public void setOrderitemList(List<TOrderitem> orderitemList) {
		this.orderitemList = orderitemList;
	}

	public TOrder getOrder() {
		return order;
	}

	public void setOrder(TOrder order) {
		this.order = order;
	}

}
