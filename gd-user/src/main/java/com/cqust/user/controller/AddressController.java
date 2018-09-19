package com.cqust.user.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.pojo.TAddress;
import com.cqust.pojo.TUserinfo;
import com.cqust.user.service.AddressService;

@Controller
@RequestMapping("/user/address")
public class AddressController {
	@Autowired
	private AddressService addressService;

	/** 
	 * @Title: showAddressList 
	 * @Description: 跳转到用户地址页面
	 * @param request 请求域
	 * @return      
	 * @throws 
	 */
	@RequestMapping("/showAddressList")
	public ModelAndView showAddressList(HttpServletRequest request) {

		@SuppressWarnings("unchecked")
		List<TAddress> list = (List<TAddress>) request.getSession().getAttribute("addressList");
		request.getSession().setAttribute("addressList", list);
	
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/useraddress");
		return modelAndView;
	}

	
	/** 
	 * @Title: userAddressList 
	 * @Description: 显示该用户所有地址信息
	 * @param id	用户id
	 * @param request
	 * @return      
	 * @throws 
	 */
	@RequestMapping("/useraddress")
	public ModelAndView userAddressList( HttpServletRequest request) {

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		
		if (userinfo == null) {
			modelAndView.setViewName("/error");
		} else {
			List<TAddress> addressList = addressService.getUserAddressList(userinfo.getId());
			request.getSession().setAttribute("addressList", addressList);
			request.getSession().setAttribute("userinfo", userinfo);
			
			modelAndView.addObject("addressList", addressList);
			modelAndView.addObject("addressCount", addressList.size());
			modelAndView.addObject("syAddressCount", 20 - addressList.size());
			modelAndView.addObject("userinfo",userinfo);
			modelAndView.setViewName("/useraddress");
		}
		return modelAndView;
	}

	/** 
	 * @Title: addUserAddress 
	 * @Description: 添加 或者修改用户地址
	 * @param address 地址信息
	 * @param request	请求域
	 * @return      
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addUserAddress")
	public ModelAndView addUserAddress(TAddress address, HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		List<TAddress> addressList = (List<TAddress>) request.getSession().getAttribute("addressList");
		if (address != null) {
			if (address.getId() != null) {
				addressService.UpdateAddressById(address);
				for (TAddress tAddress : addressList) {
					if (tAddress.getId() == address.getId()) {
						tAddress = address;
						address = null;
						request.getSession().setAttribute("addressList", addressList);
						request.getSession().setAttribute("address", null);
						break;
					}
				}
			} else {
				address.setUserid(userinfo.getId());
				address.setDefauladdress(0);
				addressService.addUserAddress(address);
				addressList.add(address);
				address = null;
				request.getSession().setAttribute("addressList", addressList);
				request.getSession().setAttribute("address", null);
			}
		}
		modelAndView.setViewName("redirect:/user/address/useraddress.html");
		return modelAndView;
	}

	/** 
	 * @Title: updateAddress 
	 * @Description: 修改用户地址
	 * @param id	用户id
	 * @param request 	请求域
	 * @return      
	 * @throws 
	 */
	@RequestMapping("/updateAddress/{id}")
	public ModelAndView updateAddress(@PathVariable Integer id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		request.getSession().setAttribute("userinfo", userinfo);

		if (id != null) {
			TAddress address = addressService.findAddressById(id);
			request.getSession().setAttribute("address", address);
		}
		
		modelAndView.setViewName("redirect:/user/address/useraddress.html");
		return modelAndView;
	}

	/** 
	 * @Title: deleteAddress 
	 * @Description: 删除用户地址
	 * @param id 用户id
	 * @param request
	 * @return      
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteAddress/{id}")
	public ModelAndView deleteAddress(@PathVariable Integer addrId, HttpServletRequest request) {

		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		request.getSession().setAttribute("userinfo", userinfo);

		ModelAndView modelAndView = new ModelAndView();
		TAddress address = new TAddress();
		address.setId(addrId);

		List<TAddress> list = (List<TAddress>) request.getSession().getAttribute("addressList");
		addressService.deleteAddress(address);
		Iterator<TAddress> addressIterator = list.iterator();
		while (addressIterator.hasNext()) {
			TAddress addr = addressIterator.next();
			if (addr.getId() == address.getId()) {
				addressIterator.remove();
			}
		}
		request.getSession().setAttribute("addressList", list);

		modelAndView.setViewName("redirect:/user/address/useraddress.html");
		return modelAndView;
	}
	
	@RequestMapping("/defauladdress/{id}")
	public ModelAndView updateDefaulAddress(@PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView();
		addressService.updateDefaulAddress(id);
		modelAndView.setViewName("redirect:/user/address/useraddress.html");
		return modelAndView;
	}

}
