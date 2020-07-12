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
function text_input(object) {
    document.getElementById("logname").value = object.value;
}
function text_input1(object) {
    document.getElementById("logtext").value = object.value;
}

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