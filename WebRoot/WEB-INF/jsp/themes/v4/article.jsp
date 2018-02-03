<%@page import="com.blog.common.Utility"%>

<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="shared/header.jsp"%>

<section class="container">
	<div class="content-wrap">
	<div class="content" style="margin-right:0px">
				<header class="article-header">
			<h1 class="article-title">${model.currentArticle.articleTitle}</h1>
			<div class="article-meta">
				<span class="item">${model.currentArticle.showDatetime}</span>
				<span class="item">分类：<a href="${model.currentArticle.categoryUrl}" rel="category" target="_blank">${model.currentArticle.categoryDisplay}</a></span>
				<span class="item post-views">阅读(${model.currentArticle.articleClickTimes})</span>
				<span class="item">评论(${model.currentArticle.articleCommentTimes})</span>
				<span class="item">来源:${model.currentArticle.articleSource}</span>
				<span class="item">作者:${model.currentArticle.articleAuthor}</span>
			</div>
		</header>
		
		<article class="article-content" id="articleContent">
						    ${model.currentArticle.articleContent}
		</article>
		
		
		

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
    
	</section>


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
            v.css("max-width", "100%");
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

 <link href="http://static.kecq.com/js/syntaxhighlighter_3.0.83/styles/shCoreDefault.css" rel="Stylesheet" type="text/css" />

    <!-- mw_syntaxhighlighter ver.3.0.83 Begin -->
    <script type="text/javascript" src="http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shCore.js?ver=3.0.83"></script>
    <script type="text/javascript" src="http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shAutoloader.js?ver=3.0.83"></script>
    <script type="text/javascript" src="http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushXml.js?ver=3.0.83"></script>
    <script type="text/javascript">
    //<![CDATA[
    SyntaxHighlighter.autoloader(
    "applescript	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushAppleScript.js?ver=3.0.83"
    , "as3 actionscript3	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushAS3.js?ver=3.0.83"
    , "bash shell	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushBash.js?ver=3.0.83"
    , "cf coldfusion	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushColdFusion.js?ver=3.0.83"
    , "cpp c	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushCpp.js?ver=3.0.83"
    , "c# c-sharp csharp	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushCSharp.js?ver=3.0.83"
    , "css	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushCss.js?ver=3.0.83"
    , "delphi pas pascal	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushDelphi.js?ver=3.0.83"
    , "diff patch	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushDiff.js?ver=3.0.83"
    , "erl erlang	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushErlang.js?ver=3.0.83"
    , "groovy	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushGroovy.js?ver=3.0.83"
    , "java	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushJava.js?ver=3.0.83"
    , "jfx javafx	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushJavaFX.js?ver=3.0.83"
    , "js jscript javascript	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushJScript.js?ver=3.0.83"
    , "perl pl	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushPerl.js?ver=3.0.83"
    , "php	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushPhp.js?ver=3.0.83"
    , "plain text	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushPlain.js?ver=3.0.83"
    , "ps powershell	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushPowerShell.js?ver=3.0.83"
    , "py python	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushPython.js?ver=3.0.83"
    , "rails ror ruby rb	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushRuby.js?ver=3.0.83"
    , "sass scss	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushSass.js?ver=3.0.83"
    , "scala	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushScala.js?ver=3.0.83"
    , "sql	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushSql.js?ver=3.0.83"
    , "vb vbnet	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushVb.js?ver=3.0.83"
    , "xml xhtml xslt html	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushXml.js?ver=3.0.83"
    , "objc	http://static.kecq.com/js/syntaxhighlighter_3.0.83/scripts/shBrushObjC.js?ver=3.0.83"
    );
    SyntaxHighlighter.defaults['auto-links'] = true;
    SyntaxHighlighter.defaults['quick-code'] = true;
    SyntaxHighlighter.defaults['title'] = '';
    SyntaxHighlighter.defaults['class-name'] = 'notranslate';
    SyntaxHighlighter.defaults['collapse'] = false;
    SyntaxHighlighter.defaults['first-line'] = 1;
    SyntaxHighlighter.defaults['gutter'] = true;
    SyntaxHighlighter.defaults['pad-line-numbers'] = 1;
    SyntaxHighlighter.defaults['smart-tabs'] = true;
    SyntaxHighlighter.defaults['tab-size'] = 4;
    SyntaxHighlighter.defaults['toolbar'] = true;
    SyntaxHighlighter.config.strings.expandSource = '+ expand source';
    SyntaxHighlighter.config.strings.help = '?';
    SyntaxHighlighter.config.strings.alert = 'SyntaxHighlighter';
    SyntaxHighlighter.config.strings.noBrush = "Can\'t find brush for: ";
    SyntaxHighlighter.config.strings.brushNotHtmlScript = "Brush wasn\'t configured for html-script option: ";
    try
    {
    	  SyntaxHighlighter.all();
    }
    catch(e){}
  
    //]]></script>
    <!-- mw_syntaxhighlighter ver.3.0.83 End -->
    
<%@ include file="shared/footer.jsp"%>