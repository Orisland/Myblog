package Servlet;

import JavaBean.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import DAO.*;

@WebServlet(name = "log1",urlPatterns = "/log1")
public class log1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String str =request.getParameter("i");
        int i =Integer.parseInt(str);
        String str1="";

        Data abc = new Data();
        try {
            str1=abc.Data3(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = response.getWriter();
            out.print(str1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
