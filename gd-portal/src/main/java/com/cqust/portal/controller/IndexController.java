package com.cqust.portal.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqust.commom.utils.IpUtils;
import com.cqust.pojo.THotsearch;
import com.cqust.pojo.TPicture;
import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.pojo.TProduct;
import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TUserinfo;
import com.cqust.portal.pojo.StoreType;
import com.cqust.portal.pojo.ZiXunInfo;
import com.cqust.portal.service.CarouseService;
import com.cqust.portal.service.HotSearchService;
import com.cqust.portal.service.ItemService;
import com.cqust.portal.service.PotalBrowseService;
import com.cqust.portal.service.StoreService;
import com.cqust.portal.service.ZiXunService;

/**
 * 
 * @ClassName: IndexController
 * @Description: 首页跳转Controller
 * @author Joe
 * @date 2017年3月6日 下午5:15:11
 *
 */
@Controller
public class IndexController {

	@Autowired
	private ZiXunService ziXunService;
	
	@Autowired
	private HotSearchService hotSearchService;
	
	@Autowired
	private CarouseService carouseService;
	
	@Autowired 
	private ItemService itemService;
	
	@Autowired
	private PotalBrowseService potalBrowseService;
	
	@Autowired
	private StoreService storeService;

	/** 
	 * @Title: showIndex 
	 * @Description: 显示首页
	 * @return      
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public ModelAndView showIndex(HttpServletRequest request) {
		
		TUserinfo userinfo = (TUserinfo) request.getSession().getAttribute("userinfo");
		
		HttpSession session = request.getSession();
		String sessionid = (String) session.getAttribute("sessionid");
		
		if(sessionid == null){
			TPotalbrowserecord tPotalbrowserecord = new TPotalbrowserecord();
			
			if(userinfo!= null){
				tPotalbrowserecord.setUsername(userinfo.getUsername());
				tPotalbrowserecord.setUid(userinfo.getId());
				tPotalbrowserecord.setUsertype(1);
			}else{
				tPotalbrowserecord.setUsername("游客");
				tPotalbrowserecord.setUid(0);
				tPotalbrowserecord.setUsertype(2);
			}
			tPotalbrowserecord.setBrowsetime(new Date());
			String  ipaddress = IpUtils.getIpAddr(request);
			tPotalbrowserecord.setUserip(ipaddress);
			try {
				potalBrowseService.addPotalBrowse(tPotalbrowserecord);
			} catch (Exception e) {
			}
			session.setAttribute("sessionid", session.getId());
		}
		 
		// 健康、季节资讯
		List<ZiXunInfo> healthinfoList = (List<ZiXunInfo>) session.getAttribute("healthinfoList");
		if(healthinfoList == null ){
			healthinfoList = ziXunService.getZXListByType(1, 1, 6);
			session.setAttribute("healthinfoList", healthinfoList);
		}
		
		List<ZiXunInfo> seasoninforList = (List<ZiXunInfo>) session.getAttribute("seasoninforList");
		if(seasoninforList == null ){
			seasoninforList = ziXunService.getZXListByType(2, 1, 6);
			session.setAttribute("seasoninforList", seasoninforList);
		}
		
		//热搜词列表
		List<THotsearch> hotSearchList = (List<THotsearch>) session.getAttribute("hotSearchList");
		if(hotSearchList == null ){
			hotSearchList = hotSearchService.getTHotSearchList();
			session.setAttribute("hotSearchList", hotSearchList);
		}		
		
		//轮播资讯
		List<TPicture> ziXunCarouseList = (List<TPicture>) session.getAttribute("ziXunCarouseList");
		if(ziXunCarouseList == null ){
			ziXunCarouseList = carouseService.getCarouseList("资讯");
			session.setAttribute("ziXunCarouseList", ziXunCarouseList);
		}
				
		List<TPicture> spCarouseList = (List<TPicture>) session.getAttribute("spCarouseList");
		if(spCarouseList == null ){
			spCarouseList = carouseService.getCarouseList("商品");
			session.setAttribute("spCarouseList", spCarouseList);
		}
		
		//热门商品
		List<TProduct> hotVeItemList = (List<TProduct>) request.getAttribute("hotVeItemList");
		if(hotVeItemList == null ){
			hotVeItemList = itemService.getHotItemListByType("VEGETABLES");
			session.setAttribute("hotVeItemList", hotVeItemList);
		}
		List<TProduct> hotMeatItemList = (List<TProduct>) session.getAttribute("hotMeatItemList");
		if(hotMeatItemList == null ){
			hotMeatItemList = itemService.getHotItemListByType("MEAT");
			session.setAttribute("hotMeatItemList", hotMeatItemList);
		}
		
		List<TProduct> hotCookedItemList = (List<TProduct>) session.getAttribute("hotCookedItemList");
		if(hotCookedItemList == null ){
			hotCookedItemList = itemService.getHotItemListByType("COOKERFOOD");
			session.setAttribute("hotCookedItemList", hotCookedItemList);
		}
		
		List<TProduct> hotGrainItemList = (List<TProduct>) session.getAttribute("hotGrainItemList");
		if(hotGrainItemList == null ){
			hotGrainItemList = itemService.getHotItemListByType("GRAIN");
			session.setAttribute("hotGrainItemList", hotGrainItemList);
		}
		
		List<TProduct> hotFruItemList = (List<TProduct>) session.getAttribute("hotFruItemList");
		if(hotFruItemList == null ){
			hotFruItemList = itemService.getHotItemListByType("FRUITS");
			session.setAttribute("hotFruItemList", hotFruItemList);
		}
				
		//店铺
		List<TStoreinfo> vagetablesstores = (List<TStoreinfo>) session.getAttribute("vagetablesstores");
		if(vagetablesstores == null){
			vagetablesstores = storeService.storeinfosByStype(StoreType.VAGETABLES_STORETYPE);
			session.setAttribute("vagetablesstores",vagetablesstores );
		}
		List<TStoreinfo> fruitsstores = (List<TStoreinfo>) session.getAttribute("fruitsstores");
		if(fruitsstores == null){
			fruitsstores = storeService.storeinfosByStype(StoreType.FRUITS_STORETYPE);
			session.setAttribute("fruitsstores",fruitsstores );
		}
		List<TStoreinfo> meatstores = (List<TStoreinfo>) session.getAttribute("meatstores");
		if(meatstores == null){
			meatstores = storeService.storeinfosByStype(StoreType.MEAT_STORETYPE);
			session.setAttribute("meatstores",meatstores );
		}
		List<TStoreinfo> cookedfoodstores = (List<TStoreinfo>) session.getAttribute("cookedfoodstores");
		if(cookedfoodstores == null){
			cookedfoodstores = storeService.storeinfosByStype(StoreType.COOKEDFOOD_STORETYPE);
			session.setAttribute("cookedfoodstores",cookedfoodstores );
		}
		List<TStoreinfo> grainstores = (List<TStoreinfo>) session.getAttribute("grainstores");
		if(grainstores == null){
			grainstores = storeService.storeinfosByStype(StoreType.GRAIN_STORETYPE);
			session.setAttribute("grainstores",grainstores );
		}
		List<TStoreinfo> comprehensivestores = (List<TStoreinfo>) session.getAttribute("comprehensivestores");
		if(comprehensivestores == null){
			comprehensivestores = storeService.storeinfosByStype(StoreType.COMPREHENSIVE_STORETYPE);
			session.setAttribute("comprehensivestores",comprehensivestores );
		}
		
		
		//商品分类
		List<TProduct> bestselleritems = (List<TProduct>) request.getAttribute("bestselleritems");
		if (bestselleritems == null) {
			bestselleritems = itemService.bestSellersItems();
			session.setAttribute("bestselleritems",bestselleritems );
		}
		List<TProduct> newestitems = (List<TProduct>) request.getAttribute("newestitems");
		if (newestitems == null) {
			newestitems = itemService.newestItems();
			session.setAttribute("newestitems",newestitems );
		}
		List<TProduct> commentitems = (List<TProduct>) request.getAttribute("commentitems");
		if (commentitems == null) {
			commentitems = itemService.commentItems();
			session.setAttribute("commentitems",commentitems );
		}
		List<TProduct> panicbuyitems = (List<TProduct>) request.getAttribute("panicbuyitems");
		if (panicbuyitems == null) {
			panicbuyitems = itemService.panicBuyItems();
			session.setAttribute("panicbuyitems",panicbuyitems );
		}
		List<TProduct> userlikeitems = (List<TProduct>) request.getAttribute("userlikeitems");
		if (userlikeitems == null) {
			if(userinfo != null){
				userlikeitems = itemService.userlikeItems(userinfo.getId());
			}else{
				userlikeitems = itemService.userlikeItems(0);
			}
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index");					
		return modelAndView;
	}

}
