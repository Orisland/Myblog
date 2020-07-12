package Servlet;

import DAO.DynamicDAO;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updatedyn",urlPatterns = "/updyn")
public class updatedyn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();

        SmartUpload smartUpload =new SmartUpload();
        smartUpload.initialize(getServletConfig(),request,response);
        int flag = 2;

        if ((String) session.getAttribute("user")==null){
            request.setAttribute("flag",6);
            request.setAttribute("user","请先登陆！");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }

        String writer = (String) session.getAttribute("user");

        JavaBean.Dynamaic dynamaic =new JavaBean.Dynamaic();
        String str = "";

        DynamicDAO dynamicDAO = new DynamicDAO();

        try {
            str = dynamicDAO.picadd(request,smartUpload,flag);       //获取上传完成的照片名字
        } catch (Exception e) {
            e.printStackTrace();
        }

        String id0 =(String) session.getAttribute("id");
        int id =Integer.parseInt(id0);
        String dyntext = (String) session.getAttribute("dyntext");

        dynamaic.setId(id);
        dynamaic.setText(dyntext);
        dynamaic.setPicid(str);      //date直接在DAO里塞
        dynamaic.setWriter(writer);

        try {
            dynamicDAO.update(dynamaic);                                   //向数据库写入dyn数据
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("flag",7);
        request.setAttribute("user","动态修改完成！");
        request.getRequestDispatcher("/result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
