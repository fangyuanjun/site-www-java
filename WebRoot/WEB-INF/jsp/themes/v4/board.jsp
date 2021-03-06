<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${model.title}</title>
    <link type="text/css" rel="stylesheet" href="http://static.kecq.com/style/blog/themes/default/blog-common.css" />
    <link type="text/css" rel="stylesheet" href="http://static.kecq.com/style/blog/style.css" />
    <script type="text/javascript" src="http://static.kecq.com/js/jquery-1.8.1.min.js"></script>
    <link href="http://static.kecq.com/js/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
    <script src="http://static.kecq.com/js/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="http://static.kecq.com/js/kindeditor-4.1.10/themes/default/default.css" />
    <script type="text/javascript" charset="utf-8" src="http://static.kecq.com/js/kindeditor-4.1.10/kindeditor-min.js"></script>
    <script type="text/javascript" charset="utf-8" src="http://static.kecq.com/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <script type="text/javascript">
        var editor1;
        KindEditor.ready(function (K) {
            editor1 = K.create('#commentContent', {
                uploadJson: '',
                allowFileManager: false,
                items: ['emoticons',
                    '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull',
                    '|', 'fontname', 'fontsize',
                    '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                    '|', 'image', 'multiimage', 'code', 'link', 'baidumap']
            });
        });
    </script>
</head>
<body>

    <form id="form1">

        <!--start 评论-->
        <div>
            <div class="feedback_area_title">
                留言板
            </div>
            <div class="feedbackNoItems">
            </div>
            <div class="feedbackItems">
            <c:forEach items="${model.collection }" var="item">
             <div class="feedbackItem" id="review-each${item.ID}">
                        <div class="feedbackListSubtitle">
                            <div class="feedbackManage">
                                <a href="javascript:zhichi('${item.ID}',1)">支持(<label style="color:red" id="zhichi${item.ID}">${item.supportCount}</label>)</a>&nbsp;
                                <a href="javascript:zhichi('${item.ID}',0)">反对(<label style="color:red" id="fandui${item.ID}">${item.againstCount}</label>)</a>&nbsp;
                                <a style="display: none" href="javascript:huifu('${item.ID}')">回复<label style="color: red">0</label></a>&nbsp;
                                <!--  <a class="feedbackManage_admin" href="javascript:del('${item.ID}')">删除</a>&nbsp; -->

                            </div>
                            <span class="louzhu">${item.author}</span>
                            <fmt:formatDate value="${item.ADD_DATE}"  pattern="yyyy-MM-dd HH:mm:ss" />&nbsp;${item.IP}
                        </div>
                        <div class="feedbackCon">
                          ${item.mark}
                        </div>
                    </div>
            </c:forEach>

            </div>

        </div>

        <!--end 评论-->
        <div class="clear"></div>
        <!--start comment-->
        <div>
            <div style="float: left;">
                <table >

                    <tr>
                        <td>
                            <textarea class="commentTextBox" id="commentContent" style="width: 400px; height: 150px"></textarea>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <input type="button" value=" 提 交 " class="button" onclick="doPost()" />

                        </td>

                    </tr>
                    <tr>
                        <td>
                            &nbsp;
                        </td>
                    </tr>
                </table>
            </div>
            <div class="myfastcomment">
                <div class="myfastcommentTip">快速回复</div>
                <div style="width: 300px">
                    <img class="myfastcommentImg" id="myfastcommentImg1" title="catsoul崩溃地说:知道我膝盖中了一箭" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0001.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg2" title="catsoul发疯地说:我擦" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0002.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg3" title="catsoul坏笑地说:你懂的" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0003.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg4" title="catsoul奸笑地说:这真是极好的" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0004.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg5" title="catsoul精神地说:给力" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0005.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg6" title="catsoul纠结地说:你妹" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0006.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg7" title="catsoul哭说:感觉不会再爱了" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0007.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg8" title="catsoul调皮说:楼下怎么看" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0008.png" />
                    <img class="myfastcommentImg" id="myfastcommentImg9" title="catsoul淫笑说:呵呵" src="http://static.kecq.com/images/common/qw_cat/qw_cat_0009.png" />
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <!--end comment-->

        <script type="text/javascript">
            $(document).ready(function () {

                $(".myfastcommentImg").click(function () {
                    var id = $(this).attr("id");
                    var html = $(this).attr("src");
                    html = html.replace(".png", ".gif");
                    $.ajax({
                        type: "POST",             //因为这里有post提交回复的数据 但是验证是否登录需要跳转 所以不在本页验证是否登录，而采用iframe 中的页面
                        url: "/BoardPost/FastComment",
                        data: "commentContent=" + html,
                        dataType: "json",
                        success: function (msg) {
                            if (msg.code > 0) {
                                jBox.tip('发布成功', 'success');
                                $(".feedbackItems").append("<div class=\"feedbackItem\"><div class=\"feedbackCon\"><img src='" + html + "' /></div></div>");
                            } else {
                                alert(msg.message);
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            alert("错误");
                            document.write(XMLHttpRequest.responseText);
                        }
                    });
                });
            });

            function del(id) {
                if (confirm("你确定删除吗？") == true) {
                    $.ajax({
                        type: "POST",
                        url: "/BoardPost/DeleteComment",
                        data: "id=" + id,
                        dataType: "json",
                        success: function (msg) {
                            if (msg.code > 0) {
                                $("#review-each" + id).slideToggle("slow");
                                jBox.tip('删除成功', 'success');
                            } else {
                                alert(msg.message);
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            alert("错误");
                            document.write(XMLHttpRequest.responseText);
                        }
                    });
                }
            }

            function verify(id, state) {
                $.ajax({
                    type: "POST",
                    url: "/BoardPost/Verify",
                    data: "id=" + id + "&state=" + state,
                    dataType: "json",
                    success: function (msg) {
                        if (msg.code > 0) {
                            $("#verify3" + id).hide();
                            if (state == 1) {
                                $("#verify1" + id).hide();
                                $("#verify2" + id).show();
                            }
                            if (state == 2) {
                                $("#verify1" + id).show();
                                $("#verify2" + id).hide();
                            }
                            jBox.tip('操作成功', 'success');
                        } else {
                            alert(msg.message);
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("错误");
                        document.write(XMLHttpRequest.responseText);
                    }
                });
            }

            //支持和反对 state 为1表示支持 0表示反对
            function zhichi(id, state) {
                var selectID = "#";
                if (state == 1) {
                    selectID = "#zhichi" + id;
                }
                if (state == 0) {
                    selectID = "#fandui" + id;
                }

                $.ajax({
                    type: "POST",
                    url: "/BoardPost/Zhichi",
                    data: "id=" + id + "&state=" + state,
                    dataType: "json",
                    success: function (msg) {
                        if (msg.code > 0) {
                            var txt = $(selectID).text();
                            $(selectID).text((parseInt(txt) + 1));
                        } else {
                            alert(msg.message);
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("错误");
                        document.write(XMLHttpRequest.responseText);
                    }
                });
            }

           
            function doPost() {
                var content = editor1.html();
                var contentText = editor1.text();
                if (contentText == null || contentText == "") {
                    alert("请输入评论内容");
                    return false;
                }

                var html = "<div class=\"feedbackItem\"><div class=\"feedbackCon\">" + content + "</div></div>";
                $.ajax({
                    type: "POST",             //因为这里有post提交回复的数据 但是验证是否登录需要跳转 所以不在本页验证是否登录，而采用iframe 中的页面
                    url: "BoardPost/Comment",
                    data: "commentContent=" + content + "&commentText=" + editor1.text(),
                    dataType: "json",
                    success: function (msg) {
                        if (msg.code > 0) {
                            jBox.tip(msg.message, 'success');
                            $(".feedbackItems").append(html);
                        } else {
                            alert(msg.message);
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("错误");
                        document.write(XMLHttpRequest.responseText);
                    }
                });
            }

        </script>

      ${basemodel.tongjiHtml} 
    </form>
</body>
</html>

