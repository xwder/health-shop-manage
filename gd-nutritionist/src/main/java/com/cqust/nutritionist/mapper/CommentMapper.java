package com.cqust.nutritionist.mapper;

import java.util.List;

import com.cqust.pojo.TUncomment;

public interface CommentMapper {
	/**
	 * 获取未回复的留言信息
	 * @Title: getUnreplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TUncomment> getUnreplycomment(Integer id);
	
	/**
	 * 获取已经回复的留言信息
	 * @Title: getReplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TUncomment> getReplycomment(Integer id);
	
	/**
	 * 得到每一条已经回复的留言记录
	 * @Title: getSingleReplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	TUncomment getSingleReplycomment(Integer id);
	
	/**
	 * 得到每一条未回复的留言记录
	 * @Title: getSingleUnReplycomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	TUncomment getSingleUnReplycomment(Integer id);

}
