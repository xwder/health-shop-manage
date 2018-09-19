package com.cqust.shop.service;

import java.util.List;
import java.util.Map;

import com.cqust.commom.pojo.PageBean;
import com.cqust.pojo.TProduct;
import com.cqust.shop.pojo.ItemInfo;

public interface ItemService {

	/** 
	 * @Title: getItemBaseInfo 
	 * @Description: 根据商品ID获取商品信息
	 * @param itemId
	 * @return      
	 * @throws 
	 */
	TProduct getItemBaseInfo(Integer itemId);
	
	/** 
	 * @Title: getItemList 
	 * @Description: TODO
	 * @param itemtype
	 * @param queryString
	 * @param page
	 * @param rows
	 * @return      
	 * @throws 
	 */
	PageBean<ItemInfo> getItemList(Map<Object, Object> map);
	
	/** 
	 * @Title: getItemCollocations 
	 * @Description: 更具商品ID获取推荐搭配商品
	 * @param pid	商品id
	 * @return      推荐商品列表
	 * @throws 
	 */
	List<TProduct> getItemCollocations(Integer itemId);
	
	/** 
	 * @Title: getItemsBySellCount 
	 * @Description: 根据销量顺序排序
	 * @param type
	 * @param sid
	 * @return      
	 * @throws 
	 */
	List<TProduct> getItemsBySellCount(String sortType,Integer sid);
}