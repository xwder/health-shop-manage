package com.cqust.shop.mapper;

import com.cqust.pojo.TCart;

public interface CartMapper {
	
	
	/** 
	 * @Title: createCart 
	 * @Description: 创建购物车
	 * @param id 用ID
	 * @return  购物车主键id
	 * @throws 
	 */
	Integer createCart(TCart cart);
}
