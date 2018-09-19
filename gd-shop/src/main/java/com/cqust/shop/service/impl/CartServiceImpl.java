package com.cqust.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TCartMapper;
import com.cqust.mapper.TCartitemMapper;
import com.cqust.pojo.TCart;
import com.cqust.pojo.TCartExample;
import com.cqust.pojo.TCartExample.Criteria;
import com.cqust.pojo.TCartitem;
import com.cqust.pojo.TCartitemExample;
import com.cqust.shop.mapper.CartMapper;
import com.cqust.shop.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Autowired
	private TCartMapper tCartMapper;

	@Autowired
	private TCartitemMapper tCartItemMapper;

	@Override
	public TCart createCart(Integer uid) {
		TCart cart = new TCart();
		cart.setTotal(0.0);
		cart.setUserid(uid);
		cartMapper.createCart(cart);

		if (cart.getId() != 0) {
			return cart;
		}

		return null;
	}

	@Override
	public Integer updateCartById(TCart cart) {
		return tCartMapper.updateByPrimaryKey(cart);
	}

	@Override
	public Integer addCartItem(TCartitem cartItem) {
		TCartitemExample example = new TCartitemExample();
		com.cqust.pojo.TCartitemExample.Criteria criteria = example.createCriteria();

		criteria.andPidEqualTo(cartItem.getPid());
		List<TCartitem> list = tCartItemMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			TCartitem tCartitem = list.get(0);
			tCartitem.setCount(tCartitem.getCount() + cartItem.getCount());
			tCartitem.setSubtotal(cartItem.getSubtotal() + tCartitem.getSubtotal());
			return tCartItemMapper.updateByPrimaryKey(tCartitem);
		} else {
			return tCartItemMapper.insert(cartItem);
		}

	}

	@Override
	public TCart getCartByUId(Integer uid) {
		TCartExample example = new TCartExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid);

		List<TCart> list = tCartMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<TCartitem> geTCartitemListByCartId(Integer cartId) {
		TCartitemExample example = new TCartitemExample();
		com.cqust.pojo.TCartitemExample.Criteria criteria = example.createCriteria();
		criteria.andCartidEqualTo(cartId);
		List<TCartitem> cartitemList = tCartItemMapper.selectByExample(example);
		return cartitemList;
	}

	@Override
	public Integer deleteCartItemById(Integer id) {
		Integer result = tCartItemMapper.deleteByPrimaryKey(id);
		return result;
	}

	@Override
	public Integer updateCartItem(TCartitem cartitem) {
		
		return tCartItemMapper.updateByPrimaryKey(cartitem);
	}

}
