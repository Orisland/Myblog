<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/6/2
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="body1">
    &nbsp;
    <h1 style="text-align: center">欢迎注册！</h1>
    <div class="login1">
        <form action="reg" method="post">
            用户名:<br><input type="text" name="username" onkeyup="finduser(this)">
            <p style="float: right;margin-right: 200px" id="user"></p><br>
            密码:<br><input id="password" type="password" name="userpassword"><br>
            确认密码:<br><input id="confirm1" onkeyup="confirm(this)" type="password" name="userpassword">
            <p style="float: right;margin-right: 200px" id="confirm"></p><br>
            <input type="submit" value="提交">
        </form>
        <a href="login.jsp">已有账号？单击此处登陆！</a>

    </div>

</div>
<script src="js/reg.js">
</script>
</body>
</html>
