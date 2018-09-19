package com.cqust.rest.pojo;

import java.sql.Date;

public class Healthinfo {
    private Integer id;

    private String title;

    private Date createtime;

    private Date updatetime;

    private String infortext;

    private String author;

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

    public String getInfortext() {
        return infortext;
    }

    public void setInfortext(String infortext) {
        this.infortext = infortext == null ? null : infortext.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}