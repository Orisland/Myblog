package DAO;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import db.JdbcUtil;
import JavaBean.*;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class logDAO {

    public int max() throws Exception{
        int max=0;
        Connection conn = JdbcUtil.getConnection();
        String sql = "select MAX(id) FROM log";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        max = rs.getInt(1);
        JdbcUtil.free(rs,ps,conn);
        return max;
    }

    public int getPageCount() throws Exception{
        int recordCount =0, t1 = 0, t2 = 0;
        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) FROM log";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        recordCount = rs.getInt(1);
        t1 =recordCount%5;
        t2 = recordCount/5;
        JdbcUtil.free(rs,ps,conn);
        return t1==0?t2:t2+1;
    }

    public int getPageCount(String date) throws Exception{
        int recordCount =0, t1 = 0, t2 = 0;
        date += "%";
        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) FROM log where date LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, date);
        ResultSet rs = ps.executeQuery();
        rs.next();
        recordCount = rs.getInt(1);
        t1 =recordCount%5;
        t2 = recordCount/5;
        JdbcUtil.free(rs,ps,conn);
        return t1==0?t2:t2+1;
    }

    public int getPageCount1(String writer) throws Exception{
        int recordCount =0, t1 = 0, t2 = 0;
        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) FROM log where writer = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,writer);
        ResultSet rs = ps.executeQuery();
        rs.next();
        recordCount = rs.getInt(1);
        t1 =recordCount%5;
        t2 = recordCount/5;
        JdbcUtil.free(rs,ps,conn);
        return t1==0?t2:t2+1;
    }

    public int getPageCount1(String date,String writer) throws Exception{
        int recordCount =0, t1 = 0, t2 = 0;
        date += "%";
        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) FROM log where writer = ? and date like ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,writer);
        ps.setString(2, date);
        ResultSet rs = ps.executeQuery();
        rs.next();
        recordCount = rs.getInt(1);
        t1 =recordCount%5;
        t2 = recordCount/5;
        JdbcUtil.free(rs,ps,conn);
        return t1==0?t2:t2+1;
    }

    public List<log> listTest(int pageNo) throws Exception{
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        String t;
        ArrayList<log> logArrayList =new ArrayList<log>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from log order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,startRecno);
        ps.setInt(2,pageSize);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            JavaBean.log log =new log();
            log.setId(rs.getInt(1));
            log.setName(rs.getString(2));
            t=rs.getString(3);
            if (t.length()<=10){
                log.setText(t);
            }
            else {
                log.setText(t.substring(0,10)+"......"); //截取10个字符
            }
            log.setPicid(rs.getString(4));
            log.setWriter(rs.getString(5));
            log.setDate(rs.getDate(6));
            logArrayList.add(log);
        }
        JdbcUtil.free(rs,ps,conn);
        return logArrayList;
    }

    public List<log> listTest(int pageNo,String date) throws Exception{
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<log> logArrayList =new ArrayList<log>();
        Connection conn = JdbcUtil.getConnection();
        date += "%";
        String t;
        String sql = "select * from log WHERE date LIKE ? order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, date);
        ps.setInt(2,startRecno);
        ps.setInt(3,pageSize);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            JavaBean.log log =new log();
            log.setId(rs.getInt(1));
            log.setName(rs.getString(2));
            t=rs.getString(3);
            if (t.length()<=10){
                log.setText(t);
            }
            else {
                log.setText(t.substring(0,10)+"......"); //截取10个字符
            }
            log.setPicid(rs.getString(4));
            log.setWriter(rs.getString(5));
            log.setDate(rs.getDate(6));
            logArrayList.add(log);
        }
        JdbcUtil.free(rs,ps,conn);
        return logArrayList;
    }

    public List<log> listTest1(int pageNo,String writer) throws Exception{
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        String t;
        ArrayList<log> logArrayList =new ArrayList<log>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from log where writer = ? order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,writer);
        ps.setInt(2,startRecno);
        ps.setInt(3,pageSize);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            JavaBean.log log =new log();
            log.setId(rs.getInt(1));
            log.setName(rs.getString(2));
            t=rs.getString(3);
            if (t.length()<=10){
                log.setText(t);
            }
            else {
                log.setText(t.substring(0,10)+"......"); //截取10个字符
            }
            log.setPicid(rs.getString(4));
            log.setWriter(rs.getString(5));
            log.setDate(rs.getDate(6));
            logArrayList.add(log);
        }
        JdbcUtil.free(rs,ps,conn);
        return logArrayList;
    }

    public List<log> listTest1(int pageNo,String date,String writer) throws Exception{
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<log> logArrayList =new ArrayList<log>();
        Connection conn = JdbcUtil.getConnection();
        date += "%";
        String t;
        String sql = "select * from log WHERE date LIKE ? and writer = ? order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,writer);
        ps.setString(2, date);
        ps.setInt(3,startRecno);
        ps.setInt(4,pageSize);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            JavaBean.log log =new log();
            log.setId(rs.getInt(1));
            log.setName(rs.getString(2));
            t=rs.getString(3);
            if (t.length()<=10){
                log.setText(t);
            }
            else {
                log.setText(t.substring(0,10)+"......"); //截取10个字符
            }
            log.setPicid(rs.getString(4));
            log.setWriter(rs.getString(5));
            log.setDate(rs.getDate(6));
            logArrayList.add(log);
        }
        JdbcUtil.free(rs,ps,conn);
        return logArrayList;
    }

    public int lognum() throws Exception {                //日志总数
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT COUNT(`id`) FROM log";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return num;
    }

    public void add(log log) throws Exception {               //添加log到数据库
        Connection conn = null;
        PreparedStatement ps = null;

        java.util.Date utilDate = new java.util.Date();         //获取当前时间
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//变成sqldate……这还要转就离谱,Timestamp防丢时分秒

        try {
            conn = JdbcUtil.getConnection();//静态方法调用
            String sql = "insert into log values (?,?,?,?,?,?) ";
            ps = conn.prepareStatement(sql);//预处理
            ps.setInt(1, log.getId());
            ps.setString(2, log.getName());
            ps.setString(3,log.getText());
            ps.setString(4,log.getPicid());
            ps.setTimestamp(6,sqlDate);
            ps.setString(5,log.getWriter());

            ps.executeUpdate();//执行处理语句

        } finally {
            JdbcUtil.free(null, ps, conn);//释放资源
        }
    }

    public List<log> logfind(String date) throws Exception {        //日期模糊查询log
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        date += "%";
        String t ="";
        List<log> loglist = new ArrayList<log>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM log WHERE date LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                log log =new log();
                log.setId(rs.getInt(1));
                log.setName(rs.getString(2));
                t=rs.getString(3);
                if (t.length()<=10){
                    log.setText(t);
                }
                else {
                    log.setText(t.substring(0,10)+"......"); //截取10个字符
                }
                log.setPicid(rs.getString(4));
                log.setWriter(rs.getString(5));
                log.setDate(rs.getDate(6));
                loglist.add(log);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return loglist;
    }

    public log logidfind(int i) throws Exception{           //按ID查询日志
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        log log = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM log where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                log =new log();
                log.setId(rs.getInt(1));
                log.setName(rs.getString(2));
                log.setText(rs.getString(3));
                log.setPicid(rs.getString(4));
                log.setWriter(rs.getString(5));
                log.setDate(rs.getDate(6));
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return log;
    }



    public String logID(int i) throws Exception{           //按ID查询日志
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String info ="no";
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM log where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                info="请选择更改方式!";
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return info;
    }

    public void logdel(int id) throws Exception {           //按id删日志
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "delete from log where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }

    public void update(log log) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        java.util.Date utilDate = new java.util.Date();         //获取当前时间
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//变成sqldate……这还要转就离谱,Timestamp防丢时分秒
        try {
            conn = JdbcUtil.getConnection();
            String sql = "update log set name=?,text=?,picid=?,writer=?,date=? where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, log.getName());
            ps.setString(2, log.getText());
            ps.setString(3, log.getPicid());
            ps.setString(4, log.getWriter());
            ps.setTimestamp(5, sqlDate);
            ps.setInt(6,log.getId());
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }

    public String picadd(HttpServletRequest request, HttpServletResponse response, ServletConfig ServletConfig, int flag) throws Exception {
                                                                                                        //log图片上载
        java.util.Date utilDate = new java.util.Date();         //获取当前时间
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//变成sqldate……这还要转就离谱,Timestamp防丢时分秒
        String time = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss").format(sqlDate);      //把这种特殊的时间改为String类型
        HttpSession session = request.getSession();
        SmartUpload smart =new SmartUpload();
        smart.initialize(ServletConfig,request,response);
        logDAO logDAO =new logDAO();

        try {
            smart.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        String ext=smart.getFiles().getFile(0).getFileExt();

        String name="";
        try {
            name= time+"."+ext;
        } catch (Exception e) {
            e.printStackTrace();
        }
        JavaBean.pic pic = new JavaBean.pic();
        String name1 = "Rubbish";
        if (ext.equals("")){
            name = "nbsp.png";
        }
        else {
            name1 = name;
        }
        pic.setPicid(time+name);
        pic.setFlag(flag);

         logDAO.picadd(pic);         //同时写入pic数据库一份
        try {
            smart.getFiles().getFile(0).saveAs("E:\\IdeaLib\\Myblog\\out\\artifacts\\web_war_exploded\\image\\pic\\"+name1);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        session.setAttribute("logname",smart.getRequest().getParameter("logname"));
        session.setAttribute("logtext",smart.getRequest().getParameter("logtext"));
        session.setAttribute("id",smart.getRequest().getParameter("flag"));

        return name;
    }

    public  void picadd(JavaBean.pic pic) throws Exception {                        //log图片上载
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JdbcUtil.getConnection();//静态方法调用
            String sql = "insert into pic values (?,?) ";
            ps = conn.prepareStatement(sql);//预处理
            ps.setString(1, pic.getPicid());
            ps.setInt(2, pic.getFlag());

            ps.executeUpdate();//执行处理语句

        } finally {
            JdbcUtil.free(null, ps, conn);//释放资源
        }
    }

}
