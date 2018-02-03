
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="shared/header.jsp"%>

<div class="container" style="margin-top:60px" >

<div class="list-group">
   <c:forEach items="${model.listArticleCollection}" var="item">
      <a class="row list-group-item" href="${item.articleUrl}">
        <div class="col-md-8">
       ${item.articleTitle}
        </div>
         <div class="col-md-4 hidden-xs text-right">${item.showDate }   阅读: ${item.articleClickTimes }  评论: ${item.articleCommentTimes }</div>
    </a>
  </c:forEach>
</div>

</div>

<%@ include file="shared/footer.jsp"%>