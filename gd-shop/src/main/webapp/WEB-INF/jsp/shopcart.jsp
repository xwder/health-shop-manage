<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>购物车</title>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
    <link rel="stylesheet" href="/css/shopcar.css">
</head>

<body>
    <div id="container">
		<jsp:include page="commons/header.jsp"></jsp:include>
        <div class="clear"></div>
        <div style="margin-top:20px;">
            <font style="font-size: 16px;color: #F4401C;font-weight: bold; margin-left:0px;border-bottom: 1px #F88600 solid;   padding-bottom: 10px;">全部商品 6</font>
            <font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">|</font>
            <font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">降价商品 0</font>
            <font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">|</font>
            <font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">库存紧张 0</font>
            <font style="font-size: 12px;color: #949494; font-weight:bold;margin-left:670px;">已选商品(不含运费)</font>
            <input type="button" value="结算" style="float: right; color:#686868;background-color:#DEDEDE;height:20px;width:46px;border-style:solid;"></input>
            <hr style=" border-style:solid;width: 960px;border-color:#DEDEDE;margin-top: 5px;" />
        </div>
        <div class="clear"></div>
        <div style="margin-top:20px;">
            <input type="checkbox">
            <font style="font-size: 12px;color: #212121;font-weight: bold;">全选</font>
            <font style="font-size: 12px;color: #212121;margin-left: 100px;font-weight: bold;">商品信息</font>
            <font style="font-size: 12px;color: #212121;margin-left: 250px;font-weight: bold;">单价(元)</font>
            <font style="font-size: 12px;color: #212121;margin-left: 100px;font-weight: bold;">数量</font>
            <font style="font-size: 12px;color: #212121;margin-left: 100px;font-weight: bold;">金额(元)</font>
            <font style="font-size: 12px;color: #212121;margin-left: 60px;font-weight: bold;">操作</font>
        </div>
        <div style="margin-top:15px;">
            <div style="margin-top:15px;">
                <div>
                    <input name="店铺" type="checkbox">
                    <font style="font-size: 12px;color: #212121;font-weight: bold;">店铺:巴鼎红火锅店专用</font>
                </div>
                <div id="shop">
                    <div class="shop_item" style="width:14%">
                        <input name="店铺" type="checkbox" />
                    </div>
                    <div class="shop_item" style="width:9%">
                        <img src="/images/shopcar/shoppin1.png" alt="">
                    </div>
                    <div class="shop_item" style="width:75%">
                        <span style="float: left;width:20%;">
                        <font style="font-size: 12px;color: #1f1f1f; ">买二送一,巴鼎红重庆麻辣香锅火锅底料干锅底料百搭调味料250克</font>									    		
                    </span>
                        <span style="float: left;width:20%;margin-left:93px;">
					    <font style="font-size: 12px;color: #1f1f1f;font-weight:bold;">15.90</font>
					    <br/>			
					    <button style="color:F88600;background-color: #FCE6D1;border: 1px #F88600 solid;width:80px;">卖家促销</button>
					</span>
                        <span style="float: left; width:19%;margin-left:10px;">
						 <input type="button" value="-" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input><input type="text" value="1" style=" color:#333333;height:30px;width:30px;text-align:center;"></input><input type="button" value="+" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input>
					</span>
                        <span style="float: left;width:6%;">
                          <font style="font-size: 14px;color: #FD3C0D;font-weight: bold;">
                              15.90
                        </font>
					</span >
                    
					<span style="float: left;width:10%;margin-left:70px;">
                        <font style="font-size: 14px;color: #1E1E1E; ">移入收藏夹</font>
                        <br/> 
                        <font style="font-size: 14px;color: #1E1E1E; ">删除</font>
					</span>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
            <div style="margin-top:15px;">
                <div>
                    <input name="店铺" type="checkbox">
                    <font style="font-size: 12px;color: #212121;font-weight: bold;">店铺:巴鼎红火锅店专用</font>
                </div>
                <div id="shop">
                    <div class="shop_item" style="width:14%">
                        <input name="店铺" type="checkbox" />
                    </div>
                    <div class="shop_item" style="width:9%">
                        <img src="/images/shopcar/shoppin1.png" alt="">
                    </div>
                    <div class="shop_item" style="width:75%">
                        <span style="float: left;width:20%;">
                        <font style="font-size: 12px;color: #1f1f1f; ">买二送一,巴鼎红重庆麻辣香锅火锅底料干锅底料百搭调味料250克</font>									    		
                    </span>
                        <span style="float: left;width:20%;margin-left:93px;">
					    <font style="font-size: 12px;color: #1f1f1f;font-weight:bold;">15.90</font>
					    <br/>			
					    <button style="color:F88600;background-color: #FCE6D1;border: 1px #F88600 solid;width:80px;">卖家促销</button>
					</span>
                        <span style="float: left; width:19%;margin-left:10px;">
						 <input type="button" value="-" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input><input type="text" value="1" style=" color:#333333;height:30px;width:30px;text-align:center;"></input><input type="button" value="+" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input>
					</span>
                        <span style="float: left;width:6%;">
                          <font style="font-size: 14px;color: #FD3C0D;font-weight: bold;">
                              15.90
                        </font>
					</span >
                    
					<span style="float: left;width:10%;margin-left:70px;">
                        <font style="font-size: 14px;color: #1E1E1E; ">移入收藏夹</font>
                        <br/> 
                        <font style="font-size: 14px;color: #1E1E1E; ">删除</font>
					</span>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
            <div style="margin-top:15px;">
                <div>
                    <input name="店铺" type="checkbox">
                    <font style="font-size: 12px;color: #212121;font-weight: bold;">店铺:巴鼎红火锅店专用</font>
                </div>
                <div id="shop">
                    <div class="shop_item" style="width:14%">
                        <input name="店铺" type="checkbox" />
                    </div>
                    <div class="shop_item" style="width:9%">
                        <img src="/images/shopcar/shoppin1.png" alt="">
                    </div>
                    <div class="shop_item" style="width:75%">
                        <span style="float: left;width:20%;">
                        <font style="font-size: 12px;color: #1f1f1f; ">买二送一,巴鼎红重庆麻辣香锅火锅底料干锅底料百搭调味料250克</font>									    		
                    </span>
                        <span style="float: left;width:20%;margin-left:93px;">
					    <font style="font-size: 12px;color: #1f1f1f;font-weight:bold;">15.90</font>
					    <br/>			
					    <button style="color:F88600;background-color: #FCE6D1;border: 1px #F88600 solid;width:80px;">卖家促销</button>
					</span>
                        <span style="float: left; width:19%;margin-left:10px;">
						 <input type="button" value="-" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input><input type="text" value="1" style=" color:#333333;height:30px;width:30px;text-align:center;"></input><input type="button" value="+" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input>
					</span>
                        <span style="float: left;width:6%;">
                          <font style="font-size: 14px;color: #FD3C0D;font-weight: bold;">
                              15.90
                        </font>
					</span >
                    
					<span style="float: left;width:10%;margin-left:70px;">
                        <font style="font-size: 14px;color: #1E1E1E; ">移入收藏夹</font>
                        <br/> 
                        <font style="font-size: 14px;color: #1E1E1E; ">删除</font>
					</span>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
            <div style="margin-top:15px;">
                <div>
                    <input name="店铺" type="checkbox">
                    <font style="font-size: 12px;color: #212121;font-weight: bold;">店铺:巴鼎红火锅店专用</font>
                </div>
                <div id="shop">
                    <div class="shop_item" style="width:14%">
                        <input name="店铺" type="checkbox" />
                    </div>
                    <div class="shop_item" style="width:9%">
                        <img src="/images/shopcar/shoppin1.png" alt="">
                    </div>
                    <div class="shop_item" style="width:75%">
                        <span style="float: left;width:20%;">
                        <font style="font-size: 12px;color: #1f1f1f; ">买二送一,巴鼎红重庆麻辣香锅火锅底料干锅底料百搭调味料250克</font>									    		
                    </span>
                        <span style="float: left;width:20%;margin-left:93px;">
					    <font style="font-size: 12px;color: #1f1f1f;font-weight:bold;">15.90</font>
					    <br/>			
					    <button style="color:F88600;background-color: #FCE6D1;border: 1px #F88600 solid;width:80px;">卖家促销</button>
					</span>
                        <span style="float: left; width:19%;margin-left:10px;">
						 <input type="button" value="-" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input><input type="text" value="1" style=" color:#333333;height:30px;width:30px;text-align:center;"></input><input type="button" value="+" style=" color:#333333;height:30px;width:20px;border-style:solid;"></input>
					</span>
                        <span style="float: left;width:6%;">
                          <font style="font-size: 14px;color: #FD3C0D;font-weight: bold;">
                              15.90
                        </font>
					</span >
                    
					<span style="float: left;width:10%;margin-left:70px;">
                        <font style="font-size: 14px;color: #1E1E1E; ">移入收藏夹</font>
                        <br/> 
                        <font style="font-size: 14px;color: #1E1E1E; ">删除</font>
					</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="/js/userinfo.js"></script>
</body>

</html>