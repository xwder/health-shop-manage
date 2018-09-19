package com.cqust.user.mapper;

import java.util.List;
import java.util.Map;

import com.cqust.pojo.TOrder;

public interface CustomOrderMapper {
	
 
	/** 
	 * @Title: getAllOrders 
	 * @Description: 获取所有的订单
	 * @param uid 用户ID
	 * @return      
	 * @throws 
	 */
	List<TOrder> getAllOrders(Integer uid);
	
	 
		/** 
		 * @Title: getAllOrders 
		 * @Description: 获取所有的订单
		 * @param uid 用户ID
		 * @return      
		 * @throws 
		 */
		List<TOrder> getAllWwcOrders(Integer uid);
	
	/** 
	 * @Title: getOrdersByOrderStates 
	 * @Description: 根据订单状态获取订单信息
	 * @param orderStates 订单状态
	 * @param uid 用户ID
	 * @return      
	 * @throws 
	 */
	List<TOrder> getOrdersByOrderStates(Map<String, Integer> map);
}
