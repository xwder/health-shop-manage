<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- 修改模态框 -->
	<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改商品信息</h4>
				</div>
				<div class="modal-body">
					<form role="form" action="*" method="post">
					    <div class="form-group" style="display:none">							
							 <input type="hidden" class="form-control" name="id" id="itemid">
						</div>
						<div class="form-group">
							<label for="name">商品名称</label>
							<input type="text" class="form-control" name="pname" id="itempname">
						</div>
						<div class="form-group">
							<label for="name">简短描述</label>
							<div class="form-group"> 
							    <textarea class="form-control" rows="3" name="pms" id="itempms"></textarea> 
							</div> 
						</div>
						<div class="form-group">
							<label for="name">商品价格</label>
							 <input type="text" class="form-control" name="pprice" id="itempprice">
						</div>
						<div class="form-group">
							 <label for="name">商品图片</label>
							 <img src="" id="itemppic">
							 <input type="file" class="form-control" name="ppic" >
						</div>
						<div class="form-group">
							<label for="name">商品库存</label>
							 <input type="text" class="form-control" name="pstock" id="itempstock">
						</div>
						
						<div class="form-group">
							 <label for="name">商品描述</label>
							 <!-- 加载编辑器的容器 -->
							<script id="container" name="content" type="text/plain">
									内容
							</script>
							<!-- 配置文件 -->
							<script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
							<!-- 编辑器源码文件 -->
							<script type="text/javascript" src="/ueditor/ueditor.all.js"></script>
							<!-- 实例化编辑器 -->
							<script type="text/javascript">
								
							</script>
						</div>
						<div class="form-group">
							<label for="name">热门商品</label>	
							<select name="isHot" id="itemisHot">
					             <option value="1">热门商品</option>
					             <option value="0">普通商品</option>
						    </select>
						</div>
						
						<div class="form-group">
							<label for="name">上下架</label>
							<select name="isSell" id="itemisSell">
					             <option value="1">上架商品</option>
					             <option value="2">下架商品</option>
						    </select>
						</div>
						
						<div class="form-group">
							<label for="name">商品类型</label>
							<select name="ptype" id="itemptype">
					             <option value="蔬菜类">蔬菜类</option>
					             <option value="水果类">水果类</option>
					             <option value="肉类">肉类</option>
					             <option value="熟食类">熟食类</option>
					             <option value="谷物类">谷物类</option>
						    </select>
						</div>
										
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="submitInfor" class="btn btn-primary" onclick="modifyzixunsaveinfor()">保存修改</button>
				</div>
			</div>
		</div>
	</div>  