package com.cqust.shop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqust.commom.pojo.PageBean;
import com.cqust.commom.utils.DateUtil;
import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TPcomment;
import com.cqust.shop.pojo.CommentPojo;
import com.cqust.shop.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping("/comments")
	public GdResult getComments(HttpServletRequest request){
		String strPage = request.getParameter("page");
		String strPid = request.getParameter("pid");
		Integer pid = 0;
		Integer page = 0;
		try {
			page = Integer.parseInt(strPage);
			pid = Integer.parseInt(strPid);
		} finally {
		}
		PageBean<TPcomment> pageBean = commentService.getPcommentPages(pid, page, 10);
		List<TPcomment> list = pageBean.getList();
		String html = "";
		if(pageBean != null && list != null && list.size() > 0){
			for(int i=0;i<list.size();i++){
				TPcomment pcomment = (TPcomment)list.get(i);
				html += "<tr> <td class='tm-col-master' style='width:550px;'> <div class='tm-rate-content'> <div class='tm-rate-fulltxt'>";
				html += pcomment.getComtext();
				html += "</div> </div> <div class='tm-rate-date' style='text-align: left;margin-left: 10px;'>";
				html += DateUtil.dateToString(new Date(), "yyyy-MM-dd");
				html += "</div> </td> <td class='col-meta'> <div class='rate-sku'> <span> ";
				for(int j=0;j<pcomment.getComlevel();j++){
					html += "<img src='/images/x2.png'>";
				}
				for(int n=0;n<5-pcomment.getComlevel();n++){
					html += "<img src='/images/x1.png'>";
				}
				html+="</span> <em class='level'>";
				if(pcomment.getComlevel() == 5){
					html+="好评";
				}else if(pcomment.getComlevel() == 3 || pcomment.getComlevel() ==4){
					html+="中评";
				}else if(pcomment.getComlevel() == 1 || pcomment.getComlevel() == 2){
					html+="差评";
				}
				html+="</em> </div> </td> <td class='col-author'><div class='rate-user-info'>";
				html+=pcomment.getUsername().charAt(0);
				html+="<span>***</span>";
				html+=pcomment.getUsername().charAt(pcomment.getUsername().length()-2);
				html+="<span>（匿名）</span> </div> </td> </tr>";
			}
		}
		String fy="";
		fy+="<div style='text-align: center;height: 20px;width: 140px;font-size: 15px;margin-top: 20px;float: left;'>第";
		fy+=pageBean.getPageNum();
		fy+="页/共";
		fy+=pageBean.getPages();
		fy+="页 </div> <div class='pagnation' id='pagnation' style='float: right; margin-right: 40px;'>";
		if(pageBean.getPageNum() != 1){
			fy+="<a href='javascript:void(0);' onclick='commentfy("+pid+","+(pageBean.getPageNum()-1)+")'  class='page-prev'>上一页</a>";
		}
		if(pageBean.getPageNum() == 1){
			fy+="<a href='javascript:void(0);' onclick='commentfy("+pid+","+(pageBean.getPageNum())+")'  class='page-prev'>上一页</a>";
		}
		int nowpage = pageBean.getPageNum();
		for(int i=nowpage;i<pageBean.getList().size();i++){
			if(i == pageBean.getPageNum()){
				fy+="<a href='javascript:void(0);' onclick='commentfy("+pid+","+i+")'  class='current'>"+i+"</a>";
			}
			if(i != pageBean.getPageNum()){
				fy+="<a href='javascript:void(0);' onclick='commentfy("+pid+","+i+")'  class=''>"+i+"</a>";
			}
		}
		fy+="...";
		fy+="<a href='javascript:void(0);' onclick='commentfy("+pid+","+(pageBean.getPages())+")' >"+pageBean.getPages()+"</a>";
		if(pageBean.getPages() != pageBean.getPageNum()){
			fy+="<a href='javascript:void(0);' onclick='commentfy("+pid+","+(pageBean.getPageNum()+1)+")'  class='page-next'>下一页</a>";
		}
		if(pageBean.getPages() == pageBean.getPageNum()){
			fy+="<a href='javascript:void(0);' onclick='commentfy("+pid+","+(pageBean.getPageNum())+")'  class='page-next'>下一页</a>";
		}
		fy+="</div> <script> var pagnation=$('#pagnation'); $(document).on('keydown',function(event){ switch(event.keyCode){ case 37 : window.location.href = pagnation.find('.page-prev').attr('href');break; case 39 : window.location.href = pagnation.find('.page-next').attr('href');break } }); </script>";
		CommentPojo commentPojo = new CommentPojo();
		commentPojo.setFy(fy);
		commentPojo.setHtml(html);
		return GdResult.ok(commentPojo);
	}

}
