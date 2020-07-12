package Servlet;

import DAO.userDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "login",urlPatterns = "/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session = request.getSession();
        String user = request.getParameter("username");
        String password = request.getParameter("userpassword");

        int flag =0;
        userDAO abc = new userDAO();
        JavaBean.user ab = new JavaBean.user();
        JavaBean.user a = null;

        ab.setName(user);
        ab.setPassword(password);
        try {
            a = abc.finduser(ab.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (a.getPassword().equals(password)){
            if (a.getPower() ==3){
                session.setAttribute("user",user);
                request.setAttribute("flag",a.getPower());
                request.setAttribute("user",user);
                request.getRequestDispatcher("/result.jsp").forward(request,response);
            }

            if (a.getPower() ==2){
                session.setAttribute("user",user);
                request.setAttribute("flag",a.getPower());
                request.setAttribute("user",user);
                request.getRequestDispatcher("/result.jsp").forward(request,response);
            }
        }
        else {
            session.setAttribute("user",user);
            request.setAttribute("flag",10);
            request.setAttribute("user",user);
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
