package com.cqust.shop.service;

import java.util.List;

import com.cqust.pojo.TCart;
import com.cqust.pojo.TCartitem;

public interface CartService {

	/** 
	 * @Title: createCart 
	 * @Description: 创建购物车
	 * @param uid 用户ID
	 * @return   购物车
	 * @throws 
	 */
	TCart createCart(Integer uid);
	
	/** 
	 * @Title: getCartByUId 
	 * @Description: 根据用户ID查询用户购物车
	 * @param uid
	 * @return      
	 * @throws 
	 */
	TCart getCartByUId(Integer uid);
	
	/** 
	 * @Title: updateCartById 
	 * @Description: 根据购物车id更新购物车信息
	 * @param cart
	 * @return      
	 * @throws 
	 */
	Integer updateCartById(TCart cart);
	
	
	/** 
	 * @Title: addCartItem 
	 * @Description: 添加购物项
	 * @param cartItem
	 * @return      
	 * @throws 
	 */
	Integer addCartItem(TCartitem cartItem); 
	
	/** 
	 * @Title: geTCartitemList 
	 * @Description: 根据购车id获取购物项
	 * @param cartId
	 * @return      
	 * @throws 
	 */
	List<TCartitem> geTCartitemListByCartId(Integer cartId);
	
	/** 
	 * @Title: deleteCartItemById 
	 * @Description: 估计购物项的ID删除购物项
	 * @param id
	 * @return      
	 * @throws 
	 */
	Integer deleteCartItemById(Integer id);
	
 
	/** 
	 * @Title: subCartitemNumById 
	 * @Description: 更新购物项信息 添加
	 * @param cartitem
	 * @return      
	 * @throws 
	 */
	Integer updateCartItem(TCartitem cartitem);
 
	
}
