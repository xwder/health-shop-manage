package com.cqust.pojo;

import java.util.Date;

public class THealthinfo {
    private Integer id;

    private String title;

    private Date createtime;

    private Date updatetime;

    private String author;

    private Integer zixuntype;

    private Integer show;

    private String zixuntext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getZixuntype() {
        return zixuntype;
    }

    public void setZixuntype(Integer zixuntype) {
        this.zixuntype = zixuntype;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public String getZixuntext() {
        return zixuntext;
    }

    public void setZixuntext(String zixuntext) {
        this.zixuntext = zixuntext == null ? null : zixuntext.trim();
    }
}