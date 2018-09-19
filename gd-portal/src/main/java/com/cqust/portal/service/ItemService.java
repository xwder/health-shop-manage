package com.cqust.portal.service;

import java.util.List;

import com.cqust.pojo.TProduct;

public interface ItemService {

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
	List<TProduct> commentItems();
	
	/**
	* @Title: panicBuyItems
	* @Description: 疯狂抢购商品
	* @param  @return    
	* @return List<CustomItem>    
	* @throws
	*/
	List<TProduct> panicBuyItems();
	
	/**
	* @Title: userlikeItems
	* @Description: 猜您新欢商品
	* @param  @return    
	* @return List<CustomItem>    
	* @throws
	*/
	List<TProduct> userlikeItems(Integer uid);
}
