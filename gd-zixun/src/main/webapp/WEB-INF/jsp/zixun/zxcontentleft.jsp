<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="sub-left lev3-left">
	<div class="P_01"></div>
	<h1 class="news-tit">${zixun.title }</h1>
	<div class="P_02"></div>
	<div class="news-from">
		<span class="biaoqian">${zixun.createtime } | 来源:健康购 | 分享 </span> <span
			class="share"> <span onmouseover="share.setShare('', '');">
				<span class="jiathis_style"
				style="background: url(/statics/images/share_small.png) no-repeat scroll; width: 12px; height: 12px;"><a
					href="http://www.jiathis.com/share?uid=1609262"
					class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"
					style="background: url(/statics/images/share_small.png) no-repeat scroll; width: 12px; height: 12px;"></a>
			</span>
		</span>
		</span>
		<!--<p style="float:left;padding-left:15px;margin-top:-3px;"><iframe scrolling="no" frameborder="0" src="http://open.qzone.qq.com/like?url=http%3A%2F%2Fuser.qzone.qq.com%2F1600627902&amp;type=button_num&amp;width=168&amp;height=22&amp;style=2" allowtransparency="true" border="0" style="width:168px;height:22px;border:none;overflow:hidden;">qq</iframe></p>-->
		<div class="news-btn">
			<img src="/statics/images//ico_b.gif" class="fl" id="fbig" /><img
				src="/statics/images/ico_s.gif" class="fr" id="fsma" />
		</div>

	</div>
	<div class="new-cont" id="fbox">
		
		${zixun.infortext }
		
		<p class="back_home">
			<a href="http://localhost:8881"><img
				src="/statics/images/back-ico.gif" align="top" class="mr5">返回健康购首页&gt;&gt;</a>
		</p>
		<p class="clear"></p>
	</div>

	<div class="pagebox">
		<div class="aa">
			<div class="page">
				<p class="clear"></p>
			</div>
		</div>
	</div>
	<p class="clear"></p>
	<div class="rel">
		<table width="100%" cellpadding="0" cellspacing="0" align="center"
			class="f14 mt10">
			<tr>
				<td width="8%" align="left" valign="middle">分享到:</td>
				<td width="92%" align="left" valign="middle">
					<!-- JiaThis Button BEGIN -->
					<div class="jiathis_style">
						<a class="jiathis_button_qzone"></a> <a
							class="jiathis_button_tsina"></a> <a class="jiathis_button_tqq"></a>
						<a class="jiathis_button_weixin"></a> <a
							class="jiathis_button_renren"></a> <a
							href="http://www.jiathis.com/share?uid=1912411"
							class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
					</div> <script type="text/javascript">
						var jiathis_config = {
							data_track_clickback : 'true'
						};
					</script> <script type="text/javascript"
						src="http://v3.jiathis.com/code/jia.js?uid=1396587798855497"
						charset="utf-8"></script> <!-- JiaThis Button END -->
				</td>
			</tr>
		</table>
		<div class="mt10">
			<!-- UY BEGIN -->
			<div id="uyan_frame"></div>

			<script type="text/javascript"
				src="http://v2.uyan.cc/code/uyan.js?uid=1912411"></script>
			<!-- UY END -->
		</div>
		
	</div>
</div>
