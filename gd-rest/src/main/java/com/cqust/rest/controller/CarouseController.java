package com.cqust.rest.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.ExceptionUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TPicture;
import com.cqust.rest.service.CarouselService;
import com.cqust.rest.utils.Carouse;

@Controller
public class CarouseController {

	@Autowired
	private CarouselService carouseService;

	/** 
	 * @Title: getCarouseList 
	 * @Description: 获取轮播列表
	 * @param type	轮播类型	
	 * @return      轮播列表
	 * @throws 
	 */
	@RequestMapping("/carouse/{type}")
	@ResponseBody
	public Object getCarouseList(@PathVariable String type) {

		List<TPicture> carouseList = null;

		// 参数有效性校验
		if (StringUtils.isBlank(type)) {
			return  GdResult.build(400, "轮播类型不能为空");
			
		}
		if (type == null) {
			return  GdResult.build(400, "轮播类型不能为空");
		}
		if (type.equals(Carouse.ZIXUN) || type.equals(Carouse.SHANGPING)) {
			try {
				carouseList = carouseService.getCarouseList(type);
				return GdResult.ok(carouseList);
			} catch (Exception e) {
				return   GdResult.build(500, ExceptionUtil.getStackTrace(e));
			}
		}

		return GdResult.build(400, "轮播类型错误");
	}
}
