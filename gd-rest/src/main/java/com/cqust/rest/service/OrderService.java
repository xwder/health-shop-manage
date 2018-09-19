package com.cqust.rest.service;
import java.util.List;

import com.cqust.commom.pojo.OrderSelect;
import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;

public interface OrderService {
	
	/** 
	 * @Title: getTOrderItemById 
	 * @Description: 根据订单项id获取订单信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	GdResult getTOrderItemById(Integer id);
	
	/** 
	 * @Title: getStoreinfoById 
	 * @Description: 根据商家ID获取商家信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	GdResult getStoreinfoById(Integer id);
	
	/** 
	 * @Title: getOrderByid 
	 * @Description: 根据订单id获取订单信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	GdResult getOrderByid(Integer id);
	
	/** 
	 * @Title: updateOrderItemStatusById 
	 * @Description: 修改订单项状态，如果所有订单项状态一致改变，再修改订单状态
	 * @param orderitem
	 * @return      
	 * @throws 
	 */
	GdResult updateOrderItemStatus(TOrderitem orderitem);
	
	
	/** 
	 * @Title: listStoreOrderByOrderStatus 
	 * @Description: 根据商家ID查询不同状态的订单
	 * @param sid
	 * @param orderstatus
	 * @return      
	 * @throws 
	 */
	PageBean<TOrder> listStoreOrderByOrderStatus(Integer sid,Integer orderstatus,Integer page,Integer pagesize);
	
	/** 
	 * @Title: listStoreOrderByOrderStatus 
	 * @Description: 根据商家ID查询不同状态的订单
	 * @param sid
	 * @param orderstatus
	 * @return      
	 * @throws 
	 */
	PageBean<TOrder> listStoreOrderByOrderStatusAndDate(OrderSelect orderSelect);
	
	/** 
	 * @Title: listOrderItemsByOid 
	 * @Description: 根据订单号查询订单项
	 * @param oid
	 * @return      
	 * @throws 
	 */
	List<TOrderitem> listOrderItemsByOid(Integer oid);
}
