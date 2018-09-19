package com.cqust.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.mapper.TDietplanMapper;
import com.cqust.mapper.TPlanindexMapper;
import com.cqust.mapper.TSportplanMapper;
import com.cqust.mapper.TUncommentMapper;
import com.cqust.mapper.TUserinfoMapper;
import com.cqust.mapper.TVipdietapplicationMapper;
import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TDietplanExample;
import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TPlanindexExample;
import com.cqust.pojo.TSportplan;
import com.cqust.pojo.TSportplanExample;
import com.cqust.pojo.TUncomment;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserinfoExample;
import com.cqust.pojo.TUserinfoExample.Criteria;
import com.cqust.pojo.TVipdietapplication;
import com.cqust.pojo.TVipdietapplicationExample;
import com.cqust.user.mapper.CommentMapper;
import com.cqust.user.service.NutritionistService;
@Service
public class NutritionistServiceImpl implements NutritionistService {

	@Autowired
	TUserinfoMapper tUserinfoMapper;
	@Autowired 
	TVipdietapplicationMapper tVipdietapplicationMapper;
	@Autowired
	TUncommentMapper tUncommentMapper;
	@Autowired
	CommentMapper commentMapper;
	@Autowired
	TPlanindexMapper tPlanindexMapper;
	@Autowired
	TDietplanMapper tDietplanMapper;
	@Autowired
	TSportplanMapper tSportplanMapper;
	/**
	 * 获取所有营养师信息
	 * @Title: getallnutritionist 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@Override
	public List<TUserinfo> getallnutritionist() {
		TUserinfoExample example = new TUserinfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsdietEqualTo(1);
		List<TUserinfo> tUserinfos = tUserinfoMapper.selectByExample(example);
		return tUserinfos;		
	}
	
	/**
	 * 获取会员专属营养师
	 */
	@Override
	public TUserinfo getmynutritionist(Integer id) {
		Integer nid = tUserinfoMapper.selectByPrimaryKey(id).getDietitianid();
	    TUserinfo tUserinfo = tUserinfoMapper.selectByPrimaryKey(nid);
	    tUserinfo.setPassword(null);
		return tUserinfo;
	}
	   
	/**
	 * 会员选择营养师
	 */
	@Override
	public GdResult selectnutritionist(TVipdietapplication tVipdietapplication) {
		
		TVipdietapplicationExample example = new TVipdietapplicationExample();
		com.cqust.pojo.TVipdietapplicationExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(tVipdietapplication.getUserid()).andSqstatusNotEqualTo(0);
		List<TVipdietapplication> app = tVipdietapplicationMapper.selectByExample(example);
		if(app!=null&&app.size()>0)
			return GdResult.build(400, "对不起,您已经选择了营养师,不可重复选择!",null);
		else{
			tVipdietapplicationMapper.insertSelective(tVipdietapplication);
			return GdResult.build(200, "选择成功,请等待营养师审核!",null);
		}						
	}
    
	/**
	 * 保存会员留言
	 */
	@Override
	public GdResult savecomment(TUncomment tUncomment) {
		try{
			if(tUncommentMapper.insertSelective(tUncomment)==1)
				return GdResult.build(200, "留言成功!");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return GdResult.build(400, "留言失败!");
	}

	/**
	 * 获取会员留言记录
	 */
	@Override
	public List<TUncomment> getcommentrecord(Integer id) {		
		List<TUncomment> tUncomments = commentMapper.getcommentrecord(id);
		return tUncomments;		
	}
    
	/**
	 * 获取每一条留言记录
	 */
	@Override
	public TUncomment getsinglecomment(Integer id) {
		TUncomment tUncomment = commentMapper.getsinglecomment(id);
		return tUncomment;
	}
    
	/**
	 * 会员获取消息提醒
	 */
	@Override
	public List<TMessageremind> messageremind(Integer id) {
		List<TMessageremind> tMessagereminds = commentMapper.messageremind(id);
		return tMessagereminds;
	}
    
	/**
	 * 获得饮食计划索引（营养师制定的饮食计划）
	 */
	@Override
	public List<TPlanindex> getdietplanindex(Integer id) {
		TPlanindexExample example = new TPlanindexExample();
		com.cqust.pojo.TPlanindexExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id).andPlantypeEqualTo(0);
		List<TPlanindex> tPlanindexs = tPlanindexMapper.selectByExample(example); 
		return tPlanindexs;
	}
    
	/**
	 * 获得运动计划索引（营养师制定的运动计划）
	 */
	@Override
	public List<TPlanindex> getsportplanindex(Integer id) {
		TPlanindexExample example = new TPlanindexExample();
		com.cqust.pojo.TPlanindexExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id).andPlantypeEqualTo(1);
		List<TPlanindex> tPlanindexs = tPlanindexMapper.selectByExample(example); 
		return tPlanindexs;
	}

	@Override
	public List<TDietplan> geteverydaydietplan(Integer uid, Integer nid, Integer planid, Date plandate) {
		TDietplanExample example = new TDietplanExample();
		com.cqust.pojo.TDietplanExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid).andNutritionistidEqualTo(nid).andPlanidEqualTo(planid).andPlandateEqualTo(plandate);	
		List<TDietplan> tDietplans = tDietplanMapper.selectByExample(example);
		return tDietplans;
	}

	@Override
	public List<TSportplan> geteverydaysportplan(Integer uid, Integer nid, Integer planid, Date plandate) {
		TSportplanExample example = new TSportplanExample();
		com.cqust.pojo.TSportplanExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid).andNutritionistidEqualTo(nid).andPlanidEqualTo(planid).andPlandateEqualTo(plandate);	
		List<TSportplan> tSportplans = tSportplanMapper.selectByExample(example);
		return tSportplans;
	}

}
