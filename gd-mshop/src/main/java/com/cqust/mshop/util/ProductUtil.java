package com.cqust.mshop.util;

import java.util.ArrayList;
import java.util.List;

import com.cqust.mshop.pojo.CustomProduct;
import com.cqust.pojo.TProduct;

public class ProductUtil {
	
	public static List<CustomProduct> productConvert(List<TProduct> list ){
		if(list == null || list.size() <=0){
			return null;
		}
		List<CustomProduct> customProducts = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			CustomProduct customProduct= new CustomProduct();
			TProduct product = list.get(i);
			customProduct.setId(product.getId());
			customProduct.setStoreid(product.getStoreid());
			customProduct.setPname(product.getPname());
			customProduct.setPms(product.getPms());
			customProduct.setPprice(product.getPprice());
			customProduct.setPpic(product.getPpic());
			customProduct.setPdesc(product.getPdesc());
			customProduct.setPcreattime(product.getPcreattime());
			customProduct.setPstock(product.getPstock());
			customProduct.setPsellnum(product.getPsellnum());
			customProduct.setPtype(product.getPtype());
			customProduct.setIsSell(product.getIsSell());
			if(product.getIsSell() == 1){
				customProduct.setStrIsSell("已上架");
			}if(product.getIsSell() == 0){
				customProduct.setStrIsSell("已下架");
			}
			customProducts.add(customProduct);
		}
		return customProducts;
	}

}
