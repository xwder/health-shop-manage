<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<div style="margin: 0 auto; text-align:">
	<div class="modal-body">
		<form class="form-horizontal" method="POST"
			action="/manager/item/updateitem" enctype="multipart/form-data"
			id="updateform">
			<fieldset>
				<div id="legend" class="">
					<legend>添加商品</legend>
					<input name="pid" value="${item.id }" type="hidden"/>
				</div>

				<div class="control-group">

					<!-- Text input-->
					<label class="control-label" for="input01">商品名称</label>
					<div class="controls">
						<input type="text" name="pname" id="pname"  placeholder="商品名称"
							value="${item.pname }"
							class="input-xlarge" style="width: 480px;">
					</div>
				</div>

				<div class="control-group">

					<!-- Textarea -->
					<label class="control-label">短描述</label>
					<div class="controls">
						<div class="textarea">
							<textarea type="" name="pms" id="pms" class=""
								style="width: 480px; height: 80px;">
								${item.pms }
							</textarea>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">商品图片</label>
					<div >
						<img alt="" src="${item.ppic }" style="width:200px;height: 200px;">
					</div>
					<!-- File Upload -->
					<div class="controls">
						<input class="input-file" name="file" id="fileInput" type="file"
							style="width: 480px;">
					</div>
				</div>

				<div class="control-group">

					<!-- Text input-->
					<label class="control-label" for="input01">商品价格</label>
					<div class="controls">
						<input type="number" name="price" id="price" placeholder="商品价格"
							value="${item.pprice }"
							class="input-xlarge" style="width: 480px;"> 
							
							<input type="hidden" name="desc" id="desc">
					</div>
				</div>

				<div class="control-group">

					<!-- Text input-->
					<label class="control-label" for="input01">商品库存</label>
					<div class="controls">
						<input type="number" id="pstock" name="pstock" placeholder="商品库存"
							value="${item.pstock }"
							class="input-xlarge" style="width: 480px;">
					</div>
				</div>
				
				<div class="control-group">

					<!-- Text input-->
					<label class="control-label" for="input01">搭配商品编号(多个空格隔开)</label>
					<div class="controls">
						<input type="text" id="pstock" name="dpitem" placeholder="搭配商品编号(多个空格隔开)"
							value="${collocation}"
							class="input-xlarge" style="width: 480px;">
					</div>
				</div>

				<div class="control-group">
					<!-- Select Basic -->
					<label class="control-label">商品分类</label>
					<div class="controls">
						<select class="input-xlarge" name="ptype" id="selectptype">
							<c:if test="${categoryList != null }">
								<c:forEach var="category" items="${ categoryList}">
									<option value="${category.categoryname }">${category.categoryname }</option>
								</c:forEach>
							</c:if>

						</select>
					</div>
						<input type="hidden" id="itemtype_" value="${item.ptype}"/>
				        <script type="text/javascript">
					        	var itemtype_ = $("#itemtype_").val();
						      	$("#selectptype").val(itemtype_);
						</script>
				</div>
				 <code id="itempdesc" style="display:none;">
      					  ${item.pdesc }
   				 </code>
			</fieldset>
			<!-- 加载编辑器的容器 -->
			<script id="container" name="content" type="text/plain">
   						  
   			</script>
			<!-- 配置文件 -->
			<script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
			<!-- 编辑器源码文件 -->
			<script type="text/javascript" src="/ueditor/ueditor.all.js"></script>
			<!-- 实例化编辑器 -->
			<script type="text/javascript">
				var ue = UE.getEditor('container', {
					autoClearinitialContent : false,
					elementPathEnabled : false,
					initialFrameWidth : 910,
					initialFrameHeight : 600
				});
				UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
				UE.Editor.prototype.getActionUrl = function(action) {
					if (action == 'uploadimage' || action == 'uploadscrawl'
							|| action == 'uploadimage') {
						return '/manager/uploaditemimage';
					} else {
						return this._bkGetActionUrl.call(this, action);
					}
				}
			</script>
			<div class="controls" style="text-align: left;">
				<button type="button" id="updateitem" class="btn btn-default">修改商品</button>
			</div>
		</form>
	</div>
</div>
<script>
	$(function(){
	    window.setTimeout(setContent,500);//一秒后再调用赋值方法
	    window.setTimeout(getfoucs,1000);//一秒后再调用赋值方法
	});
	
	function getfoucs(){
		$("#pname").focus();
	}
	
	//给ueditor插入值
	function setContent(){
	    ue.execCommand('insertHtml', $('#itempdesc').html());
	}
	$("#updateitem").click(function() {
		var desc = ue.getPlainTxt();
		if (desc.length != null) {
			$("#desc").val(desc);
			if ($("#pname").val() == "") {
				alert("商品名为空！！");
				$("#pname").focus();
			} else if ($("#price").val() == "") {
				alert("价格为空！！");
				$("#price").focus();
			} else if ($("#pstock").val() == "") {
				alert("库存为空！！");
				$("#pstock").focus();
			} else if ($("#pms").val() == "") {
				alert("描述为空！！");
				$("#pms").focus();
			} else {
				$("#updateform").submit();
			}
		}

	});
	
</script>

