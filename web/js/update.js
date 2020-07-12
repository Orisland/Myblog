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
function dynchangeid() {
    document.getElementById("flag").value = sessionStorage.getItem("dynamicupdate");
}
function dynpicadd() {
    var id = sessionStorage.getItem("dynamicupdate");
    var flag =4;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("pic").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("get","up?id="+id+"&flag="+flag,true);
    xmlhttp.send();
}

function dynaddtext() {
    var id = sessionStorage.getItem("dynamicupdate");
    var flag =3;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("dynt").value = xmlhttp.responseText;
            document.getElementById("dyntext").value =xmlhttp.responseText;
        }
    }
    xmlhttp.open("get","up?id="+id+"&flag="+flag,true);
    xmlhttp.send();
}

function dyntext_input(object) {
    document.getElementById("dyntext").value = object.value;
}

function logchangeid() {
    document.getElementById("flag").value = sessionStorage.getItem("logupdate");
}

function logpicadd() {
    var id = sessionStorage.getItem("logupdate");
    var flag =5;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("pic").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("get","up?id="+id+"&flag="+flag,true);
    xmlhttp.send();
}

function logaddname() {
    var id = sessionStorage.getItem("logupdate");
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
            document.getElementById("logn").value = xmlhttp.responseText;   //名字塞进上面的框里
            document.getElementById("logname").value =xmlhttp.responseText;
        }
    }
    xmlhttp.open("get","up?id="+id+"&flag="+flag,true);
    xmlhttp.send();
}

function logaddtext() {
    var id = sessionStorage.getItem("logupdate");
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
            document.getElementById("logt").value = xmlhttp.responseText;
            document.getElementById("logtext").value =xmlhttp.responseText;
        }
    }
    xmlhttp.open("get","up?id="+id+"&flag="+flag,true);
    xmlhttp.send();
}


function logtext_input(object) {
    document.getElementById("logname").value = object.value;
}
function logtext_input1(object) {
    document.getElementById("logtext").value = object.value;
}

function confirm(object) {
    var i = document.getElementById("password").value;
    var i1 = object.value;

    if (i == i1){
        document.getElementById("confirm").innerHTML="";
    }
    else {
        document.getElementById("confirm").innerHTML="密码不一致！";
    }
}

//计时js
function getTime() {
    var date =new Date();

    var year = date.getFullYear();
    var month= date.getMonth()+1;
    var day = date.getDate();

    var h = date.getHours();
    var m = date.getMinutes();
    var s = date.getSeconds();

    var time = year +"-"+month+"-"+day+' '+h+":"+m+":"+s;
    document.getElementById("time").innerHTML=time;
}

setInterval(getTime,1000);