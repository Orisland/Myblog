package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.lang.String.*;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import static com.jspsmart.upload.SmartUpload.SAVE_VIRTUAL;

@WebServlet(name = "test",urlPatterns = "/test")
public class test extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");

        SmartUpload smart = new SmartUpload();
        ServletConfig config =this.getServletConfig();
        smart.initialize(config,request,response);

        try {
            smart.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        try {
            smart.save("/upload");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
