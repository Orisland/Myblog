package Servlet;

import DAO.DynamicDAO;
import DAO.logDAO;
import DAO.messageDAO;
import DAO.userDAO;
import JavaBean.*;
import JavaBean.log;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "manage_page",urlPatterns = "/page")
public class manage_page extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session =request.getSession();

        String flag="";
        String flagstr="";
        String flagstr1= "";
        String time =request.getParameter("time");
        String time1 = (String) session.getAttribute("time");
        flagstr = request.getParameter("flagman");
        flagstr1 = (String) session.getAttribute("flagman");

        if ((String) session.getAttribute("user")==null || (String) session.getAttribute("user")==""){
            request.setAttribute("flag",6);
            request.setAttribute("user","请先登陆！");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
        else {
            String user =(String) session.getAttribute("user");
            userDAO userDAO =new userDAO();
            user user1 =null;
            int power=0;
            try {
                user1 = userDAO.finduser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(user1.getPower() != 3 && user1.getPower() !=2){
                request.setAttribute("flag",9);
                request.setAttribute("user","请勿越级操作！");
                request.getRequestDispatcher("/result.jsp").forward(request,response);
            }
            else {
                if (time ==null){
                    time = time1;
                }

                flag =flagstr1;
                if (flagstr != null){
                    flag = flagstr;
                }


                int pageNo =1;
                int pageSize =5;
                String strPageNo = request.getParameter("pageNo");

                if (strPageNo != null){
                    pageNo =Integer.parseInt(strPageNo);
                }

                DynamicDAO dynamicDAO = new DynamicDAO();
                logDAO logDAO =new logDAO();
                messageDAO messageDAO = new messageDAO();
                userDAO =new userDAO();

                if (flag.equals("1")){              //动态
                    try {
                        List<Dynamaic> dynamaicList = dynamicDAO.listTest(pageNo);
                        request.setAttribute("dynamiclist",dynamaicList);
                        Integer pageCount =new Integer(dynamicDAO.getPageCount());
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        session.setAttribute("flagman","1");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_pagedyn.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("2")){              //按时间查询
                    try {
                        List<Dynamaic> dynamaicList = dynamicDAO.listTest(pageNo,time);
                        request.setAttribute("dynamiclist",dynamaicList);
                        Integer pageCount =new Integer(dynamicDAO.getPageCount(time));
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        session.setAttribute("flagman","2");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_pagedyn.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("3")){              //日志
                    try {
                        List<JavaBean.log> logList = logDAO.listTest(pageNo);
                        request.setAttribute("logList",logList);
                        Integer pageCount =new Integer(logDAO.getPageCount());
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        request.setAttribute("flagman","3");
                        session.setAttribute("flagman","3");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_pagelog.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("4")){
                    try {
                        List<log> logList = logDAO.listTest(pageNo,time);
                        request.setAttribute("logList",logList);
                        Integer pageCount =new Integer(logDAO.getPageCount(time));
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        session.setAttribute("flagman","4");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_pagelog.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("5")){          //留言
                    try {
                        List<message> messageList = messageDAO.listTest(pageNo);
                        request.setAttribute("messageList",messageList);
                        Integer pageCount =new Integer(messageDAO.getPageCount());
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        request.setAttribute("flagman","5");
                        session.setAttribute("flagman","5");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_pagemessage.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("6")){
                    try {
                        List<message> messageList = messageDAO.listTest(pageNo,time);
                        request.setAttribute("messageList",messageList);
                        Integer pageCount =new Integer(messageDAO.getPageCount(time));
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        session.setAttribute("flagman","6");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_pagemessage.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("7")){          //用户
                    try {
                        List<user> userList = userDAO.listTest(pageNo);
                        request.setAttribute("userList",userList);
                        Integer pageCount =new Integer(userDAO.getPageCount());
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        request.setAttribute("flagman","7");
                        session.setAttribute("flagman","7");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_pageuser.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("8")){

                }
                //===============================person管理系统

                if (flag.equals("9")){
                    try {
                        List<Dynamaic> dynamaicList = dynamicDAO.listTest1(pageNo,user);
                        request.setAttribute("dynamiclist",dynamaicList);
                        Integer pageCount =new Integer(dynamicDAO.getPageCount1(user));
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        session.setAttribute("flagman","9");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_perdyn.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if (flag.equals("10")){
                    try {
                        List<Dynamaic> dynamaicList = dynamicDAO.listTest1(pageNo,time,user);
                        request.setAttribute("dynamiclist",dynamaicList);
                        Integer pageCount =new Integer(dynamicDAO.getPageCount1(time,user));
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        session.setAttribute("flagman","10");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_perdyn.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (flag.equals("11")){
                    try {
                        List<JavaBean.log> logList = logDAO.listTest1(pageNo,user);
                        request.setAttribute("logList",logList);
                        Integer pageCount =new Integer(logDAO.getPageCount1(user));
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        request.setAttribute("flagman","11");
                        session.setAttribute("flagman","11");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_perlog.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if (flag.equals("12")){
                    try {
                        List<log> logList = logDAO.listTest1(pageNo,time,user);
                        request.setAttribute("logList",logList);
                        Integer pageCount =new Integer(logDAO.getPageCount1(time,user));
                        request.setAttribute("pageCount",pageCount);
                        request.setAttribute("pageNo",pageNo);
                        session.setAttribute("flagman","12");
                        session.setAttribute("time",time);
                        RequestDispatcher rd = request.getRequestDispatcher("manage_perlog.jsp");
                        rd.forward(request,response);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if (flag.equals("13")){

                }
            }
        }
    }
}
