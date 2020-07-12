package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.*;
import JavaBean.*;

@WebServlet(name = "manageC",urlPatterns = "/man")
public class manageC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String user1 = request.getParameter("user");
        String flag0 =request.getParameter("flag");
        int flag =Integer.parseInt(flag0);

        userDAO userDAO =new userDAO();
        user user = null;

        try{
            user = userDAO.finduser(user1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (user.getPower() == 3){
            PrintWriter out = response.getWriter();
            out.print("admin");
            user=null;
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("normal");
            user=null;
        }
    }
}
