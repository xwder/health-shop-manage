package com.cqust.shop.service;

import com.cqust.commom.pojo.PageBean;
import com.cqust.pojo.TPcomment;

public interface CommentService {
	
	/** 
	 * @Title: getPcommentPages 
	 * @Description: 根据商品id查询某一页商品评论
	 * @param pid 商品ID
	 * @param pagenum 页码
	 * @param pagesize 每一页大小
	 * @return      
	 * @throws 
	 */
	PageBean<TPcomment> getPcommentPages(Integer pid,Integer pagenum,Integer pagesize);

}
