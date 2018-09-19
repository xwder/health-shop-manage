package com.cqust.user.service;

import java.util.Date;
import java.util.List;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TSportplan;
import com.cqust.pojo.TUncomment;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipdietapplication;

public interface NutritionistService {
	/**
	 * 获取所有营养师信息
	 * @Title: getallnutritionist 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TUserinfo> getallnutritionist();
	
	/**
	 * 获取会员专属营养师
	 * @Title: getmynutritionist 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	TUserinfo getmynutritionist(Integer id);
	
	/**
	 * 会员选择营养师
	 * @Title: selectnutritionist 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	GdResult selectnutritionist(TVipdietapplication tVipdietapplication);
	
	/**
	 * 保存会员留言
	 * @Title: savecomment 
	 * @Description: TODO
	 * @param tUncomment
	 * @return      
	 * @throws
	 */
	GdResult savecomment(TUncomment tUncomment);
	
	/**
	 * 获取会员留言记录
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
	
	/**
	 * 获得饮食计划索引（营养师制定的饮食计划）
	 * @Title: getdietplanindex 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TPlanindex> getdietplanindex(Integer id);
	
	/**
	 * 获得运动计划索引（营养师制定的运动计划）
	 * @Title: getsportplanindex 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TPlanindex> getsportplanindex(Integer id);
	
	/**
	 * 根据饮食计划索引获取每一天的饮食计划（营养师制定的饮食计划）
	 * @Title: geteverydaydietplan 
	 * @Description: TODO
	 * @param uid
	 * @param nid
	 * @param planid
	 * @param plandate
	 * @return      
	 * @throws
	 */
	List<TDietplan> geteverydaydietplan(Integer uid,Integer nid,Integer planid,Date plandate);
	
	/**
	 * 根据运动计划索引获取每一天的运动计划（营养师制定的运动计划）
	 * @Title: geteverydaysportplan 
	 * @Description: TODO
	 * @param uid
	 * @param nid
	 * @param planid
	 * @param plandate
	 * @return      
	 * @throws
	 */
	List<TSportplan> geteverydaysportplan(Integer uid,Integer nid,Integer planid,Date plandate);
}
