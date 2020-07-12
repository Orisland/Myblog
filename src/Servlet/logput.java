package Servlet;

import DAO.*;
import JavaBean.*;
import JavaBean.log;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(name = "logput",urlPatterns = "/logput")
public class logput extends HttpServlet {
    private ServletConfig servletConfig;
    public void init(ServletConfig config) throws ServletException{
        this.servletConfig = config;
    }

    public ServletConfig getServletConfig(){
        return servletConfig;
    }
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
        else {
            String writer = (String) session.getAttribute("user");


            log log =new log();
            String str = "";
            int i = 0;

            logDAO logDAO =new logDAO();

            try {
                str = logDAO.picadd(request,response,getServletConfig(),flag);       //获取上传完成的照片名字
            } catch (Exception e) {
                e.printStackTrace();
            }

            String logname = (String) session.getAttribute("logname");
            String logtext = (String) session.getAttribute("logtext");

            try {
                i = logDAO.max()+1;                                  //获取log表的条数
            } catch (Exception e) {
                e.printStackTrace();
            }

            log.setId(i);
            log.setName(logname);
            log.setText(logtext);
            log.setPicid(str);      //date直接在DAO里塞
            log.setWriter(writer);

            try {
                logDAO.add(log);                                   //向数据库写入log数据
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("flag",5);
            request.setAttribute("user","博文发表完成！");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
