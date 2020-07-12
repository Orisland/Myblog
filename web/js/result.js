var flag = document.getElementById("flag").value;
var user = document.getElementById("info").value;

if (flag ==0) {
    alert("用户名:"+user+"注册失败!\r用户名已存在!\n单机确定返回重新注册!");
    window.location.href='register.jsp';
    sessionStorage.setItem("user",user);
}

if (flag == 1){
    alert("用户名:"+user+"注册成功!\n请重新登录!");
    window.location.href='login.jsp';
    sessionStorage.setItem("user",user);
}

if (flag ==2){
    alert("登陆成功！\n欢迎登陆！\r"+user);
    window.location.href='dynamic.jsp';
    sessionStorage.setItem("user",user);
}

if (flag ==3){
    alert("登陆成功！ \n欢迎登陆！\r管理员:"+user);
    window.location.href='dynamic.jsp';
    sessionStorage.setItem("user",user);
}

if (flag ==4){                              //照片错误4
    alert(user);
    window.location.href='log_put.jsp';
}

if (flag ==5){                              //log发布完成5
    alert(user);
    window.location.href='log.jsp';
}

if (flag ==6){
    alert(user);
    window.location.href='login.jsp';
}

if (flag ==7){
    alert(user);
    window.location.href='dynamic.jsp';
}
if (flag==8){
    alert("已登出!");
    window.location.href='dynamic.jsp';
}

if (flag==9){
    alert("请勿越级操作！");
    window.location.href='dynamic.jsp';
}

if (flag==10){
    alert("用户名或密码错误，请重新尝试登陆!");
    window.location.href='login.jsp';
}

if (flag==11){
    alert("密码修改完成！请重新登录！");
    window.location.href='login.jsp';
}