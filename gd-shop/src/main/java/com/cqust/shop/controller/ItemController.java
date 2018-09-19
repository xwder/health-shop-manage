package com.cqust.shop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.IpUtils;
import com.cqust.pojo.TPbrowserecord;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TProduct;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;
import com.cqust.shop.service.CommentService;
import com.cqust.shop.service.ItemService;
import com.cqust.shop.service.PBrowseRecordService;
import com.cqust.shop.service.StoreService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PBrowseRecordService pBrowseRecordService;

	@RequestMapping("{id}")
	public ModelAndView item(@PathVariable Integer id,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");

		//添加商品浏览记录
		TPbrowserecord pbrowserecord = new TPbrowserecord();
		pbrowserecord.setUsertype(1);
		pbrowserecord.setPid(id);
		pbrowserecord.setUid(0);
		pbrowserecord.setUsername("游客");
		
		if(userinfo != null){
			pbrowserecord.setUid(userinfo.getId());
			pbrowserecord.setUsername(userinfo.getUsername());
			pbrowserecord.setUsertype(2);
		}
		
		String  ipaddress = IpUtils.getIpAddr(request);
		pbrowserecord.setUserip(ipaddress);
		pbrowserecord.setBrowsetime(new Date());
		
		
		TProduct item = itemService.getItemBaseInfo(id);
		if (item == null) {
			modelAndView.setViewName("/noitem");
			modelAndView.addObject("msg", "没有该商品");
			return modelAndView;
		}

		// 分页
		PageBean<TPcomment> pageBean = commentService.getPcommentPages(id, 1, 16);
		// 匿名处理
		if (pageBean != null && pageBean.getList() != null && pageBean.getList().size() > 0) {
			for (int i = 0; i < pageBean.getList().size(); i++) {
				String username = pageBean.getList().get(i).getUsername();
				String nUserName = username.charAt(0) + "***" + username.charAt(username.length() - 2);
				pageBean.getList().get(i).setUsername(nUserName);
			}
		}
		List<TProduct> collocationList = itemService.getItemCollocations(item.getId());
		List<TProduct> sortItemList = itemService.getItemsBySellCount("desc", item.getStoreid());
		TStoreinfo storeinfo = storeService.getStoreInfoId(item.getStoreid());
		pbrowserecord.setSid(storeinfo.getId());
		pBrowseRecordService.addPBrowseRecordService(pbrowserecord);

		modelAndView.addObject("item", item);
		modelAndView.addObject("collocationList", collocationList);
		modelAndView.addObject("sortItemList", sortItemList);
		modelAndView.addObject("storeinfo", storeinfo);
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("/item");
		return modelAndView;
	}

}
