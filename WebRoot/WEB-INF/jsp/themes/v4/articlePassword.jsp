
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>输入文章密码</title>
</head>
<body>
    <form id="form1" method="post">
        <div>
            你所在的文章需要输入密码进行查看
            <input  type="password" name="articlePassword"/>
            <input type="submit"  value="提交" />
        </div>
    </form>
</body>
</html>