package com.cqust.shop.mapper;

import com.cqust.pojo.TOrder;

public interface OrderMapper {
	
	/** 
	 * @Title: createOrder 
	 * @Description: 创建订单并返回主键id 
	 * @param order
	 * @return      
	 * @throws 
	 */
	Integer createOrder(TOrder order);
}
