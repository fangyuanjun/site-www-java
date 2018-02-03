<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer class="footer">
        <div class="container">
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

        </div>
    </footer>

<script>
            window.jsui = {
                www: '${basemodel.blogUrl}',
                uri: 'http://static.kecq.com/style/dux',
                ver: 'THEME_VERSION',
                roll: 0,
               
                url_rp: '${basemodel.blogUrl}/page-2.html'
            };
        </script>
        
       <script type='text/javascript' src='http://static.kecq.com/style/dux/js/libs/bootstrap.min.js'></script>
 <script type='text/javascript' src='http://static.kecq.com/style/dux/js/main.js'></script>
${basemodel.tongjiHtml} 

</body>
</html>
   


