<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${model.title}</title>
<link rel="stylesheet" media="screen" type="text/css"
	href="http://static.kecq.com/style/album/v1/picshow/zoom-visualizer.css">
<script
	src="http://static.kecq.com/style/album/v1/picshow/js/jquery.min.js"></script>
<script
	src="http://static.kecq.com/style/album/v1/picshow/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://static.kecq.com/style/album/v1/picshow/js/ZoomVisualizer.js"></script>
<script type="text/javascript">
	jQuery(document)
			.ready(
					function() {
						$(window)
								.ZoomVisualizer(
										{
											added : added,
											removed : removed,
											object : '#zoom-visualizer',
											resizeInitial : true,
											centerThumbs : true,
											loader : "http://static.kecq.com/style/album/v1/picshow/img/ajax-loader-overlay.gif",
											sliderOrientation : "vertical",
											positionZoom : {
												left : 10,
												right : 10,
												top : 10,
												bottom : 10
											}
										});

						function added() {
							//console.log("相册打开了！");
						}

						function removed() {
							//console.log("相册关闭了！");
						}
					});
</script>

<style type="text/css">
.clear {
	clear: both !important;
	float: none !important;
	margin: 0px !important;
	padding: 0px !important;
	height: 0px !important;
	width: 0px !important;
}

.clearfix:after {
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0;
}

.clearfix {
	display: inline-block;
}

html[xmlns] .clearfix {
	display: block;
}

* html .clearfix {
	height: 1%;
}

img {
	display: block;
}

input,textarea {
	color: #999999;
}

select {
	color: #999999;
}

.oldBrowser {
	display: none !important;
}

.center {
	width: 1000px;
	margin: 0 auto;
	text-align: left;
}

body {
	background: #f7f6f6;
	font-family: 'Roboto', sans-serif;
	font-size: 14px;
	line-height: 20px;
	color: #555;
	font-weight: 100;
}
</style>
</head>

<body>
	<!--<h1>jQuery zoomVisualizer Plugin Demo</h1>-->
	<div id="zoom-visualizer">
		<div class="lightbox-ofertas-bg"></div>
		<div class="lightbox">
			<div class="header">
				<div class="inside">
					<div id="wrapper-fechar" class="tooltip-content">
						<div class="tooltip">
							<p>Close</p>
							<span></span>
						</div>
						<a href="" class="fechar tooltip-caller"></a>
						<div class="clear"></div>
					</div>
					<div id="zoom">
						<div>
							<div class="tooltip-content">
								<div class="tooltip">
									<p>Zoom Out</p>
									<span></span>
								</div>
								<a href="#" class="zoom-out tooltip-caller"></a>
							</div>
							<div id="wrapper-barra-zoom" class="tooltip-content">
								<div class="tooltip">
									<p>Zoom</p>
									<span></span>
								</div>
								<div class="tooltip-caller wrapper-barra">
									<span id="barra"> <strong id="scroll"
										class="ui-draggable" style="position: relative; left: 0px;">
									</strong>
									</span>
								</div>
							</div>
							<div class="tooltip-content">
								<div class="tooltip">
									<p>Zoom In</p>
									<span></span>
								</div>
								<a href="#" class="zoom-in tooltip-caller"></a>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>

			<div class="content">

				<a href="" id="next"></a>
				<div class="wrapper" style="width: 1415px; height: 362px;">
					<img src="${model.currentUrl}" class="dragme">
				</div>
				<a href="" id="before"></a>
				<div style="float: right; margin-right: 60px">
					<div style="height: 300px; width: 250px; margin-top: -300px;">

						<div id="exifShow"></div>

					</div>
					<a href="#" id="exif"
						style="text-decoration: none; color: #11a1f5; font-size: 15px">EXIF</a>&nbsp;
					<a href="javascript:;" id="showSrc"
						style="text-decoration: none; color: #11a1f5; font-size: 15px">下载原图</a>
					<script type="text/javascript">
						$(document).ready(function() {
							$("#exif").hover(function() {
								var src = $(".dragme").attr("src");
								//$.ajax({
								//    type: "GET",          
								//    url: "/Album/Exif?uri=" + src,
								//    dataType: "text",
								//    success: function (msg) {
								//        $("#exifShow").html(msg).show();
								//    },
								//    error: function (XMLHttpRequest, textStatus, errorThrown) {
								//        alert("获取exif错误");
								//        //document.write(XMLHttpRequest.responseText);
								//    }
								//});

								var o = $(".ativo");
								var html = $("#exif" + o.attr("alt")).html();
								$("#exifShow").html(html).show();
							}, function() {
								$("#exifShow").hide();
							});

							$("#showSrc").click(function() {
								var src = $(".dragme").attr("src");
								//src = src.replace("images-drive.oss-cn-shenzhen.aliyuncs.com", "images.kecq.com");
								window.open(src);
							})
						})
					</script>
				</div>
			</div>

			<div class="footer">
				<a href="#" id="aba-lista"><span>Hide Thumbnails</span></a>
				<div id="listagem-imagens">
					<div>
					 <c:set var="index" value="0"></c:set>
					<c:forEach items="${model.photoCollection }" var="item">
					    <c:set var="index" value="${index+1 }"></c:set>
					   <a class="item-zoom-image <c:if test="${item.url==model.currentUrl }"> ativo</c:if>" href="${item.url}"
							alt="${index }"><img src="${item.thumbUrl}" style="width: 156px; height: 104px;"> </a>
					</c:forEach>


						<div class="clear"></div>
						<div style="display: none">
							<ul>
							  <c:set var="index2" value="0"></c:set>
							  <c:forEach items="${model.photoCollection }" var="item">
							     <c:set var="index2" value="${index2+1 }"></c:set>
							     <li id="exif${index2 }">${item.exif}</li>
							  </c:forEach>
								
							</ul>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div style="text-align: center;"></div>

	${basemodel.tongjiHtml}
</body>
</html>


