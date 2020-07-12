package DAO;

import JavaBean.message;
import db.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class messageDAO {

    public int max() throws Exception{
        int max=0;
        Connection conn = JdbcUtil.getConnection();
        String sql = "select MAX(id) FROM message";
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
        String sql = "select count(*) FROM message";
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
        String sql = "select count(*) FROM message where date LIKE ?";
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

    public List<message> listTest(int pageNo) throws Exception{
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<message> messageArrayList =new ArrayList<message>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from message order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,startRecno);
        ps.setInt(2,pageSize);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            message message =new message();
            message.setId(rs.getInt(1));
            message.setUsername(rs.getString(2));
            String t=rs.getString(3);
            if (t.length()<=20){
                message.setNote(t);
            }
            else {
                message.setNote(t.substring(0,15)+"......"); //截取15个字符
            }
            message.setDate(rs.getDate(4));
            message.setFlag(rs.getInt(5));
            messageArrayList.add(message);
        }
        JdbcUtil.free(rs,ps,conn);
        return messageArrayList;
    }

    public List<message> listTest(int pageNo,String date) throws Exception{
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<message> messageArrayList =new ArrayList<message>();
        Connection conn = JdbcUtil.getConnection();
        date += "%";
        String sql = "select * from message WHERE date LIKE ? order by id limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, date);
        ps.setInt(2,startRecno);
        ps.setInt(3,pageSize);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            message message =new message();
            message.setId(rs.getInt(1));
            message.setUsername(rs.getString(2));
            String t=rs.getString(3);
            if (t.length()<=20){
                message.setNote(t);
            }
            else {
                message.setNote(t.substring(0,15)+"......"); //截取15个字符
            }
            message.setDate(rs.getDate(4));
            message.setFlag(rs.getInt(5));
            messageArrayList.add(message);
        }
        JdbcUtil.free(rs,ps,conn);
        return messageArrayList;
    }

    public void messageadd(message message) throws Exception {               //添加log到数据库
        Connection conn = null;
        PreparedStatement ps = null;

        java.util.Date utilDate = new java.util.Date();         //获取当前时间
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//变成sqldate……这还要转就离谱,Timestamp防丢时分秒

        try {
            conn = JdbcUtil.getConnection();//静态方法调用
            String sql = "insert into message values (?,?,?,?,?) ";
            ps = conn.prepareStatement(sql);//预处理
            ps.setInt(1,message.getId());
            ps.setString(2, message.getUsername());
            ps.setString(3, message.getNote());
            ps.setTimestamp(4,sqlDate);
            ps.setInt(5,message.getFlag());

            ps.executeUpdate();//执行处理语句

        } finally {
            JdbcUtil.free(null, ps, conn);//释放资源
        }
    }

    public List<message> messageList(int flag) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<message> messagesList = new ArrayList<message>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM message where flag =? ORDER BY id";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, flag);
            rs = ps.executeQuery();
            while (rs.next()) {
                message message =new message();
                message.setUsername(rs.getString(2));
                message.setNote(rs.getString(3));
                message.setDate(rs.getDate(4));
                message.setId(rs.getInt(1));
                messagesList.add(message);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return messagesList;
    }

    public int messagenum() throws Exception {                     //留言总数
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT COUNT(`id`) FROM message";
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

    public List<message> mestimefind(String date) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        date += "%";
        String t ="";
        List<message> messageList = new ArrayList<message>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM message WHERE date LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                message message =new message();
                message.setUsername(rs.getString(2));
                t=rs.getString(3);
                if (t.length()<=20){
                    message.setNote(t);
                }
                else {
                    message.setNote(t.substring(0,15)+"......"); //截取15个字符
                }
                message.setDate(rs.getDate(4));
                message.setFlag(rs.getInt(5));
                message.setId(rs.getInt(1));
                messageList.add(message);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return messageList;
    }

    public String messageID(int i) throws Exception{           //按ID查询日志
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        message message = new message();
        String info ="no";
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM message where id=?";
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

    public void delete(int id) throws Exception {           //按id删日志
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "delete from message where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }
}
