package com.cqust.nutritionist.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TUncommentMapper;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.nutritionist.mapper.CommentMapper;
import com.cqust.nutritionist.pojo.Comment;
import com.cqust.nutritionist.service.CommentService;
import com.cqust.pojo.TUncomment;
import com.cqust.pojo.TUserinfo;
@Service
public class CommentServiceImpl implements CommentService {
    
	@Autowired
	CommentMapper commentMapper;
	@Autowired
	TUserinfoMapper tUserinfoMapper;
	@Autowired
	TUncommentMapper tUncommentMapper;
	/**
	 * 获取未回复的留言信息
	 */
	@Override
	public List<Comment> getUnreplycomment(Integer id) {
		// TODO Auto-generated method stub
		TUserinfo tUserinfo = new TUserinfo();
		List<Comment> comments = new ArrayList<Comment>();
		List<TUncomment> tUncomments = commentMapper.getUnreplycomment(id);
		for(int i=0;i<tUncomments.size();i++){
			tUserinfo = tUserinfoMapper.selectByPrimaryKey(tUncomments.get(i).getUid());
			Comment comment = new Comment();
			comment.setId(tUncomments.get(i).getId());
			comment.setImage(tUserinfo.getImage());
			comment.setUsername(tUserinfo.getName());
			comment.setSex(tUserinfo.getSex());
			comment.setCommentcontent(tUncomments.get(i).getCommentcontent());
			comment.setCommenttime(tUncomments.get(i).getCommenttime());
			comment.setIsreply(tUncomments.get(i).getIsreply());
			comments.add(comment);
		}	
		return comments;
	}
    /**
     * 获取已经回复的留言信息
     */
	@Override
	public List<Comment> getReplycomment(Integer id) {
		// TODO Auto-generated method stub
		TUserinfo tUserinfo = new TUserinfo();	
		List<Comment> comments = new ArrayList<Comment>();
		List<TUncomment> tUncomments = commentMapper.getReplycomment(id);
		for(int i=0;i<tUncomments.size();i++){
			tUserinfo = tUserinfoMapper.selectByPrimaryKey(tUncomments.get(i).getUid());
			Comment comment = new Comment();
			comment.setId(tUncomments.get(i).getId());
			comment.setImage(tUserinfo.getImage());
			comment.setUsername(tUserinfo.getName());
			comment.setSex(tUserinfo.getSex());
			comment.setUid(tUserinfo.getId());
			comment.setNid(id);
			comment.setCommentcontent(tUncomments.get(i).getCommentcontent());
			comment.setCommenttime(tUncomments.get(i).getCommenttime());
			comment.setReplycontent(tUncomments.get(i).getReplycontent());
			comment.setReplytime(tUncomments.get(i).getReplytime());
			comment.setIsreply(tUncomments.get(i).getIsreply());
			comments.add(comment);
		}	
		return comments;
	}

	@Override
	public GdResult deleteComment(Integer id) {
		// TODO Auto-generated method stub
		try{
			if(tUncommentMapper.deleteByPrimaryKey(id)==1)
				return GdResult.build(200, "删除成功!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return GdResult.build(400, "删除失败!");
	}

	@Override
	public GdResult replyComment(TUncomment tUncomment) {
		
		try{
			if(tUncommentMapper.updateByPrimaryKeySelective(tUncomment)==1)
				return GdResult.build(200, "回复成功!");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return GdResult.build(400, "回复失败!");
	}
	@Override
	public GdResult getSingleReplycomment(Integer id) {
		
		try{
		TUncomment tUncomment = commentMapper.getSingleReplycomment(id);
		if(tUncomment!=null)
			return GdResult.build(200,null,tUncomment);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return GdResult.build(400,"数据获取失败!",null);
	}
	@Override
	public GdResult getSingleUnReplycomment(Integer id) {
		
		try{
			TUncomment tUncomment = commentMapper.getSingleUnReplycomment(id);
			if(tUncomment!=null)
				return GdResult.build(200,null,tUncomment);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return GdResult.build(400,"数据获取失败!",null);
	}
}
