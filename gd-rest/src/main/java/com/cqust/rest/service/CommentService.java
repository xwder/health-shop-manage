package com.cqust.rest.service;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TPcomment;

public interface CommentService {

	/** 
	 * @Title: addPComment 
	 * @Description: 添加商品评论
	 * @param pcomment
	 * @return      
	 * @throws 
	 */
	GdResult addPComment(TPcomment pcomment);
	
	/** 
	 * @Title: geTPcommentByPid 
	 * @Description: 根据订单项ID获取该订单项的商品评论
	 * @param id
	 * @return      
	 * @throws 
	 */
	TPcomment geTPcommentByOrderItemId(Integer id);
	
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
