package com.cqust.portal.service;

import java.util.List;

import com.cqust.pojo.TZxinfo;
import com.cqust.portal.pojo.ZiXunInfo;

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
	 * @Title: getZXListByType 
	 * @Description: 获取不同类型资讯列表
	 * @param zxtype
	 * @return      
	 * @throws 
	 */
	List<ZiXunInfo> getZXListByType(Integer zxtype,Integer page,Integer pagesize);
}
