
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="shared/header.jsp"%>


<!--大图开始-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-top:50px">
    <!-- Indicators -->
    <ol class="carousel-indicators">
     <c:set var="i" value="0"></c:set>
     <c:forEach items="${model.sliderCollection}" var="item">
    
               <li data-target="#carousel-example-generic" data-slide-to="${i }" class="<c:if test="${i==0}">active</c:if>"></li>
                <c:set var="i" value="${i+1 }"></c:set>
     </c:forEach>

    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

     <c:set var="i" value="0"></c:set>
     <c:forEach items="${model.sliderCollection}" var="item">
       <div class="item <c:if test="${i==0}">active</c:if>">
       
       <c:choose>
         <c:when test="${item.url==null||item.url=='' }">
           <img src="${item.pic}" style="height:550px; width:100%" alt="...">
         </c:when>
         <c:otherwise>
           <a href="${item.url}" target="_blank"><img src="${item.pic}" style="height:550px; width:100%" alt="..."></a>
         </c:otherwise>
       </c:choose>
				<div class="carousel-caption">
                    </div>
                    </div>
      <c:set var="i" value="${i+1 }"></c:set>
      <%
      // <c:set target="${item }" property="url" value=""></c:set>
      %>
     
     </c:forEach> 
     
    </div>
</div>
<!--大图结束-->

<div style="height:30px;"></div>

<div class="container" style="font-size:14px;">
    <div class="row">
        <div class="col-md-9">
<c:forEach items="${model.indexArticles}"  var="item">
 <div class="media">
                    <div class="media-body">
                        <h4 class="media-heading"><a href="${item.articleUrl}" target="_blank">${item.articleTitle}</a></h4>
                        <div style="color:gray;">
                            <span>作者:</span><strong>${item.articleAuthor}</strong> &nbsp; &nbsp;
                            <span>分类:</span><strong><a href="${item.categoryUrl}" target="_blank">${item.categoryDisplay}</a></strong> &nbsp; &nbsp;
                            <span>标签:</span><strong>
                            <c:forEach items="${item.tagCollection }" var="tag">
                             <a href="${tag.url}" target="_blank" rel="tag">${tag.tagDisplay}</a>&nbsp;
                            </c:forEach>
                              
                            </strong> &nbsp; &nbsp;
                            <span>时间:</span><strong>${item.showDate}</strong> &nbsp; &nbsp;
                            <span>浏览:</span><strong>${item.articleClickTimes}</strong> &nbsp; &nbsp;
                           
                        </div>

                        <div>
                            <a href="${item.articleUrl}" target="_blank">
                            <c:if test="${item.articlePic!=null && item.articlePic!='' }">
                               <img class="articlePic" src="http://static.kecq.com/images/common/big-loading.gif" data-original="${item.articlePic}" style="width:100%;" />
                            </c:if>
           
                            </a>
                        </div>

                        <div>
                            <p>
                            ${item.articleSubContentHtml }
                         
                                [...]&nbsp; &nbsp;<a href="${item.articleUrl }" target="_blank">阅读全文</a>
                            </p>

                        </div>
                    </div>
                </div>
                <hr />
</c:forEach>

           <div class="pagination">
                <ul>
                <c:forEach items="${model.pagerCollection }" var="item">
                 <c:set var="classString" value=""></c:set>
                  <c:choose>
                   <c:when test="${item.current }">  <!--不是isCurrent -->
                    <c:set var="classString" value="active"></c:set>
                   </c:when>
                   <c:when test="${item.disabled }">
                    <c:set var="classString" value="disabled"></c:set>
                   </c:when>
                  </c:choose>
                   <li class="${classString }"><a href="${item.url}">${item.text}</a></li>
                </c:forEach>
                </ul>
            </div>

          
        </div>
        <div class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">关于我</h3>
                </div>
                <div class="panel-body">
                  ${basemodel.blog.aboutMe }
                  
                </div>
            </div>

            <div class="list-group">
                <a href="javascript:;" class="list-group-item disabled">
                    分类
                </a>
      <c:forEach items="${model.categorys }" var="item">
       <a href="${item.url}" class="list-group-item">${item.categoryDisplay} (${item.articleCount})</a>
      </c:forEach>          

            </div>

            <div style="margin-top:30px;">
                <h4>近期文章</h4>
                <ul class="media-list" style="margin-left:20px;">
                      <c:forEach items="${model.newArticles }" var="item">
     <li class="media"><a target="_blank" href="${item.articleUrl}">${item.articleTitle}</a></li>
      </c:forEach>   
                

                </ul>
            </div>

            <div style="margin-top:30px;">
                <h4>文章归档</h4>
                <ol class="list-unstyled" style="margin-left:20px;">
                <c:forEach items="${model.months }" var="item">
                <li><a href="${item.url}">${item.title}</a></li>
                </c:forEach>
                    

                </ol>
            </div>

            <div style="margin-top:30px;">
                <h4>标签</h4>
                <ol class="list-unstyled" style="margin-left:20px;">
                <c:forEach items="${model.tags }" var="item">
                <li><a href="${item.url }" title="${item.articleCount} 个话题" style="${item.style}">${item.tagDisplay}</a></li>
                </c:forEach>

                </ol>
            </div>

            <div style="margin-top:30px;">
                <h4>随机推荐</h4>
                <ul class="media-list" style="margin-left:20px;">
                <c:forEach items="${model.randomArticles }" var="item">
                  <li class="media"><a target="_blank" href="${item.articleUrl}">${item.articleTitle2}</a></li>
                </c:forEach>
                
     
                </ul>
            </div>

           
        </div>
    </div>
</div>


   <script type="text/javascript" src="http://static.kecq.com/js/jquery-1.8.1.min.js"></script>
    <script src="http://static.kecq.com/style/flat-ui/js/flat-ui.min.js"></script>

    <script src="http://static.kecq.com/js/jquery/jquery.lazyload.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".articlePic").lazyload({
                effect: "fadeIn"
            });
        });
        
    </script>



<%@ include file="shared/footer.jsp"%>