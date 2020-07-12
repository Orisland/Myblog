package Servlet;

import DAO.*;
import JavaBean.Dynamaic;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "txt",urlPatterns = "/txt")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DynamicDAO dynamicDAO =new DynamicDAO();
        int b =0;
        try {
            b =dynamicDAO.dynnum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ServletOutputStream out = response.getOutputStream();
            out.print(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
