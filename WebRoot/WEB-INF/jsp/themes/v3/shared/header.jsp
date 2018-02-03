
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <title>${basemodel.title}</title>
    <meta name="keywords" content="${basemodel.keywords}" />
    <meta name="description" content="${basemodel.description}" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://static.kecq.com/style/flat-ui/css/vendor/bootstrap.min.css" rel="stylesheet" />
    <link href="http://static.kecq.com/style/flat-ui/css/flat-ui.min.css" rel="stylesheet" />
</head>

<body>
    <!-- java版本 -->
    <!-- 导航条开始 -->
    <div class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                </button>
                <a href="${basemodel.blogUrl }"><img src="${basemodel.blog.blogLogo } " style="height:50px" /></a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                <c:forEach items="${basemodel.menus}" var="item">
       				  <li <c:if test="${item.isActive}">class="active"</c:if>>
                            <a target="${item.menuTarget}" href="${item.menuUrl}">${item.menuDisplay}</a>
                       </li>
    			</c:forEach>

                </ul>
            </div>
        </div>
    </div>
    <!-- 导航条结束 -->

    <!--page-->