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

function finduser(object) {
    var i =object.value;
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200){
            document.getElementById("user").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("get","reg1?username="+i,true);
    xmlhttp.send();
}
