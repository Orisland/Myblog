package Servlet;

import DAO.messageDAO;
import JavaBean.message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Dynamic_2",urlPatterns = "/dyn2")
public class Dynamic_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=GBK");
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
            request.getRequestDispatcher("/dynamic.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String message =request.getParameter("message");
        String flag0 = request.getParameter("flag");
        int flag = Integer.parseInt(flag0);
        List<message> messageList = null;
        HttpSession session = request.getSession();

        JavaBean.message mes =new message();
        messageDAO mesDAO =new messageDAO();

        if (flag==1){
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
                try {
                    PrintWriter out = response.getWriter();
                    out.print("添加完成");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (flag ==2){
            session.setAttribute("user","");
            session.setAttribute("flag",8);
        }

        if (flag == 3){
            String str="";
            try {
                messageList = mesDAO.messageList(1);
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
