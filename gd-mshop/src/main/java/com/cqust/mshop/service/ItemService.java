package com.cqust.mshop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cqust.mshop.pojo.CustomPbrowseRecord;
import com.cqust.pojo.TCategory;
import com.cqust.pojo.TItemcollocation;
import com.cqust.pojo.TProduct;

public interface ItemService {

	List<TProduct> getAllItem(Integer sid);

	List<TProduct> getItemByItemType(Integer itemType,Integer sid,HttpServletRequest request);
	
	/** 
	 * @Title: productSell 
	 * @Description: 商品上下架
	 * @param productid
	 * @param type
	 * @return      
	 * @throws 
	 */
	Integer productSell(Integer productid,Integer type);
	
	
	/** 
	 * @Title: addProduct 
	 * @Description: 添加商品
	 * @param product
	 * @return      
	 * @throws 
	 */
	Integer addProduct(TProduct product);
	
	
	/** 
	 * @Title: productCategoryList 
	 * @Description: 获取商品分类列表
	 * @return      
	 * @throws 
	 */
	List<TCategory> productCategoryList();
	
	/** 
	 * @Title: addProductCollocation 
	 * @Description: 添加搭配商品
	 * @param itemcollocation
	 * @return      
	 * @throws 
	 */
	Integer addProductCollocation(TItemcollocation itemcollocation);
	
	
	/** 
	 * @Title: updateProductCollocation 
	 * @Description: 修改搭配商品
	 * @param itemcollocation
	 * @return      
	 * @throws 
	 */
	Integer updateProductCollocation(TItemcollocation itemcollocation);
	
	/** 
	 * @Title: deleteProductCollolcationByPid 
	 * @Description: 删除搭配商品
	 * @param pid
	 * @return      
	 * @throws 
	 */
	Integer deleteProductCollolcationByPid(Integer pid);
	
	/** 
	 * @Title: itemcollocationByPid 
	 * @Description: 根据商品ID查询搭配商品
	 * @param pid
	 * @return      
	 * @throws 
	 */
	TItemcollocation itemcollocationByPid(Integer pid);
	
	/** 
	 * @Title: getItemCollocations 
	 * @Description: 更具商品ID获取推荐搭配商品
	 * @param pid	商品id
	 * @return      推荐商品列表
	 * @throws 
	 */
	List<TProduct> getItemCollocations(Integer itemId);
	
	
	/** 
	 * @Title: getProductByPid 
	 * @Description: 根据ID获取商品信息
	 * @param pid
	 * @return      
	 * @throws 
	 */
	TProduct getProductByPid(Integer pid);
	/** 
	 * @Title: updateProduct 
	 * @Description: 更新商品信息
	 * @param product
	 * @return      
	 * @throws 
	 */
	Integer updateProduct(TProduct product);
	/** 
	 * @Title: getItemcollocationByPid 
	 * @Description: 根据商品ID获取商品搭配信息
	 * @param pid
	 * @return      
	 * @throws 
	 */
	TItemcollocation getItemcollocationByPid(Integer pid);
	/** 
	 * @Title: updateItemCollocationByPid 
	 * @Description: 根据商品ID修改商品搭配信息
	 * @param itemcollocation
	 * @return      
	 * @throws 
	 */
	Integer updateItemCollocationByPid(TItemcollocation itemcollocation);

	/** 
	 * @Title: getItemListByStatus 
	 * @Description: 根据商品上下架状态获取商品列表
	 * @param status
	 * @return      
	 * @throws 
	 */
	List<TProduct> getItemListByStatus(Integer status,Integer sid);
	
	 
	/**
	* @Title: geTPbrowserecords
	* @Description: TODO
	* @param @param sid
	* @param @return    
	* @return List<TPbrowserecord>    
	* @throws
	*/
	List<CustomPbrowseRecord> geTPbrowserecords(Integer sid);
}
