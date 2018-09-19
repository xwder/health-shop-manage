package com.cqust.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TAddressMapper;
import com.cqust.pojo.TAddress;
import com.cqust.pojo.TAddressExample;
import com.cqust.pojo.TAddressExample.Criteria;
import com.cqust.shop.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private TAddressMapper addressMapper;

	@Override
	public TAddress getDefaultAddress() {
		TAddressExample example = new TAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andDefauladdressEqualTo(1);
		List<TAddress> list = addressMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer updateDefaultAddress(Integer id) {

		TAddress address = getAddressById(id);
		address.setDefauladdress(1);
		
		TAddress defaultAddress = getDefaultAddress();
		defaultAddress.setDefauladdress(0);
		
		Integer re = addressMapper.updateByPrimaryKey(address);
		Integer re2 = addressMapper.updateByPrimaryKey(defaultAddress);
		if (re == 1 && re2 == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public TAddress getAddressById(Integer id) {
		return addressMapper.selectByPrimaryKey(id);
	}

}
