package com.cqust.rest.mapper;

import java.util.List;
import java.util.Map;

import com.cqust.pojo.TOrder;

public interface CustomOrderMapper {

	List<TOrder> listStoreOrderByOrderStatus(Map<String, Integer> map);
	List<TOrder> listStoreOrderByOrderStatusAndDate(Map<String, Integer> map);
}
