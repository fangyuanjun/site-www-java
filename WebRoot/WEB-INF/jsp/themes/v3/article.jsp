<%@page import="com.blog.common.Utility"%>

<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="shared/header.jsp"%>

<div style=" margin-top:80px;"></div>

<div class="container" style="font-size:14px;">
    <div class="row">
        <div class="media" style="margin:5px;">
            <div class="media-body">
                <h4 class="media-heading">${model.currentArticle.articleTitle}</h4>
                <div style="color:gray;">
                    <span>作者:</span><strong>${model.currentArticle.articleAuthor}</strong> &nbsp; &nbsp;
                    <span>分类:</span><strong><a href="${model.currentArticle.categoryUrl}" target="_blank">${model.currentArticle.categoryDisplay}</a></strong> &nbsp; &nbsp;
                    <span>时间:</span><strong>${model.currentArticle.showDatetime}</strong> &nbsp; &nbsp;
                    <span>浏览:</span><strong>${model.currentArticle.articleClickTimes}</strong> &nbsp; &nbsp;
                    <span>评论:</span><strong>${model.currentArticle.articleCommentTimes}</strong>
                    <span>来源:</span><strong>${model.currentArticle.articleSource}</strong>
                </div>
              
                <%
                 if(Utility.getIsRemote(request))
                 {
                	 %>
                	   <div>
                            <div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone"></a><a href="#" class="bds_tsina" data-cmd="tsina"></a><a href="#" class="bds_tqq" data-cmd="tqq"></a><a href="#" class="bds_renren" data-cmd="renren"></a><a href="#" class="bds_weixin" data-cmd="weixin"></a></div>
                            <script>window._bd_share_config = { "common": { "bdSnsKey": {}, "bdText": "", "bdMini": "2", "bdPic": "", "bdStyle": "0", "bdSize": "16" }, "share": {}, "image": { "viewList": ["qzone", "tsina", "tqq", "renren", "weixin"], "viewText": "分享到：", "viewSize": "16" }, "selectShare": { "bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "tqq", "renren", "weixin"] } }; with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
                        </div>
                	 <% 
                 }
                %>
               
                <style type="text/css">
                    #articleContent img {
                        width: 100%;
                    }
                </style>
                <div id="articleContent">
                ${model.currentArticle.articleContent}
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div style="margin:5px;">
            <hr />
            <p>上一篇:<a href="${model.beforeArticle.articleUrl}"> ${model.beforeArticle.articleTitle}</a></p>
            <p>下一篇:<a href="${model.afterArticle.articleUrl}">${model.afterArticle.articleTitle}</a></p>
            <hr />
        </div>
    </div>



    <div class="row">
        <div style="margin:5px;">
            <h4>${model.currentArticle.articleCommentTimes} 评论</h4>
            <c:forEach items="${ model.commentCollection}" var="item">
             <div id="comment-${item.commentID}">
                    <p><strong>${item.author}</strong> &nbsp;&nbsp;  <span>${item.ADD_DATE}</span>&nbsp;&nbsp;&nbsp;${item.mark}</p>
                    <p>${item.commentContent2}</p>
                  </div>
                <hr />
            </c:forEach>
            
            
            <div id="comment-add"></div>

            <div>
                <a href="http://${basemodel.blog.blogDomain}/comment-${model.currentArticle.articleID}-1.html" style="line-height: 35px; margin-left: 10px;" target="_blank">查看所有评论</a>
            </div>

            <hr />
            <h3>给个评论吧</h3>
		
          
            <!-- 加载编辑器的容器 -->
            <script id="comment-container" type="text/plain" style="width:100%; height:100px;">
            </script>
            <div style="margin-top:5px;"></div>
            <button class="btn btn-primary" id="btnCommentPost">评论</button>
           
            <div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" id="commentSuccess2">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                        </div>
                        <div class="modal-body">
                            评论成功
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

        </div>
    </div>

</div>


   <script type="text/javascript" src="http://static.kecq.com/js/jquery-1.8.1.min.js"></script>
   <script src="http://static.kecq.com/style/flat-ui/js/flat-ui.min.js"></script>
   <script src="http://static.kecq.com/js/jquery/jquery.lazyload.min.js"></script>
    
<script type="text/javascript" charset="utf-8" src="http://static.kecq.com/js/kindeditor-4.1.10/kindeditor-min.js"></script>
<script type="text/javascript" charset="utf-8" src="http://static.kecq.com/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <script type="text/javascript">
        //var ue = UE.getEditor('comment-container', {
        //    serverUrl: "http://upload.kecq.com/FileUpload.axd",
        //    toolbars: [
        //        ['undo', 'redo', 'emotion', 'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc']
        //    ]
        //});

        var editor1;
        KindEditor.ready(function (K) {
            editor1 = K.create('#comment-container', {
                uploadJson: '',
                allowFileManager: false,
                items: ['emoticons',
                    '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull',
                    '|', 'fontname', 'fontsize',
                    '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                    '|', 'link', 'baidumap']
            });
        });

        $(document).ready(function () {
            var v = $("#articleContent").find("img");
            v.css("width", "100%");
            v.each(function () {
                var imgUrl = $(this).attr("src");
                if ($(this).attr("data-original") != null && $(this).attr("data-original") != "") {
                    imgUrl = $(this).attr("data-original");
                }
                $(this).wrap("<a target='_blank' href='/Album/ArtilePhotoShow?articleID=${model.currentArticle.articleID}&uri=" + encodeURIComponent(imgUrl) + "'></a>");
            })

            $("#articleContent img").lazyload({
                effect: "fadeIn"
            });
        })

        $("#btnCommentPost").click(function () {
            //var content = ue.getContent();
            //var contentText = ue.getContentTxt();
		   //var vvv=$("#EditForm").serialize();

            editor1.sync();
            var content = editor1.html();   //editor1.html(); editor1.fullHtml();
            var contentText = editor1.text();

            if (content == null || content == "") {
                alert("请输入评论内容");
                return false;
            }

			var dataObject = {
				__RequestVerificationToken: $("input[name='__RequestVerificationToken']").val(),
				commentContent: content,
				commentText: contentText
				};

            var html = " <div>" + content + "</div>";
            $.ajax({
                type: "POST",             //因为这里有post提交回复的数据 但是验证是否登录需要跳转 所以不在本页验证是否登录，而采用iframe 中的页面
                url: "CommentPost/Comment?articleID=${model.currentArticle.articleID}",
                data: dataObject,
                dataType: "json",
                success: function (msg) {
                    if (msg.code > 0) {
                        $('#commentSuccess2').modal();
                        $("#comment-add").append(html);
                    } else {
                        alert(msg.message);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("系统错误");
                    document.write(XMLHttpRequest.responseText);
                }
            });
        });

        $(function () {
            $(".articlePic").lazyload({
                effect: "fadeIn"
            });
        });
    </script>

<%@ include file="shared/footer.jsp"%>