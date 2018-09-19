package com.cqust.pojo;

import java.util.Date;

public class TDietitioncomment {
    private Integer id;

    private String comtext;

    private Integer comlevel;

    private Integer userid;

    private Date contime;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComtext() {
        return comtext;
    }

    public void setComtext(String comtext) {
        this.comtext = comtext == null ? null : comtext.trim();
    }

    public Integer getComlevel() {
        return comlevel;
    }

    public void setComlevel(Integer comlevel) {
        this.comlevel = comlevel;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getContime() {
        return contime;
    }

    public void setContime(Date contime) {
        this.contime = contime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}