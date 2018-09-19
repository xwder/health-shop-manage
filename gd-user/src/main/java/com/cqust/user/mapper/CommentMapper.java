package com.cqust.user.mapper;

import java.util.List;

import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TUncomment;

public interface CommentMapper {
	/**
	 * 获取留言记录
	 * @Title: getcommentrecord 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TUncomment> getcommentrecord(Integer id);
		
	/**
	 * 得到每一条留言记录
	 * @Title: getsinglecomment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	TUncomment getsinglecomment(Integer id);
	
	/**
	 * 会员获取消息提醒
	 * @Title: messageremind 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TMessageremind> messageremind(Integer id);

}
