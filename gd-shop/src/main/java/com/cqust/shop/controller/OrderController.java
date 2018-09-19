package com.cqust.shop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.DoubleUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TAddress;
import com.cqust.pojo.TCart;
import com.cqust.pojo.TCartitem;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;
import com.cqust.shop.service.AddressService;
import com.cqust.shop.service.CartService;
import com.cqust.shop.service.OrderService;
import com.cqust.shop.service.StoreService;
import com.cqust.shop.service.UserService;
import com.cqust.shop.utils.CartOrderUtil;

@RequestMapping("/shop")
@Controller
public class OrderController {

	@Autowired
	private UserService userService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartService cartService;

	@RequestMapping("/confirmorderinfo")
	@ResponseBody
	public Object confirmOrderInfo(HttpServletRequest request, @RequestParam("cartCheckBox") String[] cartCheckBoxs) {

		@SuppressWarnings("unchecked")
		List<TCartitem> cartitemList = (List<TCartitem>) request.getSession().getAttribute("cartitemList");
		List<TCartitem> orderitemList = new ArrayList<>();
		// 服务端校验 不能跨店购买商品
		Integer cartItemid = 0;
		Integer storeid = 0;
		if (cartCheckBoxs != null && cartCheckBoxs.length > 0) {
			try {
				cartItemid = Integer.parseInt(cartCheckBoxs[0]);
				TCartitem cartitem = CartOrderUtil.getCartitemById(cartitemList, cartItemid);
				Integer sid = cartitem.getSid();
				for (int i = 0; i < cartCheckBoxs.length; i++) {
					Integer sid_ = 0;
					cartitem = CartOrderUtil.getCartitemById(cartitemList, Integer.parseInt(cartCheckBoxs[i]));
					orderitemList.add(cartitem);
					sid_ = cartitem.getSid();
					storeid = sid;
					if (sid != sid_) {
						return GdResult.build(500, "暂不支持跨店铺下订单！");
					}
				}

			} catch (Exception e) {
				return GdResult.build(500, "创建订单失败,请重试！");
			}
		}

		TStoreinfo orderStoreinfo = storeService.getStoreInfoId(storeid);
		request.getSession().setAttribute("orderitemList", orderitemList);
		request.getSession().setAttribute("orderStoreinfo", orderStoreinfo);
		return GdResult.ok();
	}

	@RequestMapping("/showConfirmOder")
	public ModelAndView showConfirmOder(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		List<TAddress> addressList = userService.getUserAddressList(userinfo.getId());
		TStoreinfo orderStoreinfo = (TStoreinfo) request.getSession().getAttribute("orderStoreinfo");
		@SuppressWarnings("unchecked")
		List<TCartitem> orderitemList = (List<TCartitem>) request.getSession().getAttribute("orderitemList");

		double total = 0;
		if (orderitemList != null & orderitemList.size() > 0) {
			for (int i = 0; i < orderitemList.size(); i++) {
				total += orderitemList.get(i).getSubtotal();
			}
		}
		request.getSession().setAttribute("total", total);
		TAddress defaultAddress = addressService.getDefaultAddress();
		modelAndView.addObject("defaultAddress", defaultAddress);
		modelAndView.addObject("addressList", addressList);
		modelAndView.addObject("orderStoreinfo", orderStoreinfo);
		modelAndView.addObject("orderitemList", orderitemList);
		modelAndView.addObject("total", total);
		modelAndView.setViewName("/confirmorderinfo");
		return modelAndView;
	}

	@RequestMapping("/createOrder")
	public Object createOrder(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		@SuppressWarnings("unchecked")
		List<TCartitem> orderitemList = (List<TCartitem>) request.getSession().getAttribute("orderitemList");
		@SuppressWarnings("unchecked")
		List<TCartitem> cartitemList = (List<TCartitem>) request.getSession().getAttribute("cartitemList");
		TCart cart = (TCart) request.getSession().getAttribute("cart");
		List<TOrderitem> orderitems = new ArrayList<>();

		// 收货人电话
		String userphone = request.getParameter("userPhone");
		// 收货人地址
		String addr = request.getParameter("userAddr");
		// 收货人姓名
		String username = request.getParameter("userName");
		// 留言
		String message = request.getParameter("message");

		double total = (double) request.getSession().getAttribute("total");
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		TStoreinfo orderStoreinfo = (TStoreinfo) request.getSession().getAttribute("orderStoreinfo");

		TOrder order = new TOrder();
		order.setTotal(DoubleUtil.twoDouble(total));
		order.setOrdertime(new Date());
		// 订单状态 1:待商家接单 2商家已接单待配送 3：商家拒接单 4：已收货 5：交易完成待评价
		order.setOrderstates(1);
		order.setUsername(username);
		order.setUserphone(userphone);
		order.setUseraddr(addr);
		order.setUserid(userinfo.getId());
		order.setStoreid(orderStoreinfo.getId());
		order.setMessage(message);
		order.setDelstatus(0);
		order.setOrdercomment("");

		// 创建订单
		Integer r = orderService.addOrder(order);
		if (r != 1) {
			modelAndView.addObject("msg", "创建订单失败，请重试！");
			modelAndView.setViewName("/error");
			return modelAndView;
		}

		TCartitem cartitem = null;
		if (orderitemList.size() > 0 && orderitemList != null) {
			for (int i = 0; i < orderitemList.size(); i++) {
				TOrderitem orderitem = new TOrderitem();
				cartitem = orderitemList.get(i);
				orderitem.setPname(cartitem.getPname());
				orderitem.setPpic(cartitem.getPpic());
				orderitem.setPprice(cartitem.getPprice());
				orderitem.setCount(cartitem.getCount());
				orderitem.setSubtotal(cartitem.getSubtotal());
				orderitem.setOrderid(order.getId());
				orderitem.setPid(cartitem.getPid());
				orderitem.setStatus(1);
				orderitem.setUid(userinfo.getId());
				orderitems.add(orderitem);
				orderitem.setSid(orderStoreinfo.getId());
				// 删除购物项
				cartService.deleteCartItemById(cartitem.getId());
				CartOrderUtil.deleteCartItemByid(cartitemList, cartitem.getId());

			}
			cart.setTotal(cart.getTotal() - total);
			cartService.updateCartById(cart);
		}
		int r_ = orderService.addOrderItem(orderitems);
		if (r_ != 1) {
			modelAndView.addObject("msg", "创建订单失败，请重试！");
			modelAndView.setViewName("/error");
			return modelAndView;
		}

		request.getSession().setAttribute("currentOrderId", order.getId());
		modelAndView.setViewName("redirect:/shop/orderinfo.html");

		return modelAndView;
	}

	@RequestMapping("/orderinfo")
	public ModelAndView showOrderInfo(HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");

		// 下单完成后的订单id
		Integer orderid = (Integer) request.getSession().getAttribute("currentOrderId");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/orderinfo");
		modelAndView.addObject("orderStoreinfo", null);
		modelAndView.addObject("orderitemList", null);
		modelAndView.addObject("orderinfo", null);

		// request中的订单号
		String strOrderId = request.getParameter("orderid");
		Integer id = null;
		if (strOrderId != null) {
			try {
				id = Integer.parseInt(strOrderId);
				if (id != null) {
					TOrder orderinfo = orderService.getOrderById(id);
					if (orderinfo.getUserid() != userinfo.getId()) {
						modelAndView.addObject("msg", "您无权查看该订单信息！");
						return modelAndView;
					}
					List<TOrderitem> orderitemList = orderService.getOrderitemListByOrderId(id);
					TStoreinfo orderStoreinfo = storeService.getStoreInfoId(orderinfo.getStoreid());
					modelAndView.addObject("orderStoreinfo", orderStoreinfo);
					modelAndView.addObject("orderitemList", orderitemList);
					modelAndView.addObject("orderinfo", orderinfo);
					return modelAndView;
				}
			} catch (Exception e) {
				return modelAndView;
			}
		}
		if (orderid != null) {
			TOrder orderinfo = orderService.getOrderById(orderid);
			List<TOrderitem> orderitemList = orderService.getOrderitemListByOrderId(orderid);
			TStoreinfo orderStoreinfo = storeService.getStoreInfoId(orderinfo.getStoreid());
			modelAndView.addObject("orderStoreinfo", orderStoreinfo);
			modelAndView.addObject("orderitemList", orderitemList);
			modelAndView.addObject("orderinfo", orderinfo);
		}

		return modelAndView;
	}

	@RequestMapping("/buynow")
	public Object buynow(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String strItemNum = request.getParameter("itemnum");
		String strItemId = request.getParameter("itemid");
		String pname = request.getParameter("pname");
		String strStoreId = request.getParameter("storeid");
		String ppic = request.getParameter("ppic");
		String strPprice = request.getParameter("pprice");

		try {
			Integer itemnum = Integer.parseInt(strItemNum);
			Integer storeid = Integer.parseInt(strStoreId);
			Integer itemid = Integer.parseInt(strItemId);
			Double pprice = Double.parseDouble(strPprice);

			Double total = pprice * itemnum;
			TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
			request.getSession().setAttribute("total", total);
			TAddress defaultAddress = addressService.getDefaultAddress();
			modelAndView.addObject("defaultAddress", defaultAddress);
			List<TAddress> addressList = userService.getUserAddressList(userinfo.getId());
			modelAndView.addObject("addressList", addressList);

			TStoreinfo orderStoreinfo = storeService.getStoreInfoId(storeid);
			modelAndView.addObject("orderStoreinfo", orderStoreinfo);
			List<TCartitem> orderitemList = new ArrayList<>();
			TCartitem tCartitem = new TCartitem();
			tCartitem.setCartid(null);
			tCartitem.setCount(itemnum);
			tCartitem.setId(null);
			tCartitem.setPid(itemid);
			tCartitem.setPname(pname);
			tCartitem.setSid(storeid);
			tCartitem.setPprice(pprice);
			tCartitem.setPpic(ppic);
			tCartitem.setSubtotal(total);
			orderitemList.add(tCartitem);
			modelAndView.addObject("orderitemList", orderitemList);
			modelAndView.addObject("total", total);
			request.getSession().setAttribute("orderitemList", orderitemList);
			modelAndView.setViewName("/buynow");
		} catch (Exception e) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg", "购买失败");
			return modelAndView;
		}
		return modelAndView;
	}

	@RequestMapping("/buynoworder")
	public ModelAndView buynowCreateOrder(HttpServletRequest request) {
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		ModelAndView modelAndView = new ModelAndView();
		// 收货人电话
		String userphone = request.getParameter("userPhone");
		// 收货人地址
		String addr = request.getParameter("userAddr");
		// 收货人姓名
		String username = request.getParameter("userName");
		// 留言
		String message = request.getParameter("message");
		@SuppressWarnings("unchecked")
		List<TCartitem> orderitemList = (List<TCartitem>) request.getSession().getAttribute("orderitemList");
		TCartitem cartitem = orderitemList.get(0);
		if (cartitem != null) {
			TOrder order = new TOrder();
			order.setMessage(message);
			order.setOrderstates(1);
			order.setOrdertime(new Date());
			order.setStoreid(cartitem.getSid());
			order.setTotal(cartitem.getSubtotal());
			order.setUseraddr(addr);
			order.setUserid(userinfo.getId());
			order.setUsername(username);
			order.setUserphone(userphone);
			order.setDelstatus(0);
			Integer r = orderService.addOrder(order);
			if (r != 1) {
				modelAndView.addObject("msg", "创建订单失败，请重试！");
				modelAndView.setViewName("/error");
				return modelAndView;
			}
			TOrderitem orderitem = new TOrderitem();
			orderitem.setCount(cartitem.getCount());
			orderitem.setOrderid(order.getId());
			orderitem.setPid(cartitem.getPid());
			orderitem.setPname(cartitem.getPname());
			orderitem.setPpic(cartitem.getPpic());
			orderitem.setPprice(cartitem.getPprice());
			orderitem.setUid(userinfo.getId());
			orderitem.setSid(order.getStoreid());
			orderitem.setStatus(1);
			orderitem.setSubtotal(cartitem.getSubtotal());
			List<TOrderitem> list = new ArrayList<>();
			list.add(orderitem);
			Integer result = orderService.addOrderItem(list);
			if(result == 1){
				request.getSession().setAttribute("currentOrderId", order.getId());
				modelAndView.setViewName("redirect:/shop/orderinfo.html");
				return modelAndView;
			}
		}
		modelAndView.addObject("msg", "创建订单失败，请重试！");
		modelAndView.setViewName("/error");
		return modelAndView;
	}
}
