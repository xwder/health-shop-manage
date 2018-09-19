package com.cqust.shop.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.cqust.pojo.TCartitem;

public class CartOrderUtil {
	
	/** 
	 * @Title: deleteCartItemByid 
	 * @Description: 根据购物项的ID删除购物项
	 * @param list
	 * @param cartItemId
	 * @return      
	 * @throws 
	 */
	public static List<TCartitem> deleteCartItemByid(List<TCartitem> list, Integer cartItemId){
		if(list == null || list.size() < 1 || cartItemId == null)
			return null;
		Iterator<TCartitem> iterator = list.iterator();
		while (iterator.hasNext()) {
			TCartitem cartitem = iterator.next();
			if(cartitem.getId().equals(cartItemId)){
				iterator.remove();
			}
		}
		return list;
	}
	
	/** 
	 * @Title: geTCartitemById 
	 * @Description: 根据购物项的id获取购物项
	 * @param list
	 * @param cartItemId
	 * @return      
	 * @throws 
	 */
	public static TCartitem getCartitemById(List<TCartitem> list, Integer cartItemId){
		for(int i = 0;i < list.size();i++){
			if (list.get(i).getId().equals(cartItemId)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	/** 
	 * @Title: getCartitemByPId 
	 * @Description: 根据商品ID查询session中的购物项
	 * @param list
	 * @param pid
	 * @return      
	 * @throws 
	 */
	public static  TCartitem getCartitemByPId(List<TCartitem> list, Integer pid){
		for(int i = 0;i < list.size();i++){
			if (list.get(i).getPid().equals(pid)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	/** 
	 * @Title: Sort 
	 * @Description: 购物车中商品根据商家id排序
	 * @param cartitems
	 * @return      
	 * @throws 
	 */
	public static  List<TCartitem> Sort(List<TCartitem> cartitems){
		if(cartitems == null || cartitems.size() < 1)
			return null;
		Collections.sort(cartitems,new Comparator<TCartitem>() {
			@Override
			public int compare(TCartitem o1, TCartitem o2) {
				
				return o1.getSid().compareTo(o2.getSid());
			}
			
		});
		for (TCartitem cartitem  : cartitems) {
			System.out.println("sid:  "+cartitem.getSid());
		}
		return cartitems;
	}
	
	
}
