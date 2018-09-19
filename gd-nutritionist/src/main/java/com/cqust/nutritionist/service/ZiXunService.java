package com.cqust.nutritionist.service;

import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.pojo.ZiXunInfo;
import com.cqust.pojo.TZxinfo;
import com.cqust.pojo.TZxtype;

/**
 * 资讯
 * 
 * @ClassName: ZiXunService
 * @Description: TODO
 * @author Joe
 * @date 2017年3月7日 上午9:56:24
 *
 */
public interface ZiXunService {
	
	/**
	 * 获取资讯类型
	 * @Title: getzxtype 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TZxtype> getzxtype();
	
	/** 
	 * @Title: getZiXuninfos
	 * @Description: 获取资讯
	 * @return       
	 * @throws 
	 */
	List<ZiXunInfo> getzixuninfos(Integer page,Integer pagesize,Integer type,String name);

    
	/**
	 * 获取某一条资讯
	 * @Title: getSingleJ1iankangzixun 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */	
	ZiXunInfo getSinglezixun(Integer id);
	
			
	/**
	 * 
	 * @Title: delJiankangzixun 
	 * @Description: 删除资讯
	 * @param id
	 * @return      
	 * @throws
	 */	
	GdResult delzixun(Integer id);
	
	/**
	 * 添加资讯
	 */
	GdResult addzixun(TZxinfo record);
	
	/**
	 * 修改资讯
	 */
	GdResult updatezixun(TZxinfo record);
	

}
