
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="shared/header.jsp"%>

 <section class="container">

 <!-- class="content-wrap" -->
        <div class="col-lg-9 col-md-9 " style="padding-left:5px;padding-right:10px;">
        <!-- class="content" -->
            <div class="">
                <div id="focusslide" class="carousel slide" data-ride="carousel">
                 <ol class="carousel-indicators">
                  <c:set var="i" value="0"></c:set>
                <c:forEach items="${model.mainArticlePics}"  var="item">
                 <li data-target="#focusslide" data-slide-to="${i }" class="<c:if test="${i==0}">active</c:if>"></li>
                 <c:set var="i" value="${i+1 }"></c:set>
                </c:forEach>
               
                </ol>
                <div class="carousel-inner" role="listbox">
                <c:set var="i" value="0"></c:set>
                  <c:forEach items="${model.mainArticlePics}"  var="item">
                <div class="item <c:if test="${i==0}">active</c:if>">
                <a href="${item.articleUrl }">  <img  style="width:100%; max-height:400px;" src="${item.articlePic }"></a>
                <%
                // carousel-caption
                //height:50px; line-height:50px; margin-top:-150px; text-align: center;width:100%;opacity:0.6; background-color:#000
                %>
                <div class="carousel-caption" style="height:50px;line-height:50px;padding:0px 0px 0px 5px; left:0px;right:0px;bottom:0;font-size:20px; font-weight:bold;text-align:left; width:100%;opacity:0.6; background-color:#000">${item.articleTitle}</div>
                </div>
                 <c:set var="i" value="${i+1 }"></c:set>
                </c:forEach>
                
                </div>
                <a class="left carousel-control" href="#focusslide" role="button" data-slide="prev">
                <i class="fa fa-angle-left"></i></a>
                <a class="right carousel-control" href="#focusslide" role="button" data-slide="next"><i class="fa fa-angle-right"></i></a>
                </div>								
                
                <div class="title">
                    <h3>
                                                                     最新发布
                    </h3>
                </div>

	<c:forEach items="${model.indexArticles}"  var="item">
	
	 <article class="excerpt" <c:if test="${item.articlePic==null||item.articlePic==''}">style="padding-left:20px"</c:if>  >
	 <c:if test="${item.articlePic!=null&&item.articlePic!=''}">
	       <a class="focus" href="${item.articleUrl}">
                    <img   style="max-width:220px" src="http://static.kecq.com/images/common/big-loading.gif" data-original="${item.articlePic }" class="thumb articlePic">
                    </a>
	 </c:if>
	 
                   
                    <header>
                        <a class="cat" href="${item.categoryUrl}" target="_blank">${item.categoryDisplay}<i></i></a>
                        <h2><a href="${item.articleUrl}">${item.articleTitle}</a></h2>
                    </header>
                    <p class="meta">
                        <time><i class="fa fa-clock-o"></i>${item.showDate}</time>
                        <span class="author"><i class="fa fa-user"></i>${item.articleAuthor}</span>
                        <span class="pv"><i class="fa fa-eye"></i>阅读(${item.articleClickTimes})</span>
                        <a class="pc" href="/comment-${item.articleID}-1.html" target="_blank"><i class="fa fa-comments-o"></i>评论(${item.articleCommentTimes})</a>
                    </p>
                    <p class="note">
                     ${item.articleSubContentHtml }
                    </p>
                </article>               
</c:forEach>

            </div>

 				<div class="pagination">
                    <ul >
                      <c:forEach items="${model.pagerCollection }" var="item">
                 <c:set var="classString" value=""></c:set>
                  <c:choose>
                   <c:when test="${item.current }">  <!-- 不是isCurrent -->
                    <c:set var="classString" value="active"></c:set>
                   </c:when>
                   <c:when test="${item.disabled }">
                    <c:set var="classString" value="disabled"></c:set>
                   </c:when>
                  
                  </c:choose>
                   <li class="${classString }" style="display:inline;"><a href="${item.url}">${item.text}</a></li>
                </c:forEach>
                    </ul>
                </div>
        </div>
        
         <!-- class="sidebar" -->
        <aside class="col-lg-3 col-md-3" style="padding-left:10px;padding-right:5px;">
          
          <div class="widget widget-tops">
                <ul class="widget-nav">
                    <li class="active">关于我</li>
                </ul>
                <div class="panel-body">
 					${basemodel.blog.aboutMe }
                </div>

            </div>
            
            <div class="widget widget_categories">
                <h3>分类目录</h3>		
                <ul>
                 <c:forEach items="${model.categorys }" var="item">
                 <li class="cat-item">
                  <a href="${item.url}" >${item.categoryDisplay} (${item.articleCount})</a>
                 </li>
     			 </c:forEach>       

                </ul>
            </div>

            <div class="widget widget_recent_entries">
                <h3>近期文章</h3>		
                <ul>
                
                 <c:forEach items="${model.newArticles }" var="item">
     <li><a target="_blank" href="${item.articleUrl}">${item.articleTitle}</a></li>
      </c:forEach>   

                </ul>
            </div>		
            
            <div class="widget widget_archive">
                <h3>文章归档</h3>		
                <ul>
                     <c:forEach items="${model.months }" var="item">
                <li><a href="${item.url}">${item.title}</a></li>
                </c:forEach>
                </ul>
            </div>

            <div class="widget widget_ui_tags"><h3></h3>
            <div class="items">
              <c:forEach items="${model.tags }" var="item">
               <a href="${item.url }" title="${item.articleCount} 个话题" style="${item.style}">${item.tagDisplay}</a>
               </c:forEach>
            </div>
            </div>
          
          
          <div class="widget widget_recent_entries">
                <h3>随机推荐</h3>		
                <ul>
                 <c:forEach items="${model.randomArticles }" var="item">
                  <li><a target="_blank" href="${item.articleUrl}">${item.articleTitle2}</a></li>
                </c:forEach>
                </ul>
           </div>
        </aside>
   
    </section>
    
    
    <script src="http://static.kecq.com/js/jquery/jquery.lazyload.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".articlePic").lazyload({
                effect: "fadeIn"
            });
        });
        
    </script>

<%@ include file="shared/footer.jsp"%>