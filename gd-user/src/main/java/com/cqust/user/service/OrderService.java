package com.cqust.user.service;
import java.util.List;

import com.cqust.commom.pojo.PageBean;
import com.cqust.pojo.TOrderitem;
import com.cqust.user.pojo.OrderInfo;

public interface OrderService {
	
	/** 
	 * @Title: getAllOrders 
	 * @Description: 获取所有的订单信息
	 * @param pageNum 页码
	 * @param pageSize 每一页订单数量
	 * @param orderType 订单类型
	 * @param uid 用户ID
	 * @return      
	 * @throws 
	 */
	PageBean<OrderInfo> getAllOrders(Integer pageNum,Integer pageSize,Integer orderStates,Integer uid);
	
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
	
	/** 
	 * @Title: geTOrderitemListByOrderId 
	 * @Description: 根据订单ID获取订单项
	 * @param orderid
	 * @return      
	 * @throws 
	 */
	List<TOrderitem> getOrderitemListByOrderId(Integer orderid);
	
	/**
	* @Title: getallWwcOrderList
	* @Description: TODO
	* @param  @param uid
	* @param  @return    
	* @return List<TOrderitem>    
	* @throws
	*/
	PageBean<OrderInfo> getallWwcOrderList(Integer uid,Integer page,Integer pagesize);
	
	
}