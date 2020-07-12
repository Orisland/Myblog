function dyndel(id) {
    var i =id;
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
            alert("动态删除完成!");
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}

function updatedynamc(id) {
    sessionStorage.setItem("dynamicupdate",id);
    window.open("update_dynamic.jsp");
}

function logdel(id) {
    var i =id;
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
            alert("博文删除完成!");
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}

function updatelog(id) {
    sessionStorage.setItem("logupdate",id);
    window.open("update_log.jsp");
}

function mesdel(id) {
    var i =id;
    var flag=12;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            alert("留言删除完成!");
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}

function userdel(id) {
    var i =id;
    var flag=9;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            alert("用户删除完成!");
        }
    }
    xmlhttp.open("get","manage?i="+i+"&fresh=" + Math.random()+"&flag="+flag,true);
    xmlhttp.send();
}