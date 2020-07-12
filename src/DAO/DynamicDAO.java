package DAO;

import JavaBean.*;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import db.JdbcUtil;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DynamicDAO extends HttpServlet {

    public int max() throws Exception{
        int max=0;
        Connection conn = JdbcUtil.getConnection();
        String sql = "select MAX(id) FROM dynamic";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        max = rs.getInt(1);
        JdbcUtil.free(rs,ps,conn);
        return max;
    }

    public int getPageCount() throws Exception{     //
        int recordCount =0, t1 = 0, t2 = 0;
        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) FROM dynamic";
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
        String sql = "select count(*) FROM dynamic where date LIKE ?";
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
        String sql = "select count(*) FROM dynamic where writer = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, writer);
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
        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) FROM dynamic where writer = ? and date like ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, writer);
        ps.setString(2,date);
        ResultSet rs = ps.executeQuery();
        rs.next();
        recordCount = rs.getInt(1);
        t1 =recordCount%5;
        t2 = recordCount/5;
        JdbcUtil.free(rs,ps,conn);
        return t1==0?t2:t2+1;
    }

    public List<Dynamaic> listTest(int pageNo) throws Exception{            //这是列举全部的方法
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<Dynamaic> dynamicArrayList =new ArrayList<Dynamaic>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from dynamic order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,startRecno);
        ps.setInt(2,pageSize);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Dynamaic dynamic =new Dynamaic();
            dynamic.setId(rs.getInt(1));
            dynamic.setWriter(rs.getString(2));
            String t ="";
            t=rs.getString(3);
            if (t.length()<=20){
                dynamic.setText(t);
            }
            else {
                dynamic.setText(t.substring(0,15)+"......"); //截取10个字符
            }
            dynamic.setPicid(rs.getString(4));
            dynamic.setDate(rs.getDate(5));
            dynamicArrayList.add(dynamic);
        }
        JdbcUtil.free(rs,ps,conn);
        return dynamicArrayList;
    }

    public List<Dynamaic> listTest(int pageNo,String date) throws Exception{            //这是列举这是按日期的方法
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<Dynamaic> dynamicArrayList =new ArrayList<Dynamaic>();
        Connection conn = JdbcUtil.getConnection();
        date += "%";
        String sql = "select * from dynamic WHERE date LIKE ? order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, date);
        ps.setInt(2,startRecno);
        ps.setInt(3,pageSize);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Dynamaic dynamic =new Dynamaic();
            dynamic.setId(rs.getInt(1));
            dynamic.setWriter(rs.getString(2));
            String t ="";
            t=rs.getString(3);
            if (t.length()<=20){
                dynamic.setText(t);
            }
            else {
                dynamic.setText(t.substring(0,15)+"......"); //截取10个字符
            }
            dynamic.setPicid(rs.getString(4));
            dynamic.setDate(rs.getDate(5));
            dynamicArrayList.add(dynamic);
        }
        JdbcUtil.free(rs,ps,conn);
        return dynamicArrayList;
    }

    public List<Dynamaic> listTest1(int pageNo,String writer) throws Exception{            //这是列举全部的方法
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<Dynamaic> dynamicArrayList =new ArrayList<Dynamaic>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from dynamic where writer =? order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,writer);
        ps.setInt(2,startRecno);
        ps.setInt(3,pageSize);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Dynamaic dynamic =new Dynamaic();
            dynamic.setId(rs.getInt(1));
            dynamic.setWriter(rs.getString(2));
            String t ="";
            t=rs.getString(3);
            if (t.length()<=20){
                dynamic.setText(t);
            }
            else {
                dynamic.setText(t.substring(0,15)+"......"); //截取10个字符
            }
            dynamic.setPicid(rs.getString(4));
            dynamic.setDate(rs.getDate(5));
            dynamicArrayList.add(dynamic);
        }
        JdbcUtil.free(rs,ps,conn);
        return dynamicArrayList;
    }

    public List<Dynamaic> listTest1(int pageNo,String date,String writer) throws Exception{            //这是列举这是按日期的方法
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<Dynamaic> dynamicArrayList =new ArrayList<Dynamaic>();
        Connection conn = JdbcUtil.getConnection();
        date += "%";
        String sql = "select * from dynamic WHERE date LIKE ? and writer =? order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, date);
        ps.setString(2,writer);
        ps.setInt(3,startRecno);
        ps.setInt(4,pageSize);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Dynamaic dynamic =new Dynamaic();
            dynamic.setId(rs.getInt(1));
            dynamic.setWriter(rs.getString(2));
            String t ="";
            t=rs.getString(3);
            if (t.length()<=20){
                dynamic.setText(t);
            }
            else {
                dynamic.setText(t.substring(0,15)+"......"); //截取10个字符
            }
            dynamic.setPicid(rs.getString(4));
            dynamic.setDate(rs.getDate(5));
            dynamicArrayList.add(dynamic);
        }
        JdbcUtil.free(rs,ps,conn);
        return dynamicArrayList;
    }

    public String dnypicid(int i) throws Exception {            //动态图片id获取
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String text = "";

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select picid from dynamic where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                text = rs.getString(1);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return text;
    }

    public void dynadd(JavaBean.Dynamaic dyn) throws Exception {               //添加dyn到数据库
        Connection conn = null;
        PreparedStatement ps = null;

        java.util.Date utilDate = new java.util.Date();         //获取当前时间
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//变成sqldate……这还要转就离谱,Timestamp防丢时分秒

        try {
            conn = JdbcUtil.getConnection();//静态方法调用
            String sql = "insert into dynamic values (?,?,?,?,?) ";
            ps = conn.prepareStatement(sql);//预处理
            ps.setInt(1, dyn.getId());
            ps.setString(2, dyn.getWriter());
            ps.setString(3,dyn.getText());
            ps.setString(4,dyn.getPicid());
            ps.setTimestamp(5,sqlDate);

            ps.executeUpdate();//执行处理语句

        } finally {
            JdbcUtil.free(null, ps, conn);//释放资源
        }
    }

    public List<JavaBean.Dynamaic> dnytimefind(String date) throws Exception {      //dyn时间模糊查询
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        date += "%";
        String t ="";
        List<JavaBean.Dynamaic> dynlist = new ArrayList<JavaBean.Dynamaic>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM dynamic WHERE date LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                JavaBean.Dynamaic dyn =new JavaBean.Dynamaic();
                dyn.setId(rs.getInt(1));
                dyn.setWriter(rs.getString(2));
                t=rs.getString(3);
                if (t.length()<=20){
                    dyn.setText(t);
                }
                else {
                    dyn.setText(t.substring(0,15)+"......"); //截取10个字符
                }
                dyn.setPicid(rs.getString(4));
                dyn.setDate(rs.getDate(5));
                dynlist.add(dyn);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return dynlist;
    }

    public String dynID(int i) throws Exception{           //按ID查询dyn
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        JavaBean.Dynamaic dyn = new JavaBean.Dynamaic();
        String info ="no";
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM dynamic where id=?";
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

    public String dnytext(int i) throws Exception {                 //按id获取dyu内容
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String text = "";

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select text from dynamic where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                text = rs.getString(1);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return text;
    }

    public String dnytime(int i) throws Exception {             //按id获得日期
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String text = "";

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select date from dynamic where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                text = rs.getString(1);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return text;
    }

    public String dnywriter(int i) throws Exception {           //按id获取作者
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String text = "";

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select writer from dynamic where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                text = rs.getString(1);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return text;
    }

    public Dynamaic dynfind(int i) throws Exception{           //按ID查询动态
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Dynamaic dynamaic  = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM dynamic where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                dynamaic =new Dynamaic();
                dynamaic.setId(rs.getInt(1));
                dynamaic.setWriter(rs.getString(2));
                dynamaic.setText(rs.getString(3));
                dynamaic.setPicid(rs.getString(4));
                dynamaic.setDate(rs.getDate(5));
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return dynamaic;
    }

    public void delete(int id) throws Exception {           //按id删dyn
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "delete from dynamic where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }

    public void update(Dynamaic dynamaic) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        java.util.Date utilDate = new java.util.Date();         //获取当前时间
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//变成sqldate……这还要转就离谱,Timestamp防丢时分秒
        try {
            conn = JdbcUtil.getConnection();
            String sql = "update dynamic set writer=?,text=?,picid=?,date=? where id=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dynamaic.getWriter());
            ps.setString(2, dynamaic.getText());
            ps.setString(3, dynamaic.getPicid());
            ps.setTimestamp(4, sqlDate);
            ps.setInt(5,dynamaic.getId());
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }

    public String picadd(HttpServletRequest request,SmartUpload smart, int flag) throws Exception {             //dyn图片上传

        java.util.Date utilDate = new java.util.Date();         //获取当前时间
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//变成sqldate……这还要转就离谱,Timestamp防丢时分秒
        String time = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss").format(sqlDate);      //把这种特殊的时间改为String类型
        HttpSession session = request.getSession();

        DynamicDAO ab =new DynamicDAO();

        try {
            smart.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        session.setAttribute("id",smart.getRequest().getParameter("flag"));
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
        try{
            ab.picadd(pic);         //同时写入pic数据库一份
        }
        catch (Exception e){
            e.printStackTrace();
        }

        session.setAttribute("dyntext",smart.getRequest().getParameter("dyntext"));

        try {
            smart.getFiles().getFile(0).saveAs("E:\\IdeaLib\\Myblog\\out\\artifacts\\web_war_exploded\\image\\pic\\"+name1);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        return name;
    }

    public  void picadd(JavaBean.pic pic) throws Exception {                //pic塞数据库附加
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

    public int dynnum() throws Exception {                     //动态总数
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT COUNT(`id`) FROM dynamic";
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
}
