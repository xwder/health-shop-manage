<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Viewport metatags -->
<meta name="HandheldFriendly" content="true" />
<meta name="MobileOptimized" content="320" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link rel="stylesheet" type="text/css" href="/css/dandelion.css"  media="screen" />

<div style="margin: 0 auto; width: 100%; background: ;">
	<!-- Main Wrapper. Set this to 'fixed' for fixed layout and 'fluid' for fluid layout' -->
	<div id="da-wrapper" class="fluid">

		<!-- Content -->
		<div id="da-content">

			<!-- Container -->
			<div class="da-container clearfix">

				<div id="da-error-wrapper">

					<div id="da-error-pin"></div>
					<div id="da-error-code">
						error <span>500</span>
					</div>

					<h1 class="da-error-heading">哎哟喂！页面让狗狗叼走了！</h1>
					<p>
						<h2 >错误提示： ${msg	 } ！</h2>
						<h3><a href="#">点击进入首页</a></h3>
					</p>
				</div>
			</div>
		</div>


	</div>

</div>
