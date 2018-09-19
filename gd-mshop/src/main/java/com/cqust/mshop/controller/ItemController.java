package com.cqust.mshop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.pojo.FileUploadResult;
import com.cqust.commom.utils.GdResult;
import com.cqust.commom.utils.JsonUtils;
import com.cqust.mshop.pojo.CustomProduct;
import com.cqust.mshop.pojo.ItemCollocationPojo;
import com.cqust.mshop.service.FileUploadService;
import com.cqust.mshop.service.ItemService;
import com.cqust.mshop.util.ProductCollocationUtil;
import com.cqust.mshop.util.ProductUtil;
import com.cqust.pojo.TCategory;
import com.cqust.pojo.TItemcollocation;
import com.cqust.pojo.TProduct;
import com.cqust.pojo.TStoreinfo;

@Controller
@RequestMapping("/manager/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping("/itemlist")
	@ResponseBody
	public List<CustomProduct> itemList(HttpServletRequest request) {
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		List<TProduct> list = itemService.getAllItem(storeinfo.getId());
		List<CustomProduct> customProducts = ProductUtil.productConvert(list);
		return customProducts;
	}

	@RequestMapping("/itemlistpage")
	public ModelAndView itemListpage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/itemlist");
		return modelAndView;
	}

	@RequestMapping("/addpage")
	public ModelAndView additemPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<TCategory> categoryList = itemService.productCategoryList();
		modelAndView.setViewName("/addproduct");
		modelAndView.addObject("categoryList", categoryList);
		return modelAndView;
	}

	@RequestMapping("/issell/{id}/{type}")
	@ResponseBody
	public GdResult issell(@PathVariable Integer id, @PathVariable Integer type) {
		Integer r = itemService.productSell(id, type);
		if (r == 1) {
			return GdResult.ok();
		}
		return GdResult.build(400, "修改失败！");
	}

	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public ModelAndView additem(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error");
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		if (storeinfo == null) {
			modelAndView.setViewName("/error");
			return modelAndView;
		}
		TProduct tProduct = new TProduct();
		String pname = request.getParameter("pname");
		String pms = request.getParameter("pms");
		String strPrice = request.getParameter("price");
		String strPstock = request.getParameter("pstock");
		String desc = request.getParameter("desc");
		String ptype = request.getParameter("ptype");
		String strDpItem = request.getParameter("dpitem");
		double price = 0;
		int pstock = 0;
		try {
			price = Double.parseDouble(strPrice);
			pstock = Integer.parseInt(strPstock);
		} catch (Exception e) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg", "数据错误！");
			return modelAndView;
		}
		tProduct.setStoreid(storeinfo.getId());
		tProduct.setPname(pname);
		tProduct.setPms(pms);
		tProduct.setPprice(price);
		tProduct.setPstock(pstock);

		if (file.getSize() <= 0) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg", "请上传商品图片！");
			return modelAndView;
		}

		if (file.getSize() != 0) {
			String fileName = file.getOriginalFilename();

			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			String imgExt = "JPEG|jpeg|JPG|jpg|GIF|gif|BMP|bmp|PNG|png)";
			imgExt.contains(suffix);
			if (imgExt.indexOf(suffix) < 0) {
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", "商品图片错误！！");
				return modelAndView;
			}
			FileUploadResult fileUploadResult = fileUploadService.uploadShopPicture(file);
			if (fileUploadResult.getStatus() != 200) {
				if (imgExt.indexOf(suffix) < 0) {
					modelAndView.setViewName("/error");
					modelAndView.addObject("msg", "商品图片错误！！");
					return modelAndView;
				}
			}
			String url = fileUploadResult.getFileUrl();
			tProduct.setPpic(url);
			tProduct.setPdesc(desc);
			tProduct.setPcreattime(new Date());
			tProduct.setIsSell(1);
			tProduct.setPsellnum(0);
			tProduct.setPtype(ptype);
			tProduct.setIsHot(1);
			Integer r = itemService.addProduct(tProduct);
			if (r == null) {
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", "商品添加失败！！");
				return modelAndView;
			}
			int pid = tProduct.getId();
			// 保存搭配商品信息
			TItemcollocation itemcollocation = new TItemcollocation();
			itemcollocation.setPid(pid);
			String collocation = ProductCollocationUtil.productCollocation(strDpItem);
			itemcollocation.setCollocation(collocation);

			int result = itemService.addProductCollocation(itemcollocation);

			if (r == 0 || result == 0) {
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", "商品添加失败！！");
				return modelAndView;
			}
			modelAndView.setViewName("/itemlist");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/updateitem", method = RequestMethod.POST)
	public ModelAndView updateitem(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error");
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		if (storeinfo == null) {
			modelAndView.setViewName("/error");
			return modelAndView;
		}
		TProduct tProduct = new TProduct();
		String pname = request.getParameter("pname");
		String pms = request.getParameter("pms");
		String strPrice = request.getParameter("price");
		String strPstock = request.getParameter("pstock");
		String desc = request.getParameter("desc");
		String ptype = request.getParameter("ptype");
		String strDpItem = request.getParameter("dpitem");
		String strPid = request.getParameter("pid");
		double price = 0;
		int pstock = 0;
		int pid = 0;
		try {
			price = Double.parseDouble(strPrice);
			pstock = Integer.parseInt(strPstock);
			pid = Integer.parseInt(strPid);
		} catch (Exception e) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg", "单价、库存数据错误！");
			return modelAndView;
		}
		tProduct.setStoreid(storeinfo.getId());
		tProduct.setPname(pname);
		tProduct.setPms(pms);
		tProduct.setPprice(price);
		tProduct.setPstock(pstock);
		tProduct.setId(pid);

		if (file.getSize() != 0) {
			String fileName = file.getOriginalFilename();

			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			String imgExt = "JPEG|jpeg|JPG|jpg|GIF|gif|BMP|bmp|PNG|png)";
			imgExt.contains(suffix);
			if (imgExt.indexOf(suffix) < 0) {
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", "商品图片类型错误！！");
				return modelAndView;
			}
			FileUploadResult fileUploadResult = fileUploadService.uploadShopPicture(file);
			if (fileUploadResult.getStatus() != 200) {
				modelAndView.setViewName("/error");
				modelAndView.addObject("msg", "商品图片类型错误！！");
				return modelAndView;
			}
			String url = fileUploadResult.getFileUrl();
			tProduct.setPpic(url);
		}
		tProduct.setPdesc(desc);
		tProduct.setPcreattime(new Date());
		tProduct.setIsSell(1);
		
		tProduct.setPtype(ptype);
		tProduct.setIsHot(1);
		Integer r = itemService.updateProduct(tProduct);
		if (r == null) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg", "商品修改失败！！");
			return modelAndView;
		}

		// 保存搭配商品信息
		TItemcollocation itemcollocation = new TItemcollocation();
		itemcollocation.setPid(pid);
		String collocation = ProductCollocationUtil.productCollocation(strDpItem);
		itemcollocation.setCollocation(collocation);

		int result = itemService.updateItemCollocationByPid(itemcollocation);

		if (r == 0 || result == 0) {
			modelAndView.setViewName("/error");
			modelAndView.addObject("msg", "商品修改失败！！");
			return modelAndView;
		}
		modelAndView.setViewName("/itemlist");

		return modelAndView;
	}

	@RequestMapping("/getitem/{pid}")
	public ModelAndView getitemByPid(@PathVariable Integer pid, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<TCategory> categoryList = itemService.productCategoryList();

		TProduct item = itemService.getProductByPid(pid);
		TItemcollocation itemcollocation = itemService.getItemcollocationByPid(pid);
		if(itemcollocation != null ){
			String strCollocation = itemcollocation.getCollocation();
			ItemCollocationPojo pojo = JsonUtils.jsonToPojo(strCollocation, ItemCollocationPojo.class);
			List<String> list = pojo.getList();
			
			String collocation = "";
			if (list != null & list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					collocation += (" " + list.get(i) + " ");
				}
			}
			modelAndView.addObject("collocation", collocation);
		}

		modelAndView.addObject("categoryList", categoryList);
		modelAndView.addObject("item", item);

		modelAndView.setViewName("/editproduct");
		return modelAndView;
	}

	@RequestMapping("/itemliststatuspage/{status}")
	public ModelAndView itemliststatusPage(@PathVariable Integer status, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if (status == 0) {
			modelAndView.addObject("url", "/manager/item/itemliststatus/0");
			modelAndView.addObject("status",0);
		} else if (status == 1) {
			modelAndView.addObject("url", "/manager/item/itemliststatus/1");
			modelAndView.addObject("status",1);
		}
		modelAndView.setViewName("/itemliststatus");
		return modelAndView;
	}

	@RequestMapping("/itemliststatus/{status}")
	@ResponseBody
	List<CustomProduct> itemliststatus(@PathVariable Integer status,HttpServletRequest request) {
		TStoreinfo storeinfo = (TStoreinfo) request.getSession().getAttribute("storeinfo");
		List<TProduct> list = itemService.getItemListByStatus(status,storeinfo.getId());
		List<CustomProduct> customProducts = ProductUtil.productConvert(list);
		return customProducts;
	}

	@RequestMapping("/itemdetail/{pid}")
	public ModelAndView itemDetail(@PathVariable Integer pid) {
		ModelAndView modelAndView = new ModelAndView();
		TProduct item = itemService.getProductByPid(pid);
		List<TProduct> collocationList = itemService.getItemCollocations(pid);
		modelAndView.addObject("item", item);
		modelAndView.addObject("collocationList", collocationList);
		modelAndView.setViewName("/itemdetail");
		return modelAndView;
	}

}
