package com.cqust.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqust.pojo.TProduct;
import com.cqust.rest.pojo.CustomItem;

public interface ItemMapper {
	
	/** 
	 * @Title: getHotItemList 
	 * @Description: 获取首页热门商品
	 * @return      热门商品列表
	 * @throws 
	 */
	List<TProduct> getHotItemList();
	
	
	/** 
	 * @Title: getHotItemListByType 
	 * @Description: 获取热门商品根据商品类型
	 * @param itemType	商品类型
	 * @return      
	 * @throws 
	 */
	List<TProduct> getHotItemListByType(String itemType);
	
	/**
	* @Title: beatSellersItems
	* @Description: 热卖商品
	* @param  @return    
	* @return List<TProduct>    
	* @throws
	*/
	List<TProduct> bestSellersItems();
	
	
	/**
	* @Title: newestItems
	* @Description: 最新商品
	* @param  @return    
	* @return List<TProduct>    
	* @throws
	*/
	List<TProduct> newestItems();
	
	/**
	* @Title: commentItems
	* @Description: 热评商品
	* @param  @return    
	* @return List<TProduct>    
	* @throws
	*/
	List<CustomItem> commentItems();
	
	/**
	* @Title: panicBuyItems
	* @Description: 疯狂抢购商品
	* @param  @return    
	* @return List<CustomItem>    
	* @throws
	*/
	List<CustomItem> panicBuyItems();
	
	/**
	* @Title: userlikeItems
	* @Description: 猜您新欢商品
	* @param  @return    
	* @return List<CustomItem>    
	* @throws
	*/
	List<CustomItem> userlikeItems(@Param("uid")Integer uid);
}
