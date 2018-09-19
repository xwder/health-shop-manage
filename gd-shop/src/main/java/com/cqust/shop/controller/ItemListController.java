package com.cqust.shop.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.IpUtils;
import com.cqust.pojo.TProduct;
import com.cqust.pojo.TSearchrecord;
import com.cqust.pojo.TUserinfo;
import com.cqust.shop.pojo.ItemInfo;
import com.cqust.shop.service.ItemService;
import com.cqust.shop.service.PSearchRecordService;

@Controller
public class ItemListController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private PSearchRecordService pSearchRecordService;

	@RequestMapping("/list")
	public ModelAndView itemlist(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		TSearchrecord searchrecord = new TSearchrecord();
		searchrecord.setSearchtime(new Date());
		searchrecord.setUid(0);
		searchrecord.setUserip(IpUtils.getIpAddr(request));
		searchrecord.setUsername("游客");
		searchrecord.setUsertype(2);

		if (userinfo != null) {
			searchrecord.setUid(userinfo.getId());
			searchrecord.setUsername(userinfo.getUsername());
			searchrecord.setUsertype(1);
		}

		String itemtype = request.getParameter("itemtype");
		String query = request.getParameter("query");
		String sdz = request.getParameter("sdz");
		String strPage = request.getParameter("page");
		String sellnum = request.getParameter("sellnum");
		String sssj = request.getParameter("sssj");
		String price = request.getParameter("price");
		String storeid = request.getParameter("storeid");
		itemtype = strConverter(itemtype);
		query = strConverter(query);
		sdz = strConverter(sdz);

		// 添加搜索记录
		String queryjl = (String)session.getAttribute("query");
		if (queryjl == null && query != null) {
			searchrecord.setSearchword(query);
			pSearchRecordService.addSearchRecord(searchrecord);
			session.setAttribute("query", query);
		}
		if (query != null && queryjl != null && !query.equals(queryjl)) {
			searchrecord.setSearchword(query);
			pSearchRecordService.addSearchRecord(searchrecord);
			session.setAttribute("query", query);
		}

		List<TProduct> rightList = itemService.getItemsBySellCount("desc", null);

		Integer page = 1;
		if (strPage != null) {
			page = Integer.parseInt(strPage);
			modelAndView.addObject("page", page);
		}
		

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("itemtype", itemtype);
		map.put("storeid", storeid);
		map.put("query", query);
		map.put("sdz", sdz);
		map.put("sellnum", null);
		map.put("sssj", null);
		map.put("price", null);
		map.put("page", page);
		map.put("rows", 16);
		if("desc".equalsIgnoreCase(sssj)){
			map.put("sssj", 1);
		}else if ("asc".equalsIgnoreCase(sssj)) {
			map.put("sssj", 0);
		}
		if("desc".equalsIgnoreCase(sellnum)){
			map.put("sellnum", 1);
		}else if ("asc".equalsIgnoreCase(sellnum)) {
			map.put("sellnum", 0);
		}
		if("desc".equalsIgnoreCase(price)){
			map.put("price", 1);
		}else if ("asc".equalsIgnoreCase(price)) {
			map.put("price", 0);
		}
		
		modelAndView.addObject("itemtype", itemtype);
		modelAndView.addObject("storeid", storeid);
		modelAndView.addObject("query",query );
		modelAndView.addObject("sdz",sdz );
		modelAndView.addObject("sellnum", sellnum);
		modelAndView.addObject("sssj", sssj);
		modelAndView.addObject("price",price );
		modelAndView.addObject("page",page );
		modelAndView.addObject("rows",16);
	

		PageBean<ItemInfo> pageBean = itemService.getItemList(map);

		modelAndView.addObject("pageBean", pageBean);
		modelAndView.addObject("rightList", rightList);
		modelAndView.setViewName("/itemlist");
		return modelAndView;
	}

	public String strConverter(String str) {
		if (str != null) {
			try {
				str = new String(str.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return str;
	}

}
