package com.cqust.pojo;

import java.util.Date;

public class TContent {
    private Integer id;

    private Integer userid;

    private Integer dietitianid;

    private Date zxtime;

    private String zxtext;

    private Integer isRead;

    private Integer zxidentity;

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

    public Integer getDietitianid() {
        return dietitianid;
    }

    public void setDietitianid(Integer dietitianid) {
        this.dietitianid = dietitianid;
    }

    public Date getZxtime() {
        return zxtime;
    }

    public void setZxtime(Date zxtime) {
        this.zxtime = zxtime;
    }

    public String getZxtext() {
        return zxtext;
    }

    public void setZxtext(String zxtext) {
        this.zxtext = zxtext == null ? null : zxtext.trim();
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getZxidentity() {
        return zxidentity;
    }

    public void setZxidentity(Integer zxidentity) {
        this.zxidentity = zxidentity;
    }
}