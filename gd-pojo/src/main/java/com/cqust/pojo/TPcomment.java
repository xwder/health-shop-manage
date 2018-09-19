package com.cqust.pojo;

import java.util.Date;

public class TPcomment {
    private Integer id;

    private String comtext;

    private Integer comtype;

    private Integer comlevel;

    private Integer pid;

    private String username;

    private Date time;

    private Integer userid;

    private Integer orderitemid;

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

    public Integer getComtype() {
        return comtype;
    }

    public void setComtype(Integer comtype) {
        this.comtype = comtype;
    }

    public Integer getComlevel() {
        return comlevel;
    }

    public void setComlevel(Integer comlevel) {
        this.comlevel = comlevel;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }
}