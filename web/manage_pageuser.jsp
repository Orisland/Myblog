<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/6/16
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页专用</title>
    <style>
        th,td{width: 155px;border: 2px solid gray; text-align: center;padding: 2px 10px;font-size: small;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
        table{border-collapse: collapse;margin: 0px;padding: 0px}
        a{text-decoration: none}
    </style>
</head>
<body onload="">
<c:if test="${pageCount>0}">
    共有${pageCount}页，这是第${pageNo}页
    <c:if test="${pageNo>1}">
        <a href="page?pageNo=1&flagman=7">第一页</a>
        <a href="page?pageNo=${pageNo-1}&flagman=7">上一页</a>
    </c:if>
    <c:if test="${pageNo!=pageCount}">
        <a href="page?pageNo=${pageNo+1}&flagman=7">下一页</a>
        <a href="page?pageNo=${pageCount}&flagman=7">最后一页</a>
    </c:if>
    <div id="table">
        <table>
            <tr><th>用户名</th><th>用户密码</th><th>权限</th><th>管理</th></tr>
            <c:forEach items="${userList}" var="user">
                <tr><td>${user.name}</td><td>${user.password}</td><td>${user.power}</td><td><a onclick="userdel(this.getAttribute('value'))" value="${user.name}">删除</a></td></tr>
            </c:forEach>
        </table>
    </div>
    <br>
</c:if>
<c:if test="${pageCount == 0}">
    <p>没有记录</p>
</c:if>
<script src="js/manage_pagefile.js">
</script>
</body>
</html>
