package Servlet;

import DAO.userDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "manage_per",urlPatterns = "/manper")
public class manage_per extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session =request.getSession();

        String password = request.getParameter("userpassword");
        String user = (String) session.getAttribute("user");

        userDAO userDAO =new userDAO();
        try {
            userDAO.update(user,password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("flag",11);
        request.setAttribute("user","user");
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
