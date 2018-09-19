package com.cqust.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.PageBean;
import com.cqust.mapper.TOrderMapper;
import com.cqust.mapper.TOrderitemMapper;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TOrderitemExample;
import com.cqust.pojo.TOrderitemExample.Criteria;
import com.cqust.user.dao.JedisClient;
import com.cqust.user.mapper.CustomOrderMapper;
import com.cqust.user.pojo.OrderInfo;
import com.cqust.user.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CustomOrderMapper customOrderMapper;

	@Autowired
	private TOrderitemMapper orderitemMapper;

	@Autowired
	private TOrderMapper orderMapper;

	@Value("${REDIS_ORDER_EXPIRE}")
	private String REDIS_ORDER_EXPIRE;

	@Autowired
	private JedisClient jedisClient;

	@Override
	public PageBean<OrderInfo> getAllOrders(Integer pageNum, Integer pageSize, Integer orderStates, Integer uid) {

		PageBean<OrderInfo> result = new PageBean<>();

		if (pageSize <= 0) {
			pageSize = 3;
		}
		if (pageNum <= 0) {
			pageNum = 1;
		}
		List<OrderInfo> orderInfoList = new ArrayList<>();
		if (orderStates == 0) {
			PageHelper.startPage(pageNum, pageSize);
			List<TOrder> orderList = customOrderMapper.getAllOrders(uid);
			if (orderList != null && orderList.size() > 0) {

				for (int i = 0; i < orderList.size(); i++) {
					TOrder order = orderList.get(i);
					List<TOrderitem> orderitemList = null;
					TOrderitemExample example = new TOrderitemExample();
					Criteria criteria = example.createCriteria();
					criteria.andOrderidEqualTo(order.getId());
					orderitemList = (List<TOrderitem>) orderitemMapper.selectByExample(example);
					OrderInfo orderInfo = new OrderInfo();
					orderInfo.setOrder(order);
					orderInfo.setOrderitemList(orderitemList);
					orderInfoList.add(orderInfo);
				}

			}
			result.setList(orderInfoList);
			PageInfo<TOrder> pageInfo = new PageInfo<>(orderList);
			Integer t = (int) pageInfo.getTotal();
			result.setTotal(t);
			result.setPageSize(pageSize);
			if (t % pageSize == 0) {
				result.setPages(t / pageSize);
			} else {
				result.setPages(t / pageSize + 1);
			}
			result.setPageNum(pageNum);
		}

		if (orderStates == 1 || orderStates == 2 || orderStates == 3 || orderStates == 4 || orderStates == 5) {

			PageHelper.startPage(pageNum, pageSize);
			Map<String, Integer> map = new HashMap<>();
			map.put("orderStates", orderStates);
			map.put("uid", uid);
			List<TOrder> orderList = customOrderMapper.getOrdersByOrderStates(map);
			if (orderList != null && orderList.size() > 0) {
				for (int i = 0; i < orderList.size(); i++) {
					TOrder order = orderList.get(i);
					List<TOrderitem> orderitemList = null;
					TOrderitemExample example = new TOrderitemExample();
					Criteria criteria = example.createCriteria();
					criteria.andOrderidEqualTo(order.getId());
					orderitemList = (List<TOrderitem>) orderitemMapper.selectByExample(example);
					OrderInfo orderInfo = new OrderInfo();
					orderInfo.setOrder(order);
					orderInfo.setOrderitemList(orderitemList);
					orderInfoList.add(orderInfo);
				}

			}
			result.setList(orderInfoList);
			PageInfo<TOrder> pageInfo = new PageInfo<>(orderList);
			Integer t = (int) pageInfo.getTotal();
			result.setTotal(t);
			result.setPageSize(pageSize);
			if (t % pageSize == 0) {
				result.setPages(t / pageSize);
			} else {
				result.setPages(t / pageSize + 1);
			}
			result.setPageNum(pageNum);
		}

		return result;
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

	@Override
	public PageBean<OrderInfo> getallWwcOrderList(Integer uid, Integer page, Integer pagesize) {
		PageBean<OrderInfo> result = new PageBean<>();

		if (pagesize <= 0) {
			pagesize = 3;
		}
		if (page <= 0) {
			page = 1;
		}
		List<OrderInfo> orderInfoList = new ArrayList<>();

		PageHelper.startPage(page, pagesize);
		List<TOrder> orderList = customOrderMapper.getAllWwcOrders(uid);
		if (orderList != null && orderList.size() > 0) {
			
			for (int i = 0; i < orderList.size(); i++) {
				TOrder order = orderList.get(i);
				if(order.getOrderstates() != 5){
					List<TOrderitem> orderitemList = null;
					TOrderitemExample example = new TOrderitemExample();
					Criteria criteria = example.createCriteria();
					criteria.andOrderidEqualTo(order.getId());
					orderitemList = (List<TOrderitem>) orderitemMapper.selectByExample(example);
					OrderInfo orderInfo = new OrderInfo();
					orderInfo.setOrder(order);
					orderInfo.setOrderitemList(orderitemList);
					orderInfoList.add(orderInfo);
				}
			}

		}
		result.setList(orderInfoList);
		PageInfo<TOrder> pageInfo = new PageInfo<>(orderList);
		Integer t = (int) pageInfo.getTotal();
		result.setTotal(t);
		result.setPageSize(pagesize);
		if (t % pagesize == 0) {
			result.setPages(t / pagesize);
		} else {
			result.setPages(t / pagesize + 1);
		}
		result.setPageNum(page);

		return result;
	}
}
