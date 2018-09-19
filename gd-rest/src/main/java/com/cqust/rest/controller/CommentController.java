package com.cqust.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.pojo.TPcomment;
import com.cqust.rest.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping("/addcomment")
	@ResponseBody
	public GdResult addComment(@RequestBody String commentJson) {

		TPcomment pcomment = null;
		try {
			pcomment = JsonUtils.jsonToPojo(commentJson, TPcomment.class);
		} catch (Exception e) {
			return GdResult.build(500, e.toString());
		}

		GdResult result = commentService.addPComment(pcomment);

		return result;
	}

	@RequestMapping("/commentbyorderitemid/{id}")
	@ResponseBody
	public GdResult geTPcommentByOrderItemId(@PathVariable Integer id) {
		TPcomment pcomment = null;
		pcomment = commentService.geTPcommentByOrderItemId(id);
		if (pcomment == null) {
			return GdResult.build(400, "没有查到该条评论！");
		}
		return GdResult.ok(pcomment);
	}

	@RequestMapping("/comments/{pid}/{pagenum}/{pagesize}")
	@ResponseBody
	public PageBean<TPcomment> getCommentPages(@PathVariable Integer pid, @PathVariable Integer pagenum,
			@PathVariable Integer pagesize) {

		return commentService.getPcommentPages(pid, pagenum, pagesize);
	}
}
