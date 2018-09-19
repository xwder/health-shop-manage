<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.min.css">
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-table.min.js"></script>
<script src="/js/bootstrap-table-zh-CN.js"></script>

<body>
	<div style="margin-top: 10px;">
		<div class="route_bg">
			<a>商品管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;
				<c:if test="${status == 0 }">上架商品</c:if>
				<c:if test="${status == 1 }">下架商品</c:if>
			
			</a>
		</div>
	
		<div style="margin-top: 10px; margin-bottom: -44px;" class="btn-group pull-left">
				<button type="button" class="btn btn-default btn-sm" id="btn_add">
					<span class="glyphicon glyphicon-plus"></span> 添加商品
				</button>
				<button  data-toggle="dropdown" class="btn btn-default btn-sm">
					  <span class="glyphicon glyphicon-circle-arrow-down"></span> 导出数据
				</button>
				          <ul class="dropdown-menu dropdown-light pull-right">
                    <li>
                        <a href="#" class="export-csv">
                            Save as CSV
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-tsv">
                            Save as TSV
                        </a>
                    </li>
                   <!--  <li>
                        <a href="#" class="export-pdf">
                            Save as PDF
                        </a>
                    </li> -->
                    <li>
                        <a href="#" class="export-png">
                            Save as PNG
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-excel">
                            Save as XLS
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-xlsx">
                            Save as XLSX
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-doc">
                            Save as DOC
                        </a>
                    </li>
                    <!--<li>-->
                    <!--<a href="#" class="export-powerpoint">-->
                    <!--Save as PPT-->
                    <!--</a>-->
                    <!--</li>-->
                    <li>
                        <a href="#" class="export-txt">
                            Save as TXT
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-xml">
                            Save as XML
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-sql">
                            Export to SQL
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-json">
                            Export to JSON
                        </a>
                    </li>
                </ul>
		</div>
		<table id="resulttable" data-toggle="table"
			data-url="${url}" data-pagination="true"
			data-striped="true" data-show-refresh="true" data-search="true"
			data-show-Columns="true" data-height="">
			<colgroup>
				<col style="width: 5%;">
				<col style="width: 20%;">
				<col style="width: 20%;">
				<col style="width: 5%;">
				<col style="width: 10%;">
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 20%;">
			</colgroup>
			<thead style="background-color: #003D79; color: #FFF">
				<tr>
					<th data-field="id" data-align="center" data-sortable="true">编号</th>
					<th data-field="pname" data-align="center" data-sortable="true" data-formatter="name">商品名称</th>
					<th data-field="pms" data-align="center" data-sortable="true" data-formatter="name">短描述</th>
					<th data-field="pprice" data-align="center" data-sortable="true">价格</th>
					<th data-field="pcreattime" data-align="center" data-sortable="true">上架时间</th>
					<th data-field="pstock" data-align="center" data-sortable="true">库存</th>
					<th data-field="psellnum" data-align="center" data-sortable="true">销量</th>
					<th data-field="ptype" data-align="center" data-sortable="true">类型</th>
					<th data-field="strIsSell" data-align="center" data-sortable="true">状态</th>
					<th data-field="" data-align="center" data-formatter="operate" >操作</th>
				</tr>
			</thead>
		</table>
 	</div>
</body>
<script src="/js/CustomExportJs/table.js"></script>
<script src="/js/tableExport/libs/pdfMake/pdfmake.min.js"></script>
<!-- <script src="/js/tableExport/libs/pdfMake/vfs_fonts.js"></script>
 -->
<script type="text/javascript" src="/js/tableExport/libs/FileSaver/FileSaver.min.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/jsPDF/jspdf.min.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/html2canvas/html2canvas.min.js"></script>
<script type="text/javascript" src="/js/tableExport/tableExport.js"></script>
<script src="/js/CustomExportJs/table-export.js"></script>
<script>
    jQuery(document).ready(function () {
        TableExport.init();
    });
</script>
<script>
	function operate(value, row, index) {
		var status = row.isSell;
		if(status == 1){
			return '<button type="button" class="btn btn-default btn-sm" onclick="xiajia('
			+ row.id + "," + status
			+ ')"> <span class="glyphicon glyphicon-arrow-down"></span>下架</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="edit('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>编辑</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>详情预览</button>';
		}
		if(status == 0){
			return '<button type="button" class="btn btn-default btn-sm" onclick="shangjia('
			+ row.id  + "," + status
			+ ')"> <span class="glyphicon glyphicon-arrow-up"></span>上架</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="edit('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>编辑</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>详情预览</button>';
		}
	}
	function name(value, row, index) {
		if (value != null && value.length > 20) {
			return value.substr(0, 24) + "......"
		}
		return value;
	}

	function xiangqing(id) {
		var url ="/manager/item/itemdetail/"+id+".html";
		window.location.href=url;
	}
	function xiajia(id,status) {
		$.ajax({
			url : "/manager/item/issell/" + id + "/" + 0,
			async : false,
			success : function(data) {
				if(data.status == 200){
					alert("下架成功！");
					url ="/manager/item/itemliststatuspage/1.html";
					window.location.href=url;
				}else{
					alert("下架失败！");
				}
			}
		});
	}
	function shangjia(id ) {
		$.ajax({
			url : "/manager/item/issell/" + id + "/" + 1,
			async : false,
			success : function(data) {
				 
					if(data.status == 200){
						alert("上架成功！");
						url ="/manager/item/itemliststatuspage/0.html";
						window.location.href=url;
					}else{
						alert("商家失败！");
					}
			}
		});
	}
	function edit(id) {
			var url = "/manager/item/getitem/"+ id +".html" ;
			window.location.href=url;
	}
	
	$("#btn_add").click(function(){
		window.location.href="/manager/item/addpage.html";
	});
	
</script>
</html>
