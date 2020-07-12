package JavaBean;

import java.util.Date;

public class Dynamaic {
    private int id;
    private String writer;
    private String text;
    private String picid;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicid() {
        return picid;
    }

    public void setPicid(String picid) {
        this.picid = picid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  "序号：" + id +" 作者：" + writer + " 日期：" + date+" 图片id：" + picid +'\r'+
                "内容：" + text + '\r';


    }
}
