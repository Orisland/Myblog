<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>动态</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%--
  Created by IntelliJ IDEA.
  User: Orisland
  Date: 2020/5/28
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<a name="shouhang"></a>
<body onload="find();messagelist();manage()">
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

    <div class="gif1">
        <img src="image/img-007Dduzily1g031kvhj6eg304603i0u6.gif" width="240px"></div>
</div>

</div>

<div class="music">
    <p style="width: 200px; float: left; margin-top: 40px; margin-left: 90px; border: double;text-align: center; background-color: cyan">和田薫 - 蛍 (纯音乐版)</p>
    <audio style="width: 260px;float: left; margin-top: 0px;	 margin-left: 62px; " controls="controls" loop="loop" src="image/和田薫 - 蛍 (instrumental).mp3"></audio>
    <p style="width: 250px; float: left; margin-top: 0px; margin-left: 70px;text-align: center; color: brown;">*这是很舒缓的音乐，安心播放啦~</p>
    <div id="message" style="text-align: center;background-color:white;margin-left:40px; border-style: double;height: 350px;width: 300px;float:left;">
        <h1>留言</h1>
        <textarea readonly="readonly" id="mestext" style="border-style: double;height: 280px;width: 100%"></textarea>
        <div>
            <form action="dyn2" method="post">
                <input name="message" type="meslist" id="mmessagein">
                <input name="flag" type="hidden" value="1">
                <input type="submit" value="留言">
            </form>

        </div>
    </div>
</div>

<div class="top">
    <a href="#shouhang"><img src="image/图片1.png"></a>
</div>

<div class="tongji1">
    <img style="width: 100px;" src="image/头像.png">
    <p style="text-align: center">Orisland</p>
    <p id="num" style="text-align: center">共${dynum}条动态</p>
</div>

<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
<script>
    L2Dwidget.init({ "model": { jsonPath:
                "https://unpkg.com/live2d-widget-model-miku@1.0.5/assets/miku.model.json",
            "scale": 1 }, "display": { "position": "right", "width": 110, "height": 150,
            "hOffset": 0, "vOffset": -20 }, "mobile": { "show": true, "scale": 0.5 },
        "react": { "opacityDefault": 0.8, "opacityOnHover": 0.1 } });
</script>


<div class="body1">
    <div>
        <div style="border-style: double; height: 100px; margin: 0 20px">
            <form name="dynput" method="post" action="dyn3" enctype="multipart/form-data">
                <input type="text" class="input" id="dyntext" name="dyntext" style="height: 70%; width: 900px; float:left;">
                <input type="submit" style="height:100px; width: 85px; float: right" value="发表">
                <input type="file" name="upload" style="float: left">
            </form>
        </div>
        <div id="dongtai"></div>
    </div>

    <script src="js/dynamic.js" charset="GBK"></script>
</div>
<script>
</script>
</body>
</html>
