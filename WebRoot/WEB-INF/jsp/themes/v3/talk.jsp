
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="shared/header.jsp"%>


<link type="text/css" rel="stylesheet" href="http://static.kecq.com/style/v_timeline/style.css" />

<section id="cd-timeline" class="cd-container"> 

<c:forEach items="${model.talkCollection }" var="item">

	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-picture">
			<img src="http://static.kecq.com/style/v_timeline/img/cd-icon-location.svg" alt="Picture">
		</div>

		<div class="cd-timeline-content">
			<h2 style="display:none">HTML5+CSS3实现的响应式垂直时间轴</h2>
			<p> 
			<c:if test="${item.pic!=null && item.pic!='' }">
                                   <img src="${item.pic }" />
                                 </c:if>
			${item.talkContent }</p>
			
			<a href="javascript:;" class="cd-read-more" style="display:none" target="_blank">阅读全文</a>
			
			<span class="cd-date"> <fmt:formatDate value="${item.talkDatetime}"  pattern="yyyy-MM-dd HH:mm:ss" /></span>
		</div>
	</div>
	
	</c:forEach>

</section>

   <script type="text/javascript" src="http://static.kecq.com/js/jquery-1.8.1.min.js"></script>
<<script type="text/javascript">
$(".navbar-fixed-top").removeClass("navbar-fixed-top");
</script>
<%@ include file="shared/footer.jsp"%>