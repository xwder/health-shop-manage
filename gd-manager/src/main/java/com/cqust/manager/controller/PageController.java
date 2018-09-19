package com.cqust.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class PageController {
	
	@RequestMapping("/index")
	public String showMain() {
		return "main";
	}

	@RequestMapping("/jsp/{url}")
	public String showPage(@PathVariable String url) {
		return url;
	}

}
