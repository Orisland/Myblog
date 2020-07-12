package JavaBean;

import java.util.Date;

public class message {
    private String username;
    private String note;
    private Date date;
    private int flag;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return  username + ':' + "\r" + note +"\r"+
                "发布日期:" + date+"\r";
    }

    public String toString1() {
        return  "id:"+id+"  昵称:"+username+"发布日期:" + date + "  定位:"+flag+ "\r" +
                note +"\r";

    }
}
