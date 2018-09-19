package com.cqust.rest.service;


import java.util.List;

import com.cqust.commom.pojo.PageBean;
import com.cqust.pojo.TZxinfo;
import com.cqust.pojo.TZxtype;
import com.cqust.rest.pojo.ZiXunInfo;

/**
 * 资讯接口
 * @ClassName: ZiXunService 
 * @Description: TODO 
 * @author Joe  
 * @date 2017年3月7日 上午10:12:21 
 *
 */
public interface ZiXunService {
	
	/** 
	 * @Title: zxTypeList 
	 * @Description: 获取所有资讯分类
	 * @return      
	 * @throws 
	 */
	List<TZxtype> zxTypeList();
	
	
 
	/** 
	 * @Title: zxinfoListByType 
	 * @Description:  分页确资讯根据资讯类型
	 * @param zxtype
	 * @param page
	 * @param pagesize
	 * @return      
	 * @throws 
	 */
	PageBean<ZiXunInfo> zxinfosByType(Integer zxtype,Integer page,Integer pagesize);
	
	/** 
	 * @Title: zxinfoListByType 
	 * @Description:  分页确资讯根据资讯类型
	 * @param zxtype
	 * @param page
	 * @param pagesize
	 * @return      
	 * @throws 
	 */
	PageBean<ZiXunInfo> zxinfoListByType(Integer zxtype,Integer page,Integer pagesize);
	
	/** 
	 * @Title: getZxinfoById 
	 * @Description: 根据资讯id获取资讯信息
	 * @param zxid
	 * @return      
	 * @throws 
	 */
	ZiXunInfo getZxinfoById(Integer zxid);
	
	
	/** 
	 * @Title: addZxinfo 
	 * @Description: 添加资讯
	 * @return      
	 * @throws 
	 */
	Integer addZxinfo(TZxinfo zxinfo);
	
	
	/** 
	 * @Title: updateZiInfoById 
	 * @Description: 根据资讯ID修改资讯信息
	 * @param zxinfo
	 * @return      
	 * @throws 
	 */
	Integer updateZiInfoById(TZxinfo zxinfo);
	
	/** 
	 * @Title: updateZiInfoById 
	 * @Description: 根据资讯ID删除某一条资讯
	 * @param zxinfo
	 * @return      
	 * @throws 
	 */
	Integer delZiInfoById(Integer zxid);
	
	
}
