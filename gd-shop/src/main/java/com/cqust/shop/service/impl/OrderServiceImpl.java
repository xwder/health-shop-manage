package com.cqust.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TOrderMapper;
import com.cqust.mapper.TOrderitemMapper;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TOrderitemExample;
import com.cqust.pojo.TOrderitemExample.Criteria;
import com.cqust.shop.dao.JedisClient;
import com.cqust.shop.mapper.OrderMapper;
import com.cqust.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TOrderMapper orderMapper;

	@Autowired
	private TOrderitemMapper orderitemMapper;
	
	@Autowired
	private OrderMapper myOrderMapper;
	
	@Value("${REDIS_ORDER_EXPIRE}")
	private String REDIS_ORDER_EXPIRE;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public Integer addOrderItem(List<TOrderitem> list) {
		int r = 0;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				r = orderitemMapper.insert(list.get(i));
				if (r == 0) {
					return 0;
				}
			}
		}
		return 1;
	}

	@Override
	public Integer addOrder(TOrder order) {

		return myOrderMapper.createOrder(order);
	}

	@Override
	public TOrder getOrderById(Integer id) {
		
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TOrderitem> getOrderitemListByOrderId(Integer orderid) {
		TOrderitemExample example = new TOrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderid);
		List<TOrderitem> list = orderitemMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public Integer updateOrder(Integer id, Integer status) {
		
		if (id != null) {
			try {
				// 设置key的有效期
				jedisClient.expire(REDIS_ORDER_EXPIRE + ":" + id + ":base", 0);
			} catch (Exception e) {
				e.printStackTrace();
				 ;
			}
		}
		
		List<TOrderitem> list = getOrderitemListByOrderId(id);
		if (list != null & list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TOrderitem orderitem = new TOrderitem();
				orderitem.setId(list.get(i).getId());
				orderitem.setStatus(status);
				int r = orderitemMapper.updateByPrimaryKeySelective(orderitem);
				if (r == 0) {
					return 0;
				}
			}
			TOrder order = new TOrder();
			order.setOrderstates(status);
			order.setOrdertime(null);
			order.setId(id);
			int r = orderMapper.updateByPrimaryKeySelective(order);
			if (r == 1) {
				return 1;
			}
		}
		return null;
	}

}
