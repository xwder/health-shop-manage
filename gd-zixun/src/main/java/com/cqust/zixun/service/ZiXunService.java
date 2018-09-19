package com.cqust.zixun.service;

import java.util.List;

import com.cqust.commom.pojo.PageBean;
import com.cqust.pojo.TZxbrowserecord;
import com.cqust.pojo.TZxtype;
import com.cqust.zixun.pojo.ZiXunInfo;

public interface ZiXunService {

	/** 
	 * @Title: getZiXunById 
	 * @Description: 根据资讯ID获取资讯信息
	 * @param id
	 * @return      
	 * @throws 
	 */
	ZiXunInfo getZiXunById(Integer id);
	
	
	/** 
	 * @Title: getZxTypeList 
	 * @Description: 获取资讯类型列表
	 * @return      
	 * @throws 
	 */
	List<TZxtype> getZxTypeList();
	
	/** 
	 * @Title: getZiXunInfoByZxType 
	 * @Description: 获取某一类资讯分页
	 * @param zxtypeid
	 * @param page
	 * @param pagesize
	 * @return      
	 * @throws 
	 */
	PageBean<ZiXunInfo> getZiXunInfoByZxType(Integer zxtypeid,Integer page ,Integer pagesize);
	
	/**
	* @Title: addZiXunBrowse
	* @Description: 添加资讯浏览记录
	* @param  @param zxbrowserecord
	* @param  @return    
	* @return Integer    
	* @throws
	*/
	public Integer addZiXunBrowse(TZxbrowserecord zxbrowserecord);
}
