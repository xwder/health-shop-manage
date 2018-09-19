package com.cqust.pojo;

import java.util.Date;

public class TStorecomment {
    private Integer id;

    private String commenttext;

    private Integer commentlevel;

    private Date commenttime;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext == null ? null : commenttext.trim();
    }

    public Integer getCommentlevel() {
        return commentlevel;
    }

    public void setCommentlevel(Integer commentlevel) {
        this.commentlevel = commentlevel;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}