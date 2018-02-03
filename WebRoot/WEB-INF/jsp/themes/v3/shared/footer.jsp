<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<%
     //BaseViewModel basemodel2=(BaseViewModel)request.getAttribute("basemodel");
    %>
<div style="height:100px;"></div>

    <footer class="footer navbar-inverse">
        <div class="container" style="height:100px">
            <p class="text-center" style="margin-top:40px;">
                Copyright
                &copy;
                <script type="text/javascript">
                    //<![CDATA[
                    var d = new Date()
                    document.write(d.getFullYear())
                    //]]>
                </script>
                - All Rights Reserved :
                <a href="${basemodel.blogUrl}">${basemodel.blog.blogTitle}</a>&nbsp;
                <a href="/Rss" target="_blank">Rss</a>&nbsp;
                <a href="http://www.miitbeian.gov.cn/">${basemodel.blog.beian}</a>&nbsp;
                <a href="javascript:;">QQ群:${basemodel.blog.QQGroup}</a>&nbsp;
                <a href="${basemodel.blogUrl}/sitemap.xml" target="_blank">站点地图</a>&nbsp;
            </p>

        </div>
    </footer>
    <style type="text/css">
        #shangxia {
            position: fixed;
            top: 75%;
            right: 1%;
            display: block;
            z-index: 999;
        }

        #shang,  #xia {
            background: url(http://static.kecq.com/images/common/huadong.png) no-repeat;
            position: relative;
            cursor: pointer;
            height: 25px;
            width: 29px;
            margin: 10px 0 0;
        }

        #xia {
            background-position: left -68px;
        }


        #shang:hover {
            background-position: right 0;
        }

        #xia:hover {
            background-position: right -68px;
        }
    </style>
    <div id="shangxia">
        <div id="shang" title="↑ 返回顶部"></div>
        <div id="xia" title="↓ 移至底部"></div>
    </div>

    <script type="text/javascript">
        $(document).ready(function ($) { $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $("html") : $("body")) : $("html,body"); $("#shang").mouseover(function () { up() }).mouseout(function () { clearTimeout(fq) }).click(function () { $body.animate({ scrollTop: 0 }, 400) }); $("#xia").mouseover(function () { dn() }).mouseout(function () { clearTimeout(fq) }).click(function () { $body.animate({ scrollTop: $(document).height() }, 400) }); $("#comt").click(function () { $body.animate({ scrollTop: $("#comments").offset().top }, 400) }); }); function up() { $wd = $(window); $wd.scrollTop($wd.scrollTop() - 1); fq = setTimeout("up()", 50) }; function dn() { $wd = $(window); $wd.scrollTop($wd.scrollTop() + 1); fq = setTimeout("dn()", 50) };

        //$.ajax({
        //    type: "POST",    
        //    url: "/VisitPost",
        //    data: "title=" + encodeURIComponent(document.title) + "&uri=" + encodeURIComponent(document.location.href),
        //    dataType: "json",
        //    success: function (msg) {
               
        //    },
        //    error: function (XMLHttpRequest, textStatus, errorThrown) {
         
        //    }
        //});
    </script>

${basemodel.tongjiHtml} 

</body>
</html>