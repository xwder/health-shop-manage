package com.cqust.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.pojo.TStoreinfo;
import com.cqust.rest.service.StoreinfoService;

@RequestMapping("/store")
@Controller
public class StoreController {

	@Autowired
	private StoreinfoService storeinfoService;

	@RequestMapping("/storelistbystype/{stype}")
	@ResponseBody
	public List<TStoreinfo> storeinfosByStype(@PathVariable String stype, HttpServletRequest request) {
		List<TStoreinfo> list = storeinfoService.storeinfosByStype(stype);
		return list;
	}

}
