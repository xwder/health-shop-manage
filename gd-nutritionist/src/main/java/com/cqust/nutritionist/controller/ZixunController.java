package com.cqust.nutritionist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.utils.GdResult;
import com.cqust.nutritionist.pojo.ZiXunInfo;
import com.cqust.nutritionist.service.ZiXunService;
import com.cqust.pojo.TZxinfo;
import com.cqust.pojo.TZxtype;

@Controller
@RequestMapping("/zixun")
public class ZixunController {

	@Autowired
	private ZiXunService ziXunService;

	/**
	 * 获取资讯类型
	 * @Title: getzxtype 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getzxtype")
	@ResponseBody
	public List<TZxtype> getzxtype(){
		return ziXunService.getzxtype();
	}
		
	/**
	 * 获取全部资讯
	 * @Title: getzixuninfos 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getzixuninfos/{page}/{pagesize}/{name}")
	@ResponseBody
	public List<ZiXunInfo> getzixuninfos(@PathVariable Integer page,@PathVariable Integer pagesize,@PathVariable String name) {
		 return ziXunService.getzixuninfos(page, pagesize, null, name);		
	}
	
	/**
	 * 根据资讯类型获取资讯
	 * @Title: getzxinfosbytype 
	 * @Description: TODO
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getzixuninfos/{page}/{pagesize}/{type}/{name}")
	@ResponseBody
	public List<ZiXunInfo> getzxinfosbytype(@PathVariable Integer page,@PathVariable Integer pagesize,@PathVariable Integer type,@PathVariable String name){
		 return ziXunService.getzixuninfos(page, pagesize, type, name);
	}
			
	/**
	 * 获取某一条资讯
	 * @Title: getSinglezixun 
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/getsinglezixun/{id}")
    @ResponseBody
    public ZiXunInfo getsinglezixun(@PathVariable Integer id){
		return ziXunService.getSinglezixun(id);
	}
		
	/**
	 * 添加资讯
	 * @Title: addzixun
	 * @Description: TODO
	 * @param id
	 * @return      
	 * @throws
	 */
	@RequestMapping("/addzixun")
	@ResponseBody
	public GdResult addzixun(HttpServletRequest httpServletRequest){
		TZxinfo record = new TZxinfo();
		record.setTitle(httpServletRequest.getParameter("title"));
		record.setInfortext(httpServletRequest.getParameter("infortext"));
		record.setAuthor(httpServletRequest.getParameter("author"));
		record.setZxtypeid(Integer.parseInt(httpServletRequest.getParameter("zxtypeid")));
        try {
			record.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("createtime")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        try {
			record.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("updatetime")));
		} catch (ParseException e) {		
			e.printStackTrace();
		}	
		return ziXunService.addzixun(record);
	}	
	
	/**
	 * 修改资讯
	 * @Title: updatezixun 
	 * @Description: TODO
	 * @param httpServletRequest
	 * @return      
	 * @throws
	 */
	@RequestMapping("/updatezixun")
	@ResponseBody
	public GdResult updatezixun(HttpServletRequest httpServletRequest){
		TZxinfo record = new TZxinfo();
		record.setId(Integer.parseInt(httpServletRequest.getParameter("id")));
		record.setTitle(httpServletRequest.getParameter("title"));
		record.setInfortext(httpServletRequest.getParameter("infortext"));	
        try {
			record.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(httpServletRequest.getParameter("updatetime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ziXunService.updatezixun(record);
	}	
    /**
     * 根据id删除某一条资讯
     * @Title: delzixun 
     * @Description: TODO
     * @param id
     * @return      
     * @throws
     */
	@RequestMapping("/delzixun/{id}")
	@ResponseBody
	public GdResult delzixun(@PathVariable Integer id){
		return ziXunService.delzixun(id);
	}
	
}
