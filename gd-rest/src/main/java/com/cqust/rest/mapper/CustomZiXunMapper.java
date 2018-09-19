package com.cqust.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqust.pojo.TZxtype;
import com.cqust.rest.pojo.ZiXunInfo;

public interface CustomZiXunMapper {
	/** 
	 * @Title: zxtypeList 
	 * @Description: 获取资讯类型列表
	 * @return      
	 * @throws 
	 */
	List<TZxtype> zxtypeList();
	
	/**
	 * @Title: getzixuninfo 
	 * @Description: 获取全部资讯或者根据类别获取部分资讯
	 * @return      
	 * @throws 
	 */
	List<ZiXunInfo> getzixuninfos(@Param("type") Integer type);
	
	/**
	 * @Title: getzixuninfo 
	 * @Description: 获取全部资讯
	 * @return      
	 * @throws 
	 */
	List<ZiXunInfo> getzixuninfo();
	
	/**
	 * @Title: getzixuninfobytype 
	 * @Description: 根据类型获取资讯
	 * @return      
	 * @throws 
	 */
	List<ZiXunInfo> getzixuninfobytype(Integer type);
	
	
	/**
	 * @Title: getzixuninfo 
	 * @Description: 获取某一条资讯
	 * @return      
	 * @throws 
	 */
	ZiXunInfo getzixuninfobyid(@Param("id") Integer id);
	
}
