<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/6/2
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <meta charset="utf-8">
    <title>用户登陆</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<a name="shouhang"></a>
<body>
<div class="body1">
    &nbsp;
    <h1 style="text-align: center">欢迎登陆！</h1>
<div class="login1">
    <form action="login" method="post">
    用户名:<br><input type="text" name="username"><br>
    密码:<br><input type="password" name="userpassword"><br><br>
    <input type="submit" value="提交">
</form>
    <a href="register.jsp">没有账号？单击此处新建账号！</a>
</div>
</div>

</body>
</html>
