package com.cqust.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cqust.pojo.TProduct;
import com.cqust.shop.pojo.ItemInfo;

public interface MyItemMapper {
	
	
	List<ItemInfo> getItemList(Map<Object, Object> map);
	
	List<TProduct> getItemsBySellCount(@Param("sortType")String sortType,@Param("sid") Integer sid);
}
