package com.cqust.pojo;

import java.util.Date;

public class TVipdietapplication {
    private Integer id;

    private Integer userid;

    private String username;

    private Date sqdate;

    private Integer sqstatus;

    private Integer dietitianid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getSqdate() {
        return sqdate;
    }

    public void setSqdate(Date sqdate) {
        this.sqdate = sqdate;
    }

    public Integer getSqstatus() {
        return sqstatus;
    }

    public void setSqstatus(Integer sqstatus) {
        this.sqstatus = sqstatus;
    }

    public Integer getDietitianid() {
        return dietitianid;
    }

    public void setDietitianid(Integer dietitianid) {
        this.dietitianid = dietitianid;
    }
}