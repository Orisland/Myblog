package Servlet;

import DAO.userDAO;
import JavaBean.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register",urlPatterns = "/reg")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String user = request.getParameter("username");
        String password = request.getParameter("userpassword");
        int flag=0;

        user a = new user();
        a.setName(user);
        a.setPassword(password);
        userDAO abc = new userDAO();

            try {
                abc.add(a);
            } catch (Exception e) {
                request.setAttribute("user",user);
                request.setAttribute("flag",0);
                request.getRequestDispatcher("/result.jsp").forward(request,response);
                e.printStackTrace();
            }

        request.setAttribute("flag",1);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
        }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
