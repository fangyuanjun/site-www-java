<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${model.title}</title>
<link href="http://static.kecq.com/style/album/v1/main.css"
	rel="stylesheet" type="text/css" />
<link href="http://static.kecq.com/style/album/v1/sim-prev-anim.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="albums">
		<div class="albums-inner">
			<c:forEach items="${model.albumCollection }" var="item">
				<div class="albums-tab">
					<div class="albums-tab-thumb sim-anim-1">
						<c:forEach items="${item.photos }" var="p">
							<a href="/Album/PhotoShow/${item.id}" target="_blank"><img
								src="${p}" class="all studio" /></a>
						</c:forEach>
					</div>
					<div class="albums-tab-text">
						<a href="/Album/PhotoShow/${item.id }" target="_blank">${item.display}</a>
						<span>(${item.photoCount} pictures)
						</span>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<div style="text-align: center;"></div>
	<script src="http://static.kecq.com/js/jquery-1.11.3.min.js"></script>
	${basemodel.tongjiHtml}
</body>
</html>


