package com.cqust.user.service;

import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TStoreinfo;

public interface CommentService {
	
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
	 * @Title: updateOrderItemStatusById 
	 * @Description: 修改订单项状态，如果所有订单项状态一致改变，再修改订单状态
	 * @param orderitem
	 * @return      
	 * @throws 
	 */
	Integer updateOrderItemStatusById(TOrderitem orderitem);
	
	
	/** 
	 * @Title: addPComment 
	 * @Description: 添加商品评论
	 * @param pcomment
	 * @return      
	 * @throws 
	 */
	Integer addPComment(TPcomment pcomment);
	
	/** 
	 * @Title: geTPcommentByPid 
	 * @Description: 根据订单项ID获取该订单项的商品评论
	 * @param id
	 * @return      
	 * @throws 
	 */
	TPcomment geTPcommentByOrderItemId(Integer id);
	
}
