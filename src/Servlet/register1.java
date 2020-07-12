package Servlet;

import DAO.userDAO;
import JavaBean.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register1", urlPatterns = "/reg1")
public class register1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String name =request.getParameter("username");
        userDAO abc = new userDAO();
        user b = new user();

        try {
            b = abc.finduser(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (b == null){
            try {
                PrintWriter out = response.getWriter();
                out.print("该用户名可用！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                PrintWriter out = response.getWriter();
                out.print("该用户名已存在!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
