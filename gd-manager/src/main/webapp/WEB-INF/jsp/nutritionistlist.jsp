<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css" type="text/css" media="screen">
<link rel="stylesheet" href="/css/bootstrap-editable.css" type="text/css" media="screen">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-editable.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-editable.js"></script>
 
<body>
	<div style="margin-top: 10px;"> 
		<div class="route_bg">
			<a>用户管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;
				商家管理
			</a>
		</div>
		<div style="margin-top: 10px; margin-bottom: -44px;" class="btn-group pull-left">
				 
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
                    <!-- <li>
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
			data-url="/nutritionist/nutritionistlist" data-pagination="true"
			data-striped="true" data-show-refresh="true" data-search="true"
			data-show-Columns="true" data-height="">
			<%-- <colgroup>
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 20%;">
			</colgroup> --%>
			<thead style="background-color: #003D79; color: #FFF">
				<tr>
					<th data-field="id" data-align="center" data-sortable="true" data-visible="false">ID</th>
					<th data-field="userid" data-align="center" data-sortable="true" data-visible="false">用户ID</th>
					<th data-field="username" data-align="center" data-sortable="false">姓名</th>
					<th data-field="uid" data-align="center" data-sortable="false">身份证号码</th>
					<th data-field="uidimageurl" data-align="center" data-sortable="false"  data-formatter="uidpic">身份证图片</th>
					<th data-field="dietlicense" data-align="center" data-sortable="false">执照编号</th>
					<th data-field="dietimageurl" data-align="center" data-sortable="false" data-formatter="dietimageurl">执照图片</th>
					<th data-field="sqdate" data-align="center" data-sortable="true">申请日期</th>										 
				</tr>
			</thead>
		</table>
 	</div>
</body>

<script src="/js/CustomExportJs/table.js"></script>
<script src="/js/tableExport/libs/pdfMake/pdfmake.min.js"></script>

<!-- <script type="text/javascript">
document.write("<scr"+"ipt src=\"/js/tableExport/libs/pdfMake/vfs_fonts.js\" language=\"JavaScript\"></sc"+"ript>")
</script> -->

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
	}
	
	function uidpic(value,row,index){
		return '<img style="width:40px;height:40px;" src="' + row.uidimageurl + '"></img >';
	}
	
	function dietimageurl(value,row,index){
		return '<img style="width:40px;height:40px;" src="' + row.dietimageurl + '"></img >';
	}
	
	 
	
</script>
</html>
