package com.cqust.nutritionist.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cqust.pojo.TUserhealthinfo;
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TVipdietapplication;

public interface VipMapper {
	 /**
	 * 根据营养师id得到会员基本信息
	 * @Title: geTUserinfos 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	List<TUserinfo> geTUserinfos(Integer id);

	/**
	 * 获取会员健康信息
	 * @Title: geTUserhealthinfos 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TUserhealthinfo> geTUserhealthinfos(Integer id);
	
	/**
	 * 获取会员的申请信息
	 * @Title: getVipapplication 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	List<TVipdietapplication> getVipapplication(@PathVariable Integer id);
	
	/**
	 * 营养师删除某个会员
	 * @Title: deleteVip 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	void deleteVip(Integer uid,Integer nid);
}
