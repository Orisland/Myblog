package Servlet;

import DAO.*;
import JavaBean.Data;
import JavaBean.message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "log0",urlPatterns = "/log0")
public class log extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        String message =request.getParameter("message");
        String flag0 = request.getParameter("flag");
        int flag = Integer.parseInt(flag0);
        JavaBean.message mes =new message();
        messageDAO mesDAO =new messageDAO();
        int i =0;
        try {
            i = mesDAO.max();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ((String) session.getAttribute("user")==null || (String) session.getAttribute("user")==""){
            request.setAttribute("flag",6);
            request.setAttribute("user","请先登陆！");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
        else {
            String writer = (String) session.getAttribute("user");
            mes.setUsername(writer);
            mes.setNote(message);
            mes.setFlag(flag);
            mes.setId(i+1);
            try {
                mesDAO.messageadd(mes);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/log.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        HttpSession session = request.getSession();

        Data abcd =new Data();
        logDAO logDAO =new logDAO();
        int num=0;
        String str="";
        int num1=0;
        try {
            num =logDAO.lognum();
            num1 = logDAO.max();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("lognum",num);

        try {
            str=abcd.Data2(num1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = response.getWriter();
            out.print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
