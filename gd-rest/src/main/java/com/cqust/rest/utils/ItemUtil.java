package com.cqust.rest.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cqust.rest.pojo.CustomItem;

public class ItemUtil {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<CustomItem> sort(List<CustomItem> customItems) {
		Collections.sort(customItems, new Comparator() {
			public int compare(Object a, Object b) {
				int one = ((CustomItem) a).getPcount();
				int two = ((CustomItem) b).getPcount();
				return one - two;
			}
		});
		return customItems;
	}
}
