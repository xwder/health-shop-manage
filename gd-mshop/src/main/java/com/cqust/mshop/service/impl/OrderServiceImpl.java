package com.cqust.mshop.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.HttpClientUtil;
import com.cqust.mapper.TOrderMapper;
import com.cqust.mapper.TOrderitemMapper;
import com.cqust.mshop.service.OrderService;
import com.cqust.pojo.TOrder;
import com.cqust.pojo.TOrderExample;
import com.cqust.pojo.TOrderExample.Criteria;
import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TOrderitemExample;
import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TStoreinfo;

@Service
public class OrderServiceImpl implements OrderService {

	// 服务基层url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	@Value("${ORDER_BY_ID}")
	private String ORDER_BY_ID;

	@Value("${ORDERITEM_BY_ID}")
	private String ORDERITEM_BY_ID;

	@Value("${STORE_BY_ID}")
	private String STORE_BY_ID;

	@Value("${PCOMMENT_ORDERITEMID}")
	private String PCOMMENT_ORDERITEMID;

	@Autowired
	private TOrderMapper orderMapper;

	@Autowired
	private TOrderitemMapper orderItemMapper;

	@Override
	public List<TOrder> ordersBySid(Integer sid, Integer status) {
		TOrderExample example = new TOrderExample();
		Criteria criteria = example.createCriteria();
		if (status != 0) {
			criteria.andOrderstatesEqualTo(status);
		}
		criteria.andStoreidEqualTo(sid);
		return orderMapper.selectByExample(example);
	}

	@Override
	public List<TOrderitem> orderItemsByOid(Integer oid) {
		TOrderitemExample example = new TOrderitemExample();
		com.cqust.pojo.TOrderitemExample.Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(oid);
		List<TOrderitem> list = orderItemMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer updateOrder(Integer id, Integer status) {
		List<TOrderitem> list = orderItemsByOid(id);
		if (list != null & list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TOrderitem orderitem = new TOrderitem();
				orderitem.setId(list.get(i).getId());
				orderitem.setStatus(status);
				int r = orderItemMapper.updateByPrimaryKeySelective(orderitem);
				if (r == 0) {
					return 0;
				}
			}
			TOrder order = new TOrder();
			order.setOrderstates(status);
			order.setOrdertime(null);
			TOrderExample example = new TOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			int r = orderMapper.updateByExampleSelective(order, example);
			if (r == 1) {
				return 1;
			}
		}
		return null;
	}

	@Override
	public TOrderitem getTOrderItemById(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ORDERITEM_BY_ID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TOrderitem.class);
				if (gdResult.getStatus() == 200) {
					return (TOrderitem) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public TStoreinfo getStoreinfoById(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + STORE_BY_ID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TStoreinfo.class);
				if (gdResult.getStatus() == 200) {
					return (TStoreinfo) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public TOrder getOrderByid(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ORDER_BY_ID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TOrder.class);
				if (gdResult.getStatus() == 200) {
					return (TOrder) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public TPcomment geTPcommentByOrderItemId(Integer id) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + PCOMMENT_ORDERITEMID + id);
			if (!StringUtils.isBlank(json)) {
				GdResult gdResult = GdResult.formatToPojo(json, TPcomment.class);
				if (gdResult.getStatus() == 200) {
					return (TPcomment) gdResult.getData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public List<TOrder> getOrdersBettwon(Integer status,Date beginDate, Date endDate) {
		TOrderExample example = new TOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrdertimeBetween(beginDate, endDate);
		if(status != 0){
			criteria.andOrderstatesEqualTo(status);
		}
		List<TOrder> list = orderMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer updateOrderStatus(Integer sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
