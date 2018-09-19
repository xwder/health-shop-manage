package com.cqust.nutritionist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.pojo.Comment;
import com.cqust.nutritionist.service.CommentService;
import com.cqust.pojo.TUncomment;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping("/getunreplycomment/{id}")
	@ResponseBody
	public List<Comment> getUnreplycomment(@PathVariable Integer id){
		return commentService.getUnreplycomment(id);
	}
	
	
	@RequestMapping("/getreplycomment/{id}")
	@ResponseBody
	public List<Comment> getReplycomment(@PathVariable Integer id){
		return commentService.getReplycomment(id);
	}
	/**
	 * 得到每一条已经回复的留言记录
	 * @Title: getSingleReplycomment 
	 * @Description: TODO
	 * @param id      
	 * @throws
	 */
	@RequestMapping("/getSingleReplycomment/{id}")
	@ResponseBody
	public GdResult getSingleReplycomment(@PathVariable Integer id){
		return commentService.getSingleReplycomment(id);
	}
	
	/**
	 * 得到每一条未回复的留言记录
	 * @Title: getSingleUnReplycomment 
	 * @Description: TODO
	 * @param id      
	 * @throws
	 */
	@RequestMapping("/getSingleUnReplycomment/{id}")
	@ResponseBody
	public GdResult getSingleUnReplycomment(@PathVariable Integer id){
		return commentService.getSingleUnReplycomment(id);
	}
	
	/**
	 * 删除留言
	 * @Title: deleteComment 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/deletecomment/{id}")
	@ResponseBody
	public GdResult deleteComment(@PathVariable Integer id){
		 return commentService.deleteComment(id);		 
	}
	
	/**
	 * 回复留言
	 * @Title: replyComment 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/replycomment")
	@ResponseBody
	public GdResult replyComment(HttpServletRequest httpServletRequest){
		TUncomment tUncomment = new TUncomment();
		tUncomment.setId(Integer.parseInt(httpServletRequest.getParameter("id")));
		tUncomment.setReplycontent(httpServletRequest.getParameter("replycontent"));
		tUncomment.setIsreply(1);		      
        try {
        	tUncomment.setReplytime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("replytime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return commentService.replyComment(tUncomment);
	}
}
