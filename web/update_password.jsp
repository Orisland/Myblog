<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/7/1
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码修改</title>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <meta charset="utf-8">
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<a name="shouhang"></a>
<body>
<div class="body1">
    &nbsp;
    <h1 style="text-align: center">用户${user}安全密码管理</h1>
    <div class="login1">
        <form action="manper" method="post">
            用户名:<br>${user}<br>
            密码:<br><input id="password" type="password" name="userpassword"><br>
            确认密码:<br><input id="confirm1" onkeyup="confirm(this)" type="password" name="userpassword">
            <p style="float: right;margin-right: 200px" id="confirm"></p><br>
            <input type="submit" value="提交">
        </form>
    </div>
</div>
<script src="js/result.js"></script>
</body>
</html>

