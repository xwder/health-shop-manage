package com.cqust.mshop.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cqust.commom.utils.JsonUtils;
import com.cqust.mshop.pojo.ItemCollocationPojo;

public class ProductCollocationUtil {
	// {"code":200,"list":[9,21,3,6]}
	public static String productCollocation(String collocationStr) {
		String[] dirs = collocationStr.split(" ");
		if (dirs != null & dirs.length > 0) {
			List<String> list = new ArrayList<>();
			for(int i=0;i<dirs.length;i++){
				String value = dirs[i];
				if(StringUtils.isEmpty(value) | value == null){
					continue;
				}
				list.add(value);
			}
			ItemCollocationPojo itemCollocationPojo = new ItemCollocationPojo();
			itemCollocationPojo.setCode(200);
			itemCollocationPojo.setList(list);
			String result = JsonUtils.objectToJson(itemCollocationPojo);
			return result;
		}
		return null;
	}
	
}
