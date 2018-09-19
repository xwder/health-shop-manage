package com.cqust.pojo;

import java.util.Date;

public class TZxbrowserecord {
    private Integer id;

    private Integer uid;

    private String username;

    private Integer usertype;

    private Integer zxid;

    private String zxtitle;

    private Date browsetime;

    private String userip;

    private Integer zxtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getZxid() {
        return zxid;
    }

    public void setZxid(Integer zxid) {
        this.zxid = zxid;
    }

    public String getZxtitle() {
        return zxtitle;
    }

    public void setZxtitle(String zxtitle) {
        this.zxtitle = zxtitle == null ? null : zxtitle.trim();
    }

    public Date getBrowsetime() {
        return browsetime;
    }

    public void setBrowsetime(Date browsetime) {
        this.browsetime = browsetime;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public Integer getZxtype() {
        return zxtype;
    }

    public void setZxtype(Integer zxtype) {
        this.zxtype = zxtype;
    }
}