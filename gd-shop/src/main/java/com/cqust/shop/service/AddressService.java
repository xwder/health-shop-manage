package com.cqust.shop.service;

import com.cqust.pojo.TAddress;

public interface AddressService {
	
	/** 
	 * @Title: getDefaultAddress 
	 * @Description: 获取默认地址  默认地址 defauladdress 为 1
	 * @return       默认地址
	 * @throws 
	 */
	TAddress getDefaultAddress();
	
	/** 
	 * @Title: updateDefaultAddress 
	 * @Description: 修改默认地址
	 * @param id 新的默认地址id
	 * @return   
	 * @throws 
	 */
	Integer updateDefaultAddress(Integer id);
	
	/** 
	 * @Title: geTAddressById 
	 * @Description: 根据ID获取地址
	 * @param id
	 * @return      
	 * @throws 
	 */
	TAddress getAddressById(Integer id);

}
