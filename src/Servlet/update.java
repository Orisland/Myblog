package Servlet;

import DAO.*;
import JavaBean.*;
import JavaBean.log;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "update",urlPatterns = "/up")
public class update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=GBK");
        HttpSession session = request.getSession();

        int flag = 1;

        if ((String) session.getAttribute("user")==null || (String) session.getAttribute("user")==""){
            request.setAttribute("flag",6);
            request.setAttribute("user","请先登陆！");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }

        String writer = (String) session.getAttribute("user");

        log log =new log();
        String str = "";

        logDAO logDAO =new logDAO();

        try {
            str = logDAO.picadd(request,response,getServletConfig(),flag);       //获取上传完成的照片名字
        } catch (Exception e) {
            e.printStackTrace();
        }

        String logname = (String) session.getAttribute("logname");
        String logtext = (String) session.getAttribute("logtext");
        String id0 =(String) session.getAttribute("id");
        int id =Integer.parseInt(id0);

        log.setId(id);
        log.setName(logname);
        log.setText(logtext);
        log.setPicid(str);      //date直接在DAO里塞
        log.setWriter(writer);

        try {
            logDAO.update(log);                                   //向数据库写入log数据
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("flag",5);
        request.setAttribute("user","博文修改完成！");
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=GBK");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");

        String flag0 =request.getParameter("flag");
        String id0 =request.getParameter("id");

        int flag =Integer.parseInt(flag0);
        int id =Integer.parseInt(id0);

        JavaBean.Dynamaic dynamaic =null;
        log log =null;
        logDAO logDAO =new logDAO();
        DynamicDAO dynamicDAO =new DynamicDAO();
        try {
            dynamaic = dynamicDAO.dynfind(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            log =logDAO.logidfind(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag ==1){
            PrintWriter out = response.getWriter();
            out.print(log.getName());
        }

        if (flag ==2){
            PrintWriter out = response.getWriter();
            out.print(log.getText());
        }

        if (flag ==3){
            PrintWriter out = response.getWriter();
            out.print(dynamaic.getText());
        }

        if (flag ==4){
            if (dynamaic.getPicid() == null){
                dynamaic.setPicid("nbsp.png");
            }
            PrintWriter out = response.getWriter();
            out.print("<img style=\"max-width: 200px\" src=\"image/pic/" + dynamaic.getPicid() +"\">");
        }

        if (flag ==5){
            if (log.getPicid() == null || log.getPicid() == ""){
                log.setPicid("nbsp.png");
            }
            PrintWriter out = response.getWriter();
            out.print("<img style=\"max-width: 200px\" src=\"image/pic/" + log.getPicid() +"\">");
        }
    }
}
