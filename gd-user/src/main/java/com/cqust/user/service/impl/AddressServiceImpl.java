package com.cqust.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqust.mapper.TAddressMapper;
import com.cqust.pojo.TAddress;
import com.cqust.pojo.TAddressExample;
import com.cqust.pojo.TAddressExample.Criteria;
import com.cqust.user.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private TAddressMapper tAddressMapper;

	@Override
	public List<TAddress> getUserAddressList(Integer id) {

		TAddressExample example = new TAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);

		List<TAddress> list = tAddressMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer UpdateAddressById(TAddress address) {
		int result = tAddressMapper.updateByPrimaryKeySelective(address);
		return result;
	}

	@Override
	public Integer addUserAddress(TAddress address) {
		Integer result = 0;
		TAddressExample example = new TAddressExample();
		List<TAddress> list = tAddressMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			result = tAddressMapper.insert(address);
		}else{
			address.setDefauladdress(1);
		}
		result = tAddressMapper.insert(address);
		return result;
	}

	@Override
	public TAddress findAddressById(Integer id) {
		TAddress address = tAddressMapper.selectByPrimaryKey(id);
		return address;
	}

	@Override
	public Integer deleteAddress(TAddress address) {
		Integer result = tAddressMapper.deleteByPrimaryKey(address.getId());
		return result;
	}

	@Override
	public Integer updateDefaulAddress(Integer newDefaulAddressId) {
		TAddressExample example = new TAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andDefauladdressEqualTo(1);
		List<TAddress> list = tAddressMapper.selectByExample(example);
		if(list.size() > 0 & list != null){
			TAddress address = list.get(0);
			address.setDefauladdress(0);
			Integer re = 0;
			re = tAddressMapper.updateByPrimaryKeySelective(address);
			if(re == 1){
				address = tAddressMapper.selectByPrimaryKey(newDefaulAddressId);
				if(address != null){
					address.setDefauladdress(1);
					return tAddressMapper.updateByPrimaryKeySelective(address);
				}
			}
		}
		return 0;
	}

}
