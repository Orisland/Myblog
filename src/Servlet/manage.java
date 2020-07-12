package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DAO.*;
import JavaBean.*;
import JavaBean.log;

@WebServlet(name = "manage",urlPatterns = "/manage")
public class manage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");

        String str = request.getParameter("i");
        String flag = request.getParameter("flag");
        JavaBean.Dynamaic abc = new JavaBean.Dynamaic();
        JavaBean.log abcd = new JavaBean.log();
        user user = new user();
        message message = new message();
        logDAO a = new logDAO();
        DynamicDAO ab = new DynamicDAO();
        userDAO userDAO = new userDAO();
        messageDAO messageDAO = new messageDAO();

        if (flag.equals("1")){      //这是查询动态列表
            List<JavaBean.Dynamaic> dyn=null;
            try {
                dyn = ab.dnytimefind(str);//调用查询记录方法
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(int i =0; i<dyn.size(); i++){
                try {
                    PrintWriter out = response.getWriter();
                    out.print(dyn.get(i).toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("2")){      //这是查询动态id
            int i =Integer.parseInt(str);
            String str1="";

            try {
                str1 = ab.dynID(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (str1.equals("请选择更改方式!")==true){
                try {
                    PrintWriter out = response.getWriter();
                    out.print("请选择更改方式!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    PrintWriter out = response.getWriter();
                    out.print("该ID不存在!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("3")){
            int i =Integer.parseInt(str);
            try {
                ab.delete(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                PrintWriter out = response.getWriter();
                out.print("该id动态删除成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //==========================================//下面都是博文的
        if (flag.equals("4")){                              //博文列举
            List<log> log=null;
            try {
                log = a.logfind(str);//调用查询记录方法
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(int i =0; i<log.size(); i++){
                try {
                    PrintWriter out = response.getWriter();
                    out.print(log.get(i).toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("5")){                              //博文id查询
            int i =Integer.parseInt(str);
            String str1="";

            try {
                str1 = a.logID(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (str1.equals("请选择更改方式!")==true){
                try {
                    PrintWriter out = response.getWriter();
                    out.print("请选择更改方式!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    PrintWriter out = response.getWriter();
                    out.print("该ID不存在!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("6")){
            int i =Integer.parseInt(str);
            try {
                a.logdel(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                PrintWriter out = response.getWriter();
                out.print("该id日志删除成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //=================================下面都是用户管理
        if (flag.equals("7")){
            List<user> userList=null;
            try {
                userList = userDAO.userfind();//调用查询记录方法
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(int i =0; i<userList.size(); i++){
                try {
                    PrintWriter out = response.getWriter();
                    out.print(userList.get(i).toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("8")){
            String str1="";

            try {
                str1 = userDAO.userfind(str);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (str1.equals("请选择更改方式!")==true){
                try {
                    PrintWriter out = response.getWriter();
                    out.print("请选择更改方式!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    PrintWriter out = response.getWriter();
                    out.print("该ID不存在!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("9")){
            try {
                userDAO.userdel(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                PrintWriter out = response.getWriter();
                out.print("该名称的用户删除成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //===============================================留言管理块
        if (flag.equals("10")){
            List<message> mes=null;
            try {
                mes = messageDAO.mestimefind(str);//调用查询记录方法
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(int i =0; i<mes.size(); i++){
                try {
                    PrintWriter out = response.getWriter();
                    out.print(mes.get(i).toString1());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("11")){
            int i =Integer.parseInt(str);
            String str1="";

            try {
                str1 = messageDAO.messageID(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (str1.equals("请选择更改方式!")==true){
                try {
                    PrintWriter out = response.getWriter();
                    out.print("请选择更改方式!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    PrintWriter out = response.getWriter();
                    out.print("该ID不存在!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag.equals("12")){
            int i =Integer.parseInt(str);
            try {
                messageDAO.delete(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                PrintWriter out = response.getWriter();
                out.print("该id留言删除成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
