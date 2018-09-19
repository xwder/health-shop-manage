package com.cqust.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TPcommentMapper;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TPcommentExample;
import com.cqust.pojo.TPcommentExample.Criteria;
import com.cqust.rest.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private TPcommentMapper pcommentMapper;

	@Override
	public GdResult addPComment(TPcomment pcomment) {
		int result = pcommentMapper.insert(pcomment);
		if (result == 1) {
			return GdResult.ok();
		}
		return GdResult.build(500, "添加失败！");
	}

	@Override
	public TPcomment geTPcommentByOrderItemId(Integer id) {
		TPcommentExample example = new TPcommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderitemidEqualTo(id);
		List<TPcomment> list = pcommentMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TPcomment tPcomment = list.get(0);
			return tPcomment;
		}
		return null;
	}

	@Override
	public PageBean<TPcomment> getPcommentPages(Integer pid, Integer pagenum, Integer pagesize) {
		PageBean<TPcomment> pageBean = new PageBean<>();
		if(pagenum <0 || pid <0 || pagesize <0)
			return null;
		List<TPcomment> commentList = new ArrayList<>();
		PageHelper.startPage(pagenum, pagesize);
		
		TPcommentExample example = new TPcommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		commentList = pcommentMapper.selectByExample(example);
		if(commentList == null || commentList.size() < 1){
			return null;
		}
		PageInfo<TPcomment> pageInfo = new PageInfo<>(commentList);
		Integer t = (int)pageInfo.getTotal();
		pageBean.setList(commentList);
		pageBean.setPageNum(pagenum);
		if(t % pagesize == 0){
			pageBean.setPages(t / pagesize);
		}else{
			pageBean.setPages(t / pagesize + 1);
		}
		pageBean.setPageSize(pagesize);
		pageBean.setTotal(t);
		pageBean.setSize(commentList.size());
		
		return pageBean;
	}

}
