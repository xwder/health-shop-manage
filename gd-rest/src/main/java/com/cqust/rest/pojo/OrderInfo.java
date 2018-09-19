package com.cqust.rest.pojo;

import java.util.ArrayList;
import java.util.List;

import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;

public class OrderInfo {
	
	private TOrder order;
	private List<TOrderitem> lsit = new ArrayList<>();

	public TOrder getOrder() {
		return order;
	}

	public void setOrder(TOrder order) {
		this.order = order;
	}

	public List<TOrderitem> getLsit() {
		return lsit;
	}

	public void setLsit(List<TOrderitem> lsit) {
		this.lsit = lsit;
	}

}
