
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=11,IE=10,IE=9,IE=8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="${basemodel.keywords}" />
    <meta name="description" content="${basemodel.description}" />
  	<title>${basemodel.title}</title>
    <link href="http://static.kecq.com/style/dux/css/bootstrap.min.css" rel="stylesheet" />
    <link href="http://static.kecq.com/style/dux/css/font-awesome.min.css" rel="stylesheet" />
    <link href="http://static.kecq.com/style/dux/css/main.css" rel="stylesheet" />
    <script type="text/javascript" src="http://static.kecq.com/js/jquery-1.8.1.min.js"></script>
     
    <!--[if lt IE 9]><script src="http://static.kecq.com/style/dux/js/libs/html5.min.js"></script><![endif]-->
</head>

<body class="home blog logged-in logged-admin site-layout-2">
<!-- java版本 -->
    <header class="header">
        <div class="container">
            <h1 class="logo"><a href="${basemodel.blogUrl }" title="${basemodel.title}">
                 <img src="${basemodel.blog.blogLogo }">${basemodel.title}</a></h1>		
                <ul class="site-nav site-navbar">
                <c:forEach items="${basemodel.menus}" var="item">
       				  <li class="menu-item <c:if test="${item.isActive}">current-menu-item</c:if>  ">
                            <a target="${item.menuTarget}" href="${item.menuUrl}">${item.menuDisplay}</a>
                       </li>
    			</c:forEach>
            </ul>
            <div class="topbar">
                <ul class="site-nav topmenu">
                 
                    <li class="menusns">
                        <a href="javascript:;">关注本站 <i class="fa fa-angle-down"></i></a>
                        <ul class="sub-menu">
                            <li><a class="sns-wechat" href="javascript:;" ><i class="fa fa-wechat"></i> 微信</a></li>
                            <li><a target="_blank" rel="external nofollow" href="javascript:;"><i class="fa fa-weibo"></i> 微博</a></li>
                            <li><a target="_blank" rel="external nofollow" href="javascript:;"><i class="fa fa-tencent-weibo"></i> 腾讯微博</a></li>
                            <li><a target="_blank" href="/Rss"><i class="fa fa-rss"></i> RSS订阅</a></li>
                        </ul>
                    </li>
                </ul>
                <a href="https://passport.kecq.com">登陆</a>
                &nbsp; &nbsp; <a target="_blank" href="https://passport.kecq.com/Register">注册</a>
            </div>
            <i class="fa fa-bars m-icon-nav"></i>
        </div>
    </header>
    
    <!--page-->