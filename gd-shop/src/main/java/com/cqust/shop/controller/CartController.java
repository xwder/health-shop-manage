package com.cqust.shop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TCart;
import com.cqust.pojo.TCartitem;
import com.cqust.shop.pojo.CartPojo;
import com.cqust.shop.service.CartService;
import com.cqust.shop.service.StoreService;
import com.cqust.shop.utils.CartOrderUtil;

@Controller
@RequestMapping("/shop")
public class CartController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private CartService cartService;

	/**
	 * @Title: cart 
	 * @Description: 购物车
	 * @return 
	 * @throws
	 */
	@RequestMapping("/cart")
	public ModelAndView cart(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<TCartitem> cartitemList =  (List<TCartitem>) request.getSession().getAttribute("cartitemList");
		cartitemList = CartOrderUtil.Sort(cartitemList);
		List<CartPojo> cart = castToCart(cartitemList);
		modelAndView.addObject("cart",cart);
		modelAndView.setViewName("/cart");
		return modelAndView;
	}

	/**
	 * @Title: addcart
	 * @Description: 添加商品到购物车
	 * @return
	 * @throws  
	 */
	@RequestMapping(value = "/addcart",method = RequestMethod.POST)
	@ResponseBody
	public Object addcart(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<TCartitem> cartitemList = (List<TCartitem>) request.getSession().getAttribute("cartitemList");
		TCart cart = (TCart) request.getSession().getAttribute("cart");
		TCartitem cartitem = new TCartitem();
		
		//商品ID
		String strPId = request.getParameter("itemid");
		//商品数量
		String strItemNum = request.getParameter("itemnum");
		//商家id
		String strStoreId = request.getParameter("storeid");
		//商品价格
		String strPprice = request.getParameter("pprice");
		//商品名称
		String pname = request.getParameter("pname");
		//商品图片
		String ppic = request.getParameter("ppic");

		try {
			Integer pid = Integer.parseInt(strPId);
			Integer sid = Integer.parseInt(strStoreId);
			Integer num = Integer.parseInt(strItemNum);
			Double pprice = Double.parseDouble(strPprice);
			
			if(cartitemList != null && cartitemList.size() > 0 && cart != null){
				cartitem = CartOrderUtil.getCartitemByPId(cartitemList, pid);
				if(cartitem != null){
					cartitem.setCount(cartitem.getCount() + num);
					cartitem.setSubtotal(cartitem.getSubtotal() + pprice * num);
				}else{
					cartitem = new TCartitem();
					cartitem.setCartid(cart.getId());
					cartitem.setPname(pname);
					cartitem.setCount(num);
					cartitem.setSubtotal(num * pprice);
					cartitem.setSid(sid);
					cartitem.setPid(pid);
					cartitem.setPpic(ppic);
					cartitem.setPprice(pprice);
					addCartItem(cartitemList, cartitem);
					cart.setTotal(cart.getTotal() + cartitem.getSubtotal());
					Integer cartresult = cartService.updateCartById(cart);
					Integer itemresult = cartService.addCartItem(cartitem);
					if(cartresult == 1 && itemresult == 1){
						return GdResult.ok();
					}else{
						 
						return GdResult.build(500, "添加失败");
					}
				}
				
				cart.setTotal(cart.getTotal() + pprice * num);
				Integer cartresult = cartService.updateCartById(cart);
				Integer itemresult = cartService.updateCartItem(cartitem);
				if(cartresult == 1 && itemresult == 1){
					return GdResult.ok();
				}else{
					cartitem.setSubtotal(cartitem.getSubtotal() - pprice * num);
					cart.setTotal(cart.getTotal() - pprice * num);
					return GdResult.build(500, "添加失败");
				}
			}
			
			
			if(cartitemList.size() == 0){
				if (!StringUtils.isBlank(pname)) {
					double subtotal = num * pprice;
					cartitem.setCartid(cart.getId());
					cartitem.setPname(pname);
					cartitem.setCount(num);
					cartitem.setSubtotal(subtotal);
					cartitem.setSid(sid);
					cartitem.setPid(pid);
					cartitem.setPpic(ppic);
					cartitem.setPprice(pprice);
					cart.setTotal(cart.getTotal()+ subtotal);
					cartitemList.add(cartitem);
					
					//保存购物车
					Integer cartresult = cartService.updateCartById(cart);
					//保存购物项
					Integer itemresult = cartService.addCartItem(cartitem);
					
					if(cartresult == 1 && itemresult == 1){
						return GdResult.ok();
					}else{
						cart.setTotal(cart.getTotal() - subtotal);
						CartOrderUtil.deleteCartItemByid(cartitemList, cartitem.getId());
						return GdResult.build(500, "添加失败");
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return GdResult.build(500, "添加失败");
		}
		
		
		
		return GdResult.build(500, "添加失败");
	}

	
	
	@RequestMapping("/deleteCartItemById/{id}")
	@ResponseBody
	public Object deleteCartItemById(@PathVariable Integer id,HttpServletRequest request){
		Integer r = 0;
		r = cartService.deleteCartItemById(id);
		if(r == 0){
			return GdResult.build(500, "删除失败");
		}else if(r == 1){
			@SuppressWarnings("unchecked")
			List<TCartitem> cartitemList =  (List<TCartitem>) request.getSession().getAttribute("cartitemList");
			TCart cart = (TCart) request.getSession().getAttribute("cart");
			
			//更新session中的购物车
			TCartitem cartitem = CartOrderUtil.getCartitemById(cartitemList, id);
			if(cartitem != null){
				cart.setTotal(cart.getTotal() - cartitem.getSubtotal());
				cartService.updateCartById(cart);
			}
			//删除session中的购物项
			cartitemList = CartOrderUtil.deleteCartItemByid(cartitemList, id);
			//保存cartitem 和 cart 到session
			request.getSession().setAttribute("cartitemList",cartitemList );
			request.getSession().setAttribute("cart", cart);
			return GdResult.ok();
		}
		
		return GdResult.build(500, "删除失败");
	}
	
	
	@RequestMapping("/changeItemNum/{type}/{id}")
	@ResponseBody
	public Object changeItemNum(@PathVariable String type,@PathVariable Integer id,HttpServletRequest request){
		Integer cartItemResult = 0;
		Integer cartResult = 0;
		@SuppressWarnings("unchecked")
		List<TCartitem> list = (List<TCartitem>) request.getSession().getAttribute("cartitemList");
		TCart cart = (TCart) request.getSession().getAttribute("cart");
		TCartitem tCartitem = CartOrderUtil.getCartitemById(list, id);
		if(type.equals("minus")){
			tCartitem.setCount(tCartitem.getCount()-1);
			tCartitem.setSubtotal(tCartitem.getSubtotal()-tCartitem.getPprice());
			cart.setTotal(cart.getTotal()-tCartitem.getPprice());
			cartItemResult = cartService.updateCartItem(tCartitem);
			cartResult = cartService.updateCartById(cart);
			if(cartItemResult == 1 && cartResult == 1){
				return GdResult.ok();
			} 
		}
		if(type.equals("add")){
			tCartitem.setCount(tCartitem.getCount()+1);
			tCartitem.setSubtotal(tCartitem.getSubtotal()+tCartitem.getPprice());
			cart.setTotal(cart.getTotal()+tCartitem.getPprice());
			cartItemResult = cartService.updateCartItem(tCartitem);
			cartResult = cartService.updateCartById(cart);
			if(cartItemResult == 1 && cartResult == 1){
				return GdResult.ok();
			}
		}
		return GdResult.build(500, "操作失败");
	}
	
	/** 
	 * @Title: addCartItem 
	 * @Description: 添加商品。商品存在 修改数量
	 * @param list
	 * @param cartitem
	 * @return      
	 * @throws 
	 */
	public static List<TCartitem> addCartItem(List<TCartitem> list,TCartitem cartitem){
		Boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			if(cartitem.getPid().equals(list.get(i).getPid())){
				list.get(i).setCount(cartitem.getCartid()+list.get(i).getCartid());
				list.get(i).setSubtotal(cartitem.getSubtotal()+list.get(i).getSubtotal());
				flag = true;
			}
		}
		if(!flag){
			list.add(cartitem);
		}
		return list;
	}
	/** 
	 * @Title: castToCart 
	 * @Description: 购物车转换为页面显示实体
	 * @param cartitems
	 * @param cart
	 * @return      
	 * @throws 
	 */
	public  List<CartPojo> castToCart(List<TCartitem> cartitems){
		if(cartitems == null || cartitems.size() < 1){
			List<CartPojo> list = new ArrayList<>();
			return list;
		}
			
		List<CartPojo> cartPojoList = new ArrayList<>();
		Iterator<TCartitem> iterator = cartitems.iterator();
		Integer sid = cartitems.get(0).getSid();
		CartPojo c = new CartPojo();
		c.setStoreinfo(storeService.getStoreInfoId(sid));
		List<TCartitem> list  = new ArrayList<>();
		c.settCartitemList(list);
		cartPojoList.add(c);
		
		while (iterator.hasNext()) {
			
			TCartitem cartitem = iterator.next();
			//sid = cartitem.getSid();
			if(cartitem.getSid() == sid){
				CartPojo cartPojo = cartPojoList.get(cartPojoList.size()-1);
				cartPojo.gettCartitemList().add(cartitem);
				iterator.remove();
			}			
			if(cartitem.getSid() != sid){
				sid = cartitem.getSid();
				List<TCartitem> itemList = new ArrayList<>();
				CartPojo cartPojo = new CartPojo();
				itemList.add(cartitem);
				cartPojo.setStoreinfo(storeService.getStoreInfoId(cartitem.getSid()));
				cartPojo.settCartitemList(itemList);
				cartPojoList.add(cartPojo);
				iterator.remove();
			}
		}
		return cartPojoList;
	}
	
}
