package JavaBean;

import DAO.*;

public class Data {
    public String Data1(int i) throws Exception {         //动态所有div内容整合
        String Data1 ="";
        String str1 ="";        //作者
        String str2 ="";       //内容
        String str3 ="";        //时间
        String str4 ="";        //图片

        DynamicDAO dynamicDAO = new DynamicDAO();
        for (int j=i; j>=1; j--){


            try{
                str1=dynamicDAO.dnywriter(j);                  //作者
                str2=dynamicDAO.dnytext(j);                    //内容
                str3=dynamicDAO.dnytime(j);                    //时间
                str4 =dynamicDAO.dnypicid(j);

                if (str1 == null || str1 == ""){
                    continue;
                }
                if (str4 == null){
                    str4 = "nbsp.png";
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Data1 += "<div class=dt id=dyn"+j+">";     //创建div
            Data1 += "<p>"+str1+":</p>";            //塞内容
            Data1 += "<p>"+str2+"</p>";       //塞作者
            Data1 +="<img style=\"max-height: 400px\" src=\"image/pic/" + str4 +"\">";
            Data1 += "<p>发布时间:"+str3+"</p></div><br>";    //塞时间
        }

        return Data1;
    }

    public String Data2(int i) throws Exception {               //日志左侧按钮塞入
        String Data2="";
        logDAO logDAO = new logDAO();
        log log =null;

        for (int j=i; j>=1; j--){
            log = logDAO.logidfind(j);
            if (log == null){
                continue;
            }
            Data2 +=log.getId()+"·····<button id=\""+log.getId()+"\" type=\"button\" onclick=\"buttonadd(this)\">";
            Data2 +=log.getName()+"</button><br>";
        }

        return Data2;
    }

    public String Data3(int i) throws Exception{
        String Data3="";
        logDAO logDAO = new logDAO();
        log log =null;

        log = logDAO.logidfind(i);
        if (log.getPicid() == null){
            log.setPicid("nbsp.png");
        }

        Data3 += "<h1>"+log.getName()+"</h1><h3>作者："+log.getWriter()+"</h3><h3>发布时间："+log.getDate()+"</h3><br><br><br>"+log.getText()+"<br><br><br>";
        Data3 += "<img style=\"max-height: 500px\" src=\"image/pic/" + log.getPicid() +"\">";
               // "<div style=\"width:100%;height:100%;background-repeat:no-repeat;\n" +
                //"\tbackground-attachment: fixed;\n" +
                //"\tbackground-origin: border-box;\n" +
               // "\tbackground-size:100% 100%;background-image:url('image/pic/"+log.getPicid()+"')\">";      //返回图片数据
        return Data3;
    }

    public String Data4() throws Exception{
        String Data4 = "";
        messageDAO abc =new messageDAO();


        return Data4;
    }
}
