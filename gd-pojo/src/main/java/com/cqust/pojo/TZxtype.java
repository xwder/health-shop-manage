package com.cqust.pojo;

import java.util.Date;

public class TZxtype {
    private Integer id;

    private String zxtypename;

    private Date createtime;

    private Date updatetime;

    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZxtypename() {
        return zxtypename;
    }

    public void setZxtypename(String zxtypename) {
        this.zxtypename = zxtypename == null ? null : zxtypename.trim();
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
}