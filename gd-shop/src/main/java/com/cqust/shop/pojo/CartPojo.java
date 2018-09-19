package com.cqust.shop.pojo;

import java.util.List;

import com.cqust.pojo.TCartitem;
import com.cqust.pojo.TStoreinfo;

public class CartPojo {
	public TStoreinfo storeinfo;
	public List<TCartitem> tCartitemList;

	public TStoreinfo getStoreinfo() {
		return storeinfo;
	}

	public void setStoreinfo(TStoreinfo storeinfo) {
		this.storeinfo = storeinfo;
	}

	public List<TCartitem> gettCartitemList() {
		return tCartitemList;
	}

	public void settCartitemList(List<TCartitem> tCartitemList) {
		this.tCartitemList = tCartitemList;
	}

	@Override
	public String toString() {
		return "CartPojo [storeinfo=" + storeinfo + ", tCartitemList=" + tCartitemList.toString() + "]";
	}

}
