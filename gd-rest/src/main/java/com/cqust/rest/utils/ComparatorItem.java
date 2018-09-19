package com.cqust.rest.utils;

import com.cqust.rest.pojo.CustomItem;

public class ComparatorItem implements java.util.Comparator<CustomItem> {

	@Override
	public int compare(CustomItem o1, CustomItem o2) {
		int flag = 0;
		flag = o1.getPcount().compareTo(o2.getPcount());
		return flag;
	}

}
