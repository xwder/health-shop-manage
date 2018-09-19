package com.cqust.user.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;
import com.cqust.user.service.CommentService;

@RequestMapping("/user")
@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping("/comment")
	public ModelAndView comment(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String strItemid = request.getParameter("itemid");
		Integer itemid = null;
		try {
			itemid = Integer.parseInt(strItemid);
		} catch (Exception e) {
			modelAndView.setViewName("error");
			modelAndView.addObject("msg", "评价商品失败！");
			return modelAndView;
		}
		TOrder order = null;
		TStoreinfo storeinfo = null;
		TOrderitem item = commentService.getTOrderItemById(itemid);
		if (item != null) {
			order = commentService.getOrderByid(item.getOrderid());
			if (order != null) {
				storeinfo = commentService.getStoreinfoById(order.getStoreid());
			}
		}
		modelAndView.addObject("item", item);
		modelAndView.addObject("storeinfo", storeinfo);
		modelAndView.addObject("order", order);
		modelAndView.setViewName("/comment");
		return modelAndView;
	}

	@RequestMapping("/addcomment")
	@ResponseBody
	public Object addComment(HttpServletRequest request) {
		String commentcontent = request.getParameter("commentcontent");
		String strCommentLevel = request.getParameter("commentlevel");
		String strPid = request.getParameter("pid");
		String strOrderItemId = request.getParameter("orderitemid");
		String strOrderId = request.getParameter("orderid");
		Integer orderItemId = 0;
		Integer orderid = 0;
		Integer pid = 0;
		Integer commentLevel = 0;
		Integer commentType = 0; // 评论等级 1：好评，2：中评，3：差评
		try {
			commentLevel = Integer.parseInt(strCommentLevel);
			pid = Integer.parseInt(strPid);
			orderItemId = Integer.parseInt(strOrderItemId);
			orderid = Integer.parseInt(strOrderId);
		} catch (Exception e) {
			return GdResult.build(500, "评论失败");
		}
		if (commentLevel != 0) {
			if (commentLevel == 1 || commentLevel == 2) {
				commentType = 3;
			} else if (commentLevel == 3 || commentLevel == 4) {
				commentType = 2;
			} else if (commentLevel == 5) {
				commentType = 1;
			} else {
				return GdResult.build(500, "评论失败");
			}
		}

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");

		TPcomment pcomment = new TPcomment();
		pcomment.setComlevel(commentLevel);
		pcomment.setComtype(commentType);
		pcomment.setComtext(commentcontent);
		pcomment.setOrderitemid(orderItemId);
		pcomment.setUsername(userinfo.getUsername());
		pcomment.setUserid(userinfo.getId());
		pcomment.setPid(pid);
		pcomment.setTime(new Date());

		// 添加评论到数据库
		Integer re = commentService.addPComment(pcomment);

		// 修改订单项 状态
		TOrderitem orderitem = new TOrderitem();
		orderitem.setId(orderItemId);
		orderitem.setStatus(5);
		orderitem.setOrderid(orderid);

		Integer r = commentService.updateOrderItemStatusById(orderitem);

		if (re == 1 && r == 1) {
			return GdResult.ok();
		}

		return GdResult.build(500, "评论失败！");
	}

	@RequestMapping("/itemcomment")
	public ModelAndView showOrderItemComment(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String strOrderItemId = request.getParameter("itemid");
		Integer orderitemid = 0;
		try {
			orderitemid = Integer.parseInt(strOrderItemId);
		} catch (Exception e) {
			modelAndView.addObject("msg","查看失败！");
			modelAndView.setViewName("/error");
			return modelAndView;
		}
		TOrderitem item = commentService.getTOrderItemById(orderitemid);
		if(item != null){
			TOrder order = commentService.getOrderByid(item.getOrderid());
			TStoreinfo storeinfo = commentService.getStoreinfoById(item.getSid());
			TPcomment comment = commentService.geTPcommentByOrderItemId(item.getId());
			if(order != null && storeinfo != null && comment != null){
				modelAndView.addObject("item",item );
				modelAndView.addObject("order",order );
				modelAndView.addObject("storeinfo", storeinfo);
				modelAndView.addObject("comment", comment);
				modelAndView.setViewName("/itemcomment");
				return modelAndView;
			}
		}
		
		modelAndView.addObject("msg","查看失败！");
		modelAndView.setViewName("/error");
		return modelAndView;
	}
}
