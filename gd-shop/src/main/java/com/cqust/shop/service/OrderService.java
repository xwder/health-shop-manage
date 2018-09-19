package com.cqust.shop.service;

import java.util.List;

import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;

public interface OrderService {

	
	/** 
	 * @Title: addOrderItem 
	 * @Description: 添加购物项
	 * @param list
	 * @return      
	 * @throws 
	 */
	Integer addOrderItem(List<TOrderitem> list);
	
	/** 
	 * @Title: addOrder 
	 * @Description: 创建订单
	 * @param order
	 * @return      
	 * @throws 
	 */
	Integer addOrder(TOrder order);
	
	
	/** 
	 * @Title: getOrderById 
	 * @Description: 根据订单ID获取订单信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TOrder getOrderById(Integer id);
	
	/** 
	 * @Title: geTOrderitemListByOrderId 
	 * @Description: 根据订单ID获取订单项
	 * @param orderid
	 * @return      
	 * @throws 
	 */
	List<TOrderitem> getOrderitemListByOrderId(Integer orderid);
	
	/**
	* @Title: updateOrder
	* @Description: 更新订单状态
	* @param  @param id
	* @param  @param status
	* @param  @return    
	* @return Integer    
	* @throws
	*/
	public Integer updateOrder(Integer id, Integer status);
}
