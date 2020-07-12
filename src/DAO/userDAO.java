package DAO;

import JavaBean.Dynamaic;
import JavaBean.message;
import JavaBean.user;
import db.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userDAO {

    public int getPageCount() throws Exception{
        int recordCount =0, t1 = 0, t2 = 0;

        Connection conn = JdbcUtil.getConnection();
        String sql = "select count(*) FROM user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        recordCount = rs.getInt(1);
        t1 =recordCount%5;
        t2 = recordCount/5;
        JdbcUtil.free(rs,ps,conn);
        return t1==0?t2:t2+1;
    }

    public List<user> listTest(int pageNo) throws Exception{
        int pageSize =5;
        int startRecno =(pageNo-1)*pageSize;
        ArrayList<user> userArrayList =new ArrayList<user>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from user order by username limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,startRecno);
        ps.setInt(2,pageSize);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            user user =new user();
            user.setName(rs.getString(1));
            user.setPassword(rs.getString(2));
            user.setPower(rs.getInt(3));
            userArrayList.add(user);
        }
        JdbcUtil.free(rs,ps,conn);
        return userArrayList;
    }

    public user finduser(String user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        user user1 = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from user where username=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                user1 = new user();//一个用户，一行记录
                user1.setName(rs.getString(1));
                user1.setPassword(rs.getString(2));
                user1.setPower(rs.getInt(3));
            }
        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return user1;
    }

    public user login(user user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        user user1 = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from user where username=? and userpassword =? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                user1 = new user();//一个用户，一行记录
                user1.setName(rs.getString(1));
                user1.setPassword(rs.getString(2));
                user1.setPower(rs.getInt(3));
            }
        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return user1;
    }

    public void add(user user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();//静态方法调用
            String sql = "insert into user values (?,?,?) ";
            ps = conn.prepareStatement(sql);//预处理
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3,2);
            ps.executeUpdate();//执行处理语句

        } finally {
            JdbcUtil.free(null, ps, conn);//释放资源
        }
    }

    public List<user> userfind() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<user> userlist = new ArrayList<user>();
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user user =new user();
                user.setName(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setPower(rs.getInt(3));
                userlist.add(user);
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return userlist;
    }

    public String userfind(String str) throws Exception{           //按ID查询日志
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        JavaBean.Dynamaic dyn = new JavaBean.Dynamaic();
        String info ="no";
        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, str);
            rs = ps.executeQuery();
            if (rs.next()) {
                info="请选择更改方式!";
            }

        } finally {
            JdbcUtil.free(rs, ps, conn);
        }
        return info;
    }

    public void userdel(String name) throws Exception {           //按name删用户
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "delete from user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }

    public void update(String name,String password) throws Exception {           //按name删用户
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "update user set userpassword=? where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,name);
            ps.executeUpdate();
        } finally {
            JdbcUtil.free(null, ps, conn);
        }
    }

}
