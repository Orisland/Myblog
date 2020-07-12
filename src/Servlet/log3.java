package Servlet;

import DAO.messageDAO;
import JavaBean.message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "log3",urlPatterns = "/log3")
public class log3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");

        String message =request.getParameter("message");
        String flag0 = request.getParameter("flag");
        int flag = Integer.parseInt(flag0);
        List<JavaBean.message> messageList = null;

        JavaBean.message mes =new message();
        messageDAO mesDAO =new messageDAO();

        if (flag == 3){
            String str="";
            try {
                messageList = mesDAO.messageList(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for(int i =messageList.size()-1; i>=0; i--){
                str += messageList.get(i).toString();
                str += "\r";
            }
            PrintWriter out = response.getWriter();
            out.print(str);

        }
    }
}
