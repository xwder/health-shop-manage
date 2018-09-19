package com.cqust.manager.service;

import java.util.List;

import com.cqust.manager.pojo.ProductBrowseRecord;
import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.pojo.TSearchrecord;
import com.cqust.pojo.TUserlog;
import com.cqust.pojo.TZxbrowserecord;

public interface RecordService {
	/**
	 * 获取用户登录记录
	 * @Title: getuserlogrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TUserlog> getuserlogrecord();
	
	/**
	 * 获取商品浏览记录
	 * @Title: getproductrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<ProductBrowseRecord> getproductrecord();
	
	/**
	 * 获取搜索查找记录
	 * @Title: getsearchrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TSearchrecord> getsearchrecord();
	
	/**
	 * 获取资讯浏览记录
	 * @Title: getzxrecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TZxbrowserecord> getzxrecord();
	
	/**
	 * 获取首页访问记录
	 * @Title: getpotalbrowserecord 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TPotalbrowserecord> getpotalbrowserecord();
 
}
