<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />

<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<link href="/css/city-picker.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<div style="margin: 0 auto; text-align:">
	<div class="modal-body">
		<form class="form-horizontal" method="POST"
			action="/manager/store/updatestoreinfo" enctype="multipart/form-data"
			id="updateform">
			<fieldset>
				<div id="legend" class="">
					<legend>店铺信息管理</legend>
					<input type="hidden" name="id" value="${storeinfo.id}">
                    <input type="hidden" id="userid" name="userid" value="${userinfo.id}">
				</div>

				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">店主名</label>
					<div class="controls">
						<input type="text" name="sname" id="sname" value="${storeinfo.sname }"
							class="input-xlarge" style="width: 480px;" readonly="readonly">
					</div>
				</div>
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">身份证号码</label>
					<div class="controls">
						<input type="text" name="sid" id="sid" value="${storeinfo.sid }"
							class="input-xlarge" style="width: 480px;" readonly="readonly">
					</div>
				</div>
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">营业执照号码</label>
					<div class="controls">
						<input type="text" name="slicense" id="slicense" value="${storeinfo.slicense }"
							class="input-xlarge" style="width: 480px;" readonly="readonly">
					</div>
				</div>
				  <div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">店铺名</label>
					<div class="controls">
						<input type="text" name="storename" id="storename" value="${storeinfo.storename }"
							class="input-xlarge" style="width: 480px;" >
					</div>
				 </div>
				 <div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">手机</label>
					<div class="controls">
						<input type="text" name="sphone" id="sphone" value="${storeinfo.sphone }"
							class="input-xlarge" style="width: 480px;" >
					</div>
				 </div>
				 <div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">店铺地址</label>
					<div class="controls">
						 <div class="docs-methods">
							<div class="form-inline">
								<div id="distpicker">
									<div class="form-group" style="    margin-left: -5px;">
										<div style="position: relative;">
											<input id="city-picker3" name="sdz" class="form-control" readonly type="text" value="${storeinfo.sdz }" data-toggle="city-picker">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				 </div>
				 
				 <div class="control-group">
		          <label class="control-label">详细地址</label>
		          <div class="controls">
		            <div class="textarea">
		                  <textarea type="" class="" name="saddr" id="saddr" style="width: 480px;height: 50px;" > ${storeinfo.saddr }</textarea>
		            </div>
		          </div>
		        </div>
		        
		        <div class="control-group">
		          <!-- Select Basic -->
		          <label class="control-label">店铺类型</label>
		          <div class="controls">
		            <select class="input-xlarge" name="stype" id="stype" <c:if test="${storeinfo.stype == null}">value="6"</c:if>  <c:if test="${storeinfo.stype != null}">value="${storeinfo.stype}"</c:if>>
		            	<option value="蔬菜">蔬菜类店铺</option>
						<option value="水果">水果类店铺</option>
						<option value="肉类">肉类店铺</option>
						<option value="熟食">熟食类店铺</option>
						<option value="谷物">谷物类店铺</option>
						<option value="综合">综合类店铺</option>
				    </select>
		          </div>
		        </div>
		        
		        
		       	<div class="control-group">
					<label class="control-label">店铺logo图片</label>
					<div >
						<img alt="" src="${storeinfo.storelogoimg }" style="width:200px;height: 200px;">
					</div>
					<!-- File Upload -->
					<div class="controls">
						<input class="input-file" name="file" id="fileInput" type="file"
							style="width: 480px;">
					</div>
				</div>
 
			<div class="controls" style="text-align: left;">
				<button type="button" id="updatestoreinfo" class="btn btn-default">修改</button>
			</div>
		</form>
	</div>
</div>

	           
<input type="hidden" id="storetype_" value="${storeinfo.stype}"/>
<script type="text/javascript">
	var storetype = $("#storetype_").val();
	$("#stype").val(storetype);
	
	$("#updatestoreinfo").click(function() {
		if ($("#storename").val() == "") {
			alert("店铺名为空！！");
			$("#storename").focus();
		} else if ($("#sphone").val() == "") {
			alert("手机号为空！！");
			$("#sphone").focus();
		} else if ($("#sdz").val() == "") {
			alert("店铺地址为空！！");
			$("#sdz").focus();
		}else if ($("#saddr").val() == "") {
			alert("店铺详细地址为空！！");
			$("#saddr").focus();
		}else {
			$("#updateform").submit();
		}
});
</script>
<script src="/js/city-picker.data.js"></script>
<script src="/js/city-picker.js"></script>
<script src="/js/main.js"></script>
