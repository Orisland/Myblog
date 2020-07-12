package JavaBean;

import java.util.Date;

public class log {
    private int id;
    private String name;
    private String text;
    private String picid;
    private String writer;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return  "序号:" + id + "  标题:" + name + "  图片id:" + picid +"  作者:" + writer+"  发布日期:" + date+ "\r" +
                "正文:" + text+"\r";
    }
}
