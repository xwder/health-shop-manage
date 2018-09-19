package com.cqust.nutritionist.service;

import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.pojo.Comment;
import com.cqust.pojo.TUncomment;

public interface CommentService {
	/**
	 * 获取未回复的留言信息
	 * @Title: getUnreplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<Comment> getUnreplycomment(Integer id);
	 
	/**
	 * 获取已经回复的留言信息
	 * @Title: getReplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<Comment> getReplycomment(Integer id);
	
	/**
	 * 得到每一条已经回复的留言记录
	 * @Title: getSingleReplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	GdResult getSingleReplycomment(Integer id);
	
	/**
	 * 得到每一条未回复的留言记录
	 * @Title: getSingleUnReplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	GdResult getSingleUnReplycomment(Integer id);
	
	/**
	 * 删除留言
	 * @Title: deleteComment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	GdResult deleteComment(Integer id);
    
	/**
	 * 回复留言
	 * @Title: replyComment 
	 * @Description: TODO
	 * @param tUncomment
	 * @return      
	 * @throws
	 */
	GdResult replyComment(TUncomment tUncomment);
}
