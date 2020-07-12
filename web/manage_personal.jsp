<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/6/30
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理页面</title>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <meta charset="utf-8">
    <title>用户登陆</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<a name="shouhang"></a>
<body onload="dynpage();logpage();">
<div class="body1">
    <h1 style="text-align: center">博文，动态 管理页面！</h1>
    <a href="update_password.jsp">修改密码</a>
    <div style="margin-left:10px;margin-right:10px;height: 100%;width: auto;border-style: double;border-radius:10px;" class="">
        <div style="float: left">
            <h2>动态管理</h2>
            <div style="margin-left:20px;margin-top:20px;float:left;height: 60px;">
                <p>请输入查询日期:</p>
                <input onkeyup="dynpg(this)" onclick="dynpg(this)" type="date" name="dyndate">
                <p>请输入需要操作的动态id:</p>
                <input id="input" onmouseup="dynId(this)" onclick="dynId(this)" onkeyup="dynId(this)" type="number" name="dynid">
                <p id="info">&nbsp;</p>
                <button id="button1" onclick="dyndel()" style="display: none" type="button">删除</button>
                <button id="button2" onclick="updatedynamc()" style="display: none" type="button">修改</button>
            </div>
            <iframe id="dynif" frameborder="no"  name="my-iframe" style="margin-left:30px;margin-top:-30px;float:left;height: 200px;width: 750px;" src="">
            </iframe>
        </div>

        <div style="float:left; margin-top: 40px">
            <h2>博文管理</h2>
            <div style="margin-left:20px;margin-top:20px;float:left;height: 60px;">
                <p>请输入查询日期:</p>
                <input onclick="logpg(this)" onkeyup="logpg(this)" type="date" name="logdate">
                <p>请输入需要操作的博文id:</p>
                <input id="input1"onmouseup="logID(this)" onclick="logID(this)" onkeyup="logID(this)" type="number" name="logid">
                <p id="info1">&nbsp;</p>
                <button id="button11" onclick="logdel()" style="display: none" type="button">删除</button>
                <button id="button22" onclick="updatelog()" style="display: none" type="button">修改</button>
            </div>
            <iframe id="logif" frameborder="no"  name="my-iframe" style="margin-left:30px;margin-top:-30px;float:left;height: 200px;width: 750px;" src="">
            </iframe>
        </div>

</div>
<script src="js/manage_per.js"></script>
</body>
</html>
