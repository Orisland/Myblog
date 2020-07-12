
function logout() {
    var flag =2;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
        }
    }
    xmlhttp.open("get","dyn2?flag="+flag,true);
    xmlhttp.send();
    sessionStorage.setItem("flag",8);
    sessionStorage.setItem("user","");
    window.location.href='result.jsp';
}

function manage() {
    var user = sessionStorage.getItem("user");
    var flag =1;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("manC1").style="";
            document.getElementById("manC2").style="display: none";
            document.getElementById("manC3").style="display: none";
            document.getElementById("manC").style="";
            if(xmlhttp.responseText == "admin"){
                document.getElementById("manC").href="manage.jsp";
            }
            if (xmlhttp.responseText == "normal"){
                document.getElementById("manC").href="manage_personal.jsp";
            }
        }
    }
    xmlhttp.open("get","man?user="+user+"&flag="+flag,true);
    xmlhttp.send();
}

function addmessage() {
    var message = document.getElementById("mmessagein").value;
    var flag =1;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
        }
    }
    xmlhttp.open("get","dyn2?message="+message+"&flag="+flag,true);
    xmlhttp.send();
}

function messagelist() {
    var xmlhttp;
    var flag =3;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("mestext").value = xmlhttp.responseText;
        }
    }
    xmlhttp.open("get","dyn2?flag="+flag,true);
    xmlhttp.send();
}

function find() {
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            sessionStorage.setItem('num',xmlhttp.responseText);
            setdiv(xmlhttp.responseText);       //拿到总动态条数，发送下一步处理
        }
    }
    xmlhttp.open("post","txt",true);
    xmlhttp.send();
}

function setdiv(i) {
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("dongtai").innerHTML=xmlhttp.responseText; //拿到处理后的div数据
        }
    }
    xmlhttp.open("get","Dynamic_1?i="+i,true);  //拿到总动态条数发送进行处理
    xmlhttp.send();
}