package com.cqust.zixun.controller;

import java.io.UnsupportedEncodingException;
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
import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TZxbrowserecord;
import com.cqust.pojo.TZxtype;
import com.cqust.zixun.pojo.ZiXunInfo;
import com.cqust.zixun.service.ZiXunService;

@Controller
@RequestMapping("/zixun")
public class ZiXunController {

	@Autowired
	private ZiXunService ziXunService;

	@RequestMapping("/{zxtypename}/{zxyear}/{zxmonth}/{zxday}/{zxid}")
	public ModelAndView showZiXun(@PathVariable Integer zxid,HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("/userinfo");
		
		ZiXunInfo zXunInfo = ziXunService.getZiXunById(zxid);
		try {
			if(zXunInfo != null){
				TZxbrowserecord zxbrowserecord= new TZxbrowserecord();
				zxbrowserecord.setUid(0);
				zxbrowserecord.setUsername("游客");
				zxbrowserecord.setUsertype(2);
				zxbrowserecord.setZxid(zXunInfo.getId());
				zxbrowserecord.setZxtitle(zXunInfo.getTitle());
				zxbrowserecord.setBrowsetime(new Date());
				zxbrowserecord.setUserip(IpUtils.getIpAddr(request));
				zxbrowserecord.setZxtype(zXunInfo.getZxtypeid());
				if(userinfo != null){
					zxbrowserecord.setUid(userinfo.getId());
					zxbrowserecord.setUsername(userinfo.getUsername());
					zxbrowserecord.setUsertype(1);
				}
				ziXunService.addZiXunBrowse(zxbrowserecord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/zixun");
		modelAndView.addObject("zixun", zXunInfo);
		return modelAndView;
	}

	@RequestMapping("/{strZxType}")
	public ModelAndView zxList(@PathVariable String strZxType, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		String strPage = request.getParameter("page");
		String strPageSize = request.getParameter("pagesize");
		strZxType = strConverter(strZxType);
		Integer page = 1;
		Integer pagesize = 10;
		if(strPage != null & strPageSize != null){
			try {
				page = Integer.parseInt(strPage);
				pagesize = Integer.parseInt(strPageSize);
			} catch (Exception e) {
				
			}
		}
		
		List<TZxtype> zxtypeList = ziXunService.getZxTypeList();
		Integer zxtypeid = null ;
		if(!"资讯首页".equals(strZxType)){
			if (zxtypeList != null & zxtypeList.size() > 0) {
				for (int i = 0; i < zxtypeList.size(); i++) {
					if (zxtypeList.get(i).getZxtypename().equals(strZxType)) {
						zxtypeid = zxtypeList.get(i).getId();
						break;
					}
				}
			}
		}
		PageBean<ZiXunInfo> pageBean = ziXunService.getZiXunInfoByZxType(zxtypeid, page, pagesize);
		

		modelAndView.setViewName("/zxlist");
		modelAndView.addObject("zxtypeList", zxtypeList);
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.addObject("strZxType", strZxType);
		modelAndView.addObject("page", page);
		modelAndView.addObject("pagesize", pagesize);
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
