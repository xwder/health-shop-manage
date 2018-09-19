package com.cqust.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TAddress;
import com.cqust.shop.service.AddressService;

@Controller
@RequestMapping("/shop")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/changeDefaultAddress/{id}")
	@ResponseBody
	public Object changeDefaultAddress(@PathVariable Integer id,HttpServletRequest request){
		Integer re = addressService.updateDefaultAddress(id);
		if(re  == 1){
			return GdResult.ok();
		}
		return GdResult.build(500, "修改失败!");
	}
	
	@RequestMapping("/getAddressByid/{id}")
	@ResponseBody
	public Object getAddressByid(@PathVariable Integer id,HttpServletRequest request){
		TAddress address = addressService.getAddressById(id);
		if(address != null){
			return GdResult.ok(address);
		}else{
			return GdResult.build(400, "没有改地址！");
		}
		
	}
}
