package Servlet;

import DAO.DynamicDAO;
import JavaBean.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Dynamic_1",urlPatterns = "/Dynamic_1")
public class Dynamic_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String str = request.getParameter("i");
        int i =Integer.parseInt(str);                   //总动态条数取得
        HttpSession session = request.getSession();
        DynamicDAO dynamicDAO =new DynamicDAO();
        try {
            int num = dynamicDAO.dynnum();
            session.setAttribute("dynum",num);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Data abc =new Data();
        String str1 = null;
        try {
            i = dynamicDAO.max();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            str1 = abc.Data1(i);
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
