<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/6/3
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果页面！</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    int flag =0;
    String str ="";
    if (request.getAttribute("flag") == null || request.getAttribute("user")==null){
        flag = (int)session.getAttribute("flag");
        str = (String)session.getAttribute("user");
    }
    else {
        flag = (int) request.getAttribute("flag");
        str = (String) request.getAttribute("user");
    }
    out.print("<input type=\"hidden\" id=\"info\" value="+str+">");
    out.print("<input type=\"hidden\" id=\"flag\" value="+flag+">");
%>
<script src="js/result.js">
</script>
</body>
</html>
