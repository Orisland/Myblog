function dynpg(object) {        //dynpage操作
    var flagman="10";
    var time = object.value;
    document.getElementById("dynif").src = "http://localhost:8080/web_war_exploded/page?time="+time+"&flagman="+flagman;
}

function dynpage() {
    var flagman="9";
    document.getElementById("dynif").src = "http://localhost:8080/web_war_exploded/page?flagman="+flagman;
}

function logpg(object) {        //logpage操作
    var flagman="12";
    var time = object.value;
    document.getElementById("logif").src = "http://localhost:8080/web_war_exploded/page?time="+time+"&flagman="+flagman;
}

function logpage() {
    var flagman="11";
    document.getElementById("logif").src = "http://localhost:8080/web_war_exploded/page?flagman="+flagman;
}

function updatelog() {
    sessionStorage.setItem("logupdate",document.getElementById("input1").value);
    window.location.href='update_log.jsp';
}

function updatedynamc() {
    sessionStorage.setItem("dynamicupdate",document.getElementById("input").value);
    window.location.href='update_dynamic.jsp';
}

//博文管理js
function logtimefind(object) {
    var i =object.value;
    var flag=4;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){

            document.getElementById("backdyn1").value=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}
function logID(object) {
    var i =object.value;
    var flag=5;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            if (xmlhttp.responseText == "该ID不存在!"){
                document.getElementById("info1").innerHTML=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
                buttonadd("button11","button22","display: none");
            }
            else {
                document.getElementById("info1").innerHTML=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
                buttonadd("button11","button22","");
            }
        }
    }
    xmlhttp.open("get","manage?i="+i +"&flag="+flag+"&fresh=" + Math.random(),true);
    xmlhttp.send();
}

function logdel() {
    var i =document.getElementById("input1").value;
    var flag=6;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("info1").innerHTML=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}

//动态管理js
function dyntimefind(object) {
    var i =object.value;
    var flag=1;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){

            document.getElementById("backdyn").value=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}

function dynId(object) {
    var i =object.value;
    var flag=2;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            if (xmlhttp.responseText == "该ID不存在!"){
                document.getElementById("info").innerHTML=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
                buttonadd("button1","button2","display: none");
            }
            else {
                document.getElementById("info").innerHTML=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
                buttonadd("button1","button2","");
            }
        }
    }
    xmlhttp.open("get","manage?i="+i +"&flag="+flag+"&fresh=" + Math.random(),true);
    xmlhttp.send();
}

function buttonadd(id1,id2,sty) {
    document.getElementById(id1).style=sty;
    document.getElementById(id2).style=sty;
}

function dyndel() {
    var i =document.getElementById("input").value;
    var flag=3;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("info").innerHTML=xmlhttp.responseText; //拿到处理后的数据塞回backdyn
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}