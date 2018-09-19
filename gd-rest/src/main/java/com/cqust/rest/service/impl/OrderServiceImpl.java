package com.cqust.rest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.pojo.OrderSelect;
import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.DateUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.mapper.TOrderMapper;
import com.cqust.mapper.TOrderitemMapper;
import com.cqust.mapper.TStoreinfoMapper;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TOrderitemExample;
import com.cqust.pojo.TOrderitemExample.Criteria;
import com.cqust.pojo.TStoreinfo;
import com.cqust.rest.dao.JedisClient;
import com.cqust.rest.mapper.CustomOrderMapper;
import com.cqust.rest.pojo.OrderInfo;
import com.cqust.rest.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderServiceImpl implements OrderService {

	@Value("${REDIS_ORDER_KEY}")
	private String REDIS_ORDER_KEY;

	@Value("${REDIS_ORDER_EXPIRE}")
	private Integer REDIS_ORDER_EXPIRE;

	@Value("${REDIS_STORE_KEY}")
	private String REDIS_STORE_KEY;

	@Value("${REDIS_STORE_EXPIRE}")
	private Integer REDIS_STORE_EXPIRE;

	@Autowired
	private JedisClient jedisClient;

	@Autowired
	private TOrderitemMapper orderItemMapper;

	@Autowired
	private TOrderMapper orderMapper;

	@Autowired
	private TStoreinfoMapper storeMapper;

	@Autowired
	private CustomOrderMapper customOrderMapper;

	@Override
	public GdResult getTOrderItemById(Integer id) {
		TOrderitem orderItem = orderItemMapper.selectByPrimaryKey(id);
		if (orderItem != null) {
			return GdResult.ok(orderItem);
		}
		return GdResult.build(400, "无此订单项！");
	}

	@Override
	public GdResult getStoreinfoById(Integer id) {
		try {
			// 添加缓存逻辑
			// 从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_STORE_KEY + ":" + id + ":base");
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				TStoreinfo storeinfo = JsonUtils.jsonToPojo(json, TStoreinfo.class);
				if (storeinfo != null) {
					return GdResult.ok(storeinfo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据商品id查询商品信息
		TStoreinfo storeinfo = storeMapper.selectByPrimaryKey(id);
		if (storeinfo != null) {
			try {
				// 把商品信息写入缓存
				jedisClient.set(REDIS_STORE_KEY + ":" + id + ":base", JsonUtils.objectToJson(storeinfo));
				// 设置key的有效期
				jedisClient.expire(REDIS_STORE_KEY + ":" + id + ":base", REDIS_STORE_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return GdResult.ok(storeinfo);
		}

		return GdResult.build(400, "无此商家信息！");
	}

	@Override
	public GdResult getOrderByid(Integer id) {
		try {
			// 添加缓存逻辑
			// 从缓存中取订单信息，订单id对应的信息
			String json = jedisClient.get(REDIS_ORDER_KEY + ":" + id + ":base");
			// 判断是否有值
			if (!StringUtils.isBlank(json)) {
				// 把json转换成java对象
				OrderInfo orderinfo = JsonUtils.jsonToPojo(json, OrderInfo.class);
				TOrder order = orderinfo.getOrder();
				if (order != null) {
					return GdResult.ok(order);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		OrderInfo orderInfo = new OrderInfo();
		TOrder order = orderMapper.selectByPrimaryKey(id);
		if (order != null) {
			List<TOrderitem> list = null;
			TOrderitemExample example = new TOrderitemExample();
			Criteria criteria = example.createCriteria();
			criteria.andOrderidEqualTo(id);
			list = orderItemMapper.selectByExample(example);
			if (list != null && list.size() > 0) {
				orderInfo.setOrder(order);
				orderInfo.setLsit(list);
			}
		}

		try {
			// 把订单信息写入缓存
			jedisClient.set(REDIS_ORDER_KEY + ":" + id + ":base", JsonUtils.objectToJson(orderInfo));
			// 设置key的有效期
			jedisClient.expire(REDIS_ORDER_EXPIRE + ":" + id + ":base", REDIS_ORDER_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (orderInfo.getOrder() != null) {
			return GdResult.ok(orderInfo.getOrder());
		}
		return GdResult.build(400, "无此订单信息！");
	}

	@Override
	public GdResult updateOrderItemStatus(TOrderitem orderitem) {
		if (orderitem != null) {
			try {
				// 设置key的有效期
				jedisClient.expire(REDIS_ORDER_EXPIRE + ":" + orderitem.getOrderid() + ":base", 0);
			} catch (Exception e) {
				e.printStackTrace();
				return GdResult.build(500, "修改失败！");
			}
		}
		int re = orderItemMapper.updateByPrimaryKeySelective(orderitem);
		if (re != 1) {
			return GdResult.build(500, "修改失败！");
		}
		Boolean flag = false;
		List<TOrderitem> list = null;

		TOrderitemExample example = new TOrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderitem.getOrderid());
		list = orderItemMapper.selectByExample(example);
		int status = 5;
		if (list != null && list.size() > 0) {
			for (TOrderitem tOrderitem : list) {
				if (tOrderitem.getStatus() != status) {
					flag = true;
				}
			}
		}
		if (!flag) {
			TOrder order = new TOrder();
			order.setId(orderitem.getOrderid());
			order.setOrderstates(5);
			int res = orderMapper.updateByPrimaryKeySelective(order);
			if (res != 1) {
				return GdResult.build(500, "修改失败！");
			}
		}
		return GdResult.ok();
	}

	@Override
	public PageBean<TOrder> listStoreOrderByOrderStatus(Integer sid, Integer orderstatus, Integer page,
			Integer pagesize) {
		if (pagesize == null) {
			pagesize = 10;
		}
		if (page == null) {
			page = 1;
		}
		Map<String, Integer> map = new HashMap<>();
		if (sid == null && orderstatus == null) {
			return null;
		}
		map.put("sid", sid);
		map.put("orderstatus", orderstatus);

		PageHelper.startPage(page, pagesize);
		List<TOrder> orders = customOrderMapper.listStoreOrderByOrderStatus(map);

		PageBean<TOrder> pageBean = new PageBean<>();
		pageBean.setList(orders);
		PageInfo<TOrder> pageInfo = new PageInfo<>(orders);
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setPageSize(pagesize);
		Integer t = (int) pageInfo.getTotal();
		if (t % (Integer) pagesize == 0) {
			pageBean.setPages(t / pagesize);
		} else {
			pageBean.setPages(t / pagesize);
		}
		pageBean.setPageNum(page);
		if (orders != null) {
			pageBean.setSize(orders.size());
		}
		return pageBean;
	}

	@Override
	public List<TOrderitem> listOrderItemsByOid(Integer oid) {
		TOrderitemExample example = new TOrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(oid);

		return orderItemMapper.selectByExample(example);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageBean<TOrder> listStoreOrderByOrderStatusAndDate(OrderSelect orderSelect) {
		if (orderSelect.getPagesize() == null) {
			orderSelect.setPagesize(10);
		}
		if (orderSelect.getPage() == null) {
			orderSelect.setPage(1);
		}
		@SuppressWarnings("rawtypes")
		Map map = new HashMap<>();
		map.put("sid", orderSelect.getSid());
		map.put("orderstatus", orderSelect.getOrderstatus());
		map.put("beginDate",DateUtil.dateToString(orderSelect.getBegindate(), "yyyy-MM-dd hh:mm:ss"));
		map.put("endDate",DateUtil.dateToString(orderSelect.getEnDate(), "yyyy-MM-dd hh:mm:ss"));
		return null;
	}

}
