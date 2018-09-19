<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
<link href="/css/address/city-picker.css" rel="stylesheet">
<link href="/css/address/main.css" rel="stylesheet">


	<div id="spulist-sortbar">
		<div class="m-sortbar">
			<div class="sort-row">
				<div class="sort-inner">
					<ul class="sorts">

						<li class="sort"><a class="J_Ajax link  first"
							data-url="sortbar" data-key="psort,vlist,app"
							data-value="commend,1,vproduct" data-anchor="J_relative"  
							title="综合排序" href="http://localhost:8883/list.html?itemtype=蔬菜">蔬菜类</a></li>
						<li class="sort"><a class="J_Ajax link  first"
							data-url="sortbar" data-key="psort,vlist,app"
							data-value="commend,1,vproduct" data-anchor="J_relative"  
							title="综合排序" href="http://localhost:8883/list.html?itemtype=水果">水果</a></li>
						<li class="sort"><a class="J_Ajax link  first"
							data-url="sortbar" data-key="psort,vlist,app"
							data-value="commend,1,vproduct" data-anchor="J_relative"  
							title="综合排序" href="http://localhost:8883/list.html?itemtype=肉类">肉类</a></li>
						<li class="sort"><a class="J_Ajax link  first"
							data-url="sortbar" data-key="psort,vlist,app"
							data-value="commend,1,vproduct" data-anchor="J_relative"  
							title="综合排序" href="http://localhost:8883/list.html?itemtype=熟食">熟食类</a></li>
						<li class="sort"><a class="J_Ajax link  first"
							data-url="sortbar" data-key="psort,vlist,app"
							data-value="commend,1,vproduct" data-anchor="J_relative"  
							title="综合排序" href="http://localhost:8883/list.html?itemtype=谷物">谷物</a></li>
							
							
						<li class="sort"><a class="J_Ajax link  first"
							data-url="sortbar" data-key="psort,vlist,app"
							data-value="commend,1,vproduct" data-anchor="J_relative"  
							title="综合排序" href="http://localhost:8883/list.html?">综合</a></li>

						<li class="sort"><a class="J_Ajax link active "
							data-url="sortbar" data-key="psort,vlist,app"
							data-value="_lw_quantity,1,vproduct" data-anchor="J_relative"
							  title="销量较高的产品在前"
							href="http://localhost:8883/list.html?itemtype=${itemtype }&sellnum=desc"
							data-spm-anchor-id="a230r.1.0.0">销量</a></li>

						<li class="sort"><a class="J_Ajax link  " data-url="sortbar"
							data-key="psort,vlist,app" data-value="_market_time,1,vproduct"
							data-anchor="J_relative"  title="最近上市的产品在前" href="http://localhost:8883/list.html?itemtype=${itemtype }&sssj=desc">上市时间</a>
						</li>

						<li class="sort"><a class="J_Ajax link  " data-url="sortbar"
							data-key="psort,vlist,app" data-value="_price,1,vproduct"
							data-anchor="J_relative"   title="价格较高的产品在前" href="http://localhost:8883/list.html?itemtype=${itemtype }&price=desc">价格从高到低</a>
						</li>

						<li class="sort"><a class="J_Ajax link  " data-url="sortbar"
							data-key="psort,vlist,app" data-value="price,1,vproduct"
							data-anchor="J_relative"   title="价格较低的产品在前" href="http://localhost:8883/list.html?itemtype=${itemtype }&price=asc">价格从低到高</a>
						</li>
						<li class="sort"> 
							<div class="docs-methods">
								<div class="form-inline">
										<div id="distpicker">
											<div class="form-group">
												<div style="position: relative;">
													<input id="city-picker3" class="form-control" readonly type="text" value="${sdz }" data-toggle="city-picker">
												</div>
											</div>
										</div>
									</div>
								</div>
						</li>
						<li class="sort"> 
							<button type="button" id="searchwithsdz" class="btn" style="margin-top:-3px;">按地点查询</button>
						</li>

					</ul>
			</div>
		</div>
	</div>
</div>
	
<script>
	$("#searchwithsdz").click(function(){
		var sdz = $("#city-picker3").val();
		var url = "http://localhost:8883/list.html?sdz="+sdz;
		location.href = url;
	});
</script>
<script src="/js/address/bootstrap.js"></script>
<script src="/js/address/city-picker.data.js"></script>
<script src="/js/address/city-picker.js"></script>
<script src="/js/address/main.js"></script>
 