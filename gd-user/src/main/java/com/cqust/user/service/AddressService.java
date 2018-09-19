package com.cqust.user.service;

import java.util.List;

import com.cqust.pojo.TAddress;

public interface AddressService {

	/** 
	 * @Title: getUserAddress 
	 * @Description: 根据用户ID查询用户所有收货地址
	 * @param id
	 * @return      所有收货地址
	 * @throws 
	 */
	List<TAddress> getUserAddressList(Integer id);
	
	
	/** 
	 * @Title: UpdateAddressById 
	 * @Description: 根据地址ID更新地址信息
	 * @param id	地址ID
	 * @return      
	 * @throws 
	 */
	Integer UpdateAddressById(TAddress address);
	
	
	/** 
	 * @Title: addUserAddress 
	 * @Description: 添加地址
	 * @param address
	 * @return      
	 * @throws 
	 */
	Integer addUserAddress(TAddress address);
	
	/** 
	 * @Title: updateAddress 
	 * @Description: 根据地址id查询地址
	 * @param address
	 * @return      
	 * @throws 
	 */
	TAddress findAddressById(Integer id );
	
	/** 
	 * @Title: deleteAddress 
	 * @Description: 根据id删除地址信息
	 * @param address
	 * @return      
	 * @throws 
	 */
	Integer deleteAddress(TAddress address);
	
	/** 
	 * @Title: defaulAddress 
	 * @Description: 更改默认地址
	 * @param newDefaulAddressId 新默认地址id
	 * @return      
	 * @throws 
	 */
	Integer updateDefaulAddress(Integer newDefaulAddressId);
}
