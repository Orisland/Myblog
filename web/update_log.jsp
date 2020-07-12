<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>博文修改</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/6/11
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<a name="shouhang"></a>
<body onload="logaddname();logaddtext();logpicadd();logchangeid();manage();">
<div class="login">
    <div style="margin-left: 5px">
        <div style="float:left; "><%
            String info ="";
            if(session.getAttribute("user") == null || session.getAttribute("user") == ""){
                info ="欢迎游客登录！";
                out.print(info);
            }
            else {
                info= (String) session.getAttribute("user");
                out.print(info+"欢迎登陆！");
            }
        %>&nbsp&nbsp&nbsp</div>
        <div style="float: left;">
            <a id="manC2" style="" href="login.jsp">登陆</a>
            <a id="manC3" style="" href="register.jsp">注册</a>
            <a id="manC" style="display: none" href="manage.jsp">管理</a>
            <a id="manC1" style="display: none" onclick="logout()">登出</a>
        </div>
    </div>
</div>
<div>

    <div class="biaoti">
        <img class="image1" src="image/3.png">
        <img class="image1" src="image/标题左.png">
        <img class="image1" src="image/标题.png">
        <img class="image1" src="image/4.png">
    </div>
    <div class="daohang">
        <nav>
            <div class="daohang2">
                <ul>
                    <li><a href="dynamic.jsp" target="" >动态</a></li>
                    <li><a href="log.jsp" target="">博文</a></li>
                </ul>
            </div>
        </nav>
        <img style="height: 160px; position: absolute;left:1500px;top:52px;" src="image/img-007Dduzily1g031kwygohg301s01saa0.gif">
    </div>

    <div class="gif1" style="width: 300px">
        <img src="image/img-007Dduzily1g031kvhj6eg304603i0u6.gif" width="240px"></div>
</div>

</div>

<div class="music">
    <p style="width: 200px; float: left; margin-top: 40px; margin-left: 90px; border: double;text-align: center; background-color: cyan">和田薫 - 蛍 (纯音乐版)</p>
    <audio style="width: 260px;float: left; margin-top: 0px;	 margin-left: 62px; " controls="controls" loop="loop" src="image/和田薫 - 蛍 (instrumental).mp3"></audio>
    <p style="width: 250px; float: left; margin-top: 0px; margin-left: 70px;text-align: center; color: brown;">*这是很舒缓的音乐，安心播放啦~</p>
    <h3 style="text-align: center">原图片：</h3>
    <div id="pic" class="line" style="height: auto"></div>
</div>

<div class="top">
    <a href="#shouhang"><img src="image/图片1.png"></a>
</div>

<div class="tongji1">
    <img style="width: 100px;" src="image/头像.png">
    <p style="text-align: center">Orisland</p>
    <p style="text-align: center">共8条说说</p>
</div>

<div class="body1">
    <div id="dongtai">
        <p style="float:left;">当前时间为:&nbsp&nbsp&nbsp<p style="float:left;" id="time"></p></p><br><br>
        <p class="bt">标题:</p>
        <form name="logput" method="post" action="up" enctype="multipart/form-data">
            <input type="hidden" id="logname" name="logname" value="test_name">
            <input type="hidden" id="logtext" name="logtext" value="test_text">
            <textarea id="logn" onkeyup="logtext_input(this)" style="width: 1000px; margin: 20px;margin-top: 0px" class="input" rows="2" cols="100"></textarea>
            <p class="bt">正文:</p>
            <textarea id="logt" onkeyup="logtext_input1(this)" style="width: 1000px;height: 500px;margin-left: 20px;margin-right: 20px;margin-top: 0px" class="input" rows="5" cols="100"></textarea><br>
            <br>
            <p class="bt">上传附件(文件大小≤3MB):</p>
            <input style="margin-left: 20px;" type="file" name="upload"><br>
            <input type="hidden" id="flag" name="flag" value="1">
            <input style="margin: 20px; width: 150px" type="submit" value="修改">
            <input style="margin: 20px; width: 150px" type="reset" value="重置">
        </form>
    </div>
</div>
<script src="js/update.js">
</script>
</body>
</html>