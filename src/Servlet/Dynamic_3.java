package Servlet;

import DAO.*;
import DAO.logDAO;
import JavaBean.*;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet(name = "Dynamic_3",urlPatterns = "/dyn3")
public class Dynamic_3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html; charset=GBK");
        HttpSession session = request.getSession();

        SmartUpload smartUpload =null;

        smartUpload =new SmartUpload();

        smartUpload.initialize(getServletConfig(),request,response);
        int flag = 2;

        if ((String) session.getAttribute("user")==null || (String) session.getAttribute("user")==""){
            request.setAttribute("flag",6);
            request.setAttribute("user","请先登陆！");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }

        else {
            String writer = (String) session.getAttribute("user");
            JavaBean.Dynamaic dynamaic =new JavaBean.Dynamaic();
            String str = "";
            int i = 0;

            DynamicDAO abc = new DynamicDAO();

            try {
                str = abc.picadd(request,smartUpload,flag);       //获取上传完成的照片名字
            } catch (Exception e) {
                e.printStackTrace();
            }

            String dyntext = (String) session.getAttribute("dyntext");

            try {
                i = abc.max()+1;                                  //获取dyn表的条数
            } catch (Exception e) {
                e.printStackTrace();
            }

            dynamaic.setId(i);
            dynamaic.setText(dyntext);
            dynamaic.setPicid(str);      //date直接在DAO里塞
            dynamaic.setWriter(writer);

            try {
                abc.dynadd(dynamaic);                                   //向数据库写入dyn数据
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("flag",7);
            request.setAttribute("user","动态发表完成！");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
