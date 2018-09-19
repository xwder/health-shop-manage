package com.cqust.mshop.service;

import java.util.Date;
import java.util.List;

import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TStoreinfo;

public interface OrderService {

	List<TOrder> ordersBySid(Integer sid,Integer status);
	
	List<TOrderitem> orderItemsByOid(Integer oid);
	
	Integer updateOrder(Integer id,Integer status);
	
	
	/** 
	 * @Title: getTOrderItemById 
	 * @Description: 根据订单项id获取订单信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TOrderitem getTOrderItemById(Integer id);
	
	/** 
	 * @Title: getStoreinfoById 
	 * @Description: 根据商家ID获取商家信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TStoreinfo getStoreinfoById(Integer id);
	
	/** 
	 * @Title: getOrderByid 
	 * @Description: 根据订单id获取订单信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	TOrder getOrderByid(Integer id);
	
 
	/** 
	 * @Title: geTPcommentByPid 
	 * @Description: 根据订单项ID获取该订单项的商品评论
	 * @param id
	 * @return      
	 * @throws 
	 */
	TPcomment geTPcommentByOrderItemId(Integer id);
	
	/** 
	 * @Title: getOrdersBettwon 
	 * @Description: 查询时间段订单
	 * @param beginDate
	 * @param endDate
	 * @return      
	 * @throws 
	 */
	List<TOrder> getOrdersBettwon(Integer status,Date beginDate,Date endDate);
	
	/**
	* @Title: updateOrderStatus
	* @Description: 更新订单状态
	* @param  @param sid
	* @param  @return    
	* @return Integer    
	* @throws
	*/
	Integer updateOrderStatus(Integer sid);
	
}
