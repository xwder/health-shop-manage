package com.cqust.pojo;

import java.util.Date;

public class TDietitian {
    private Integer id;

    private Integer userid;

    private String username;

    private String uid;

    private String uidimageurl;

    private String dietlicense;

    private String dietimageurl;

    private Date sqdate;

    private Integer status;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUidimageurl() {
        return uidimageurl;
    }

    public void setUidimageurl(String uidimageurl) {
        this.uidimageurl = uidimageurl == null ? null : uidimageurl.trim();
    }

    public String getDietlicense() {
        return dietlicense;
    }

    public void setDietlicense(String dietlicense) {
        this.dietlicense = dietlicense == null ? null : dietlicense.trim();
    }

    public String getDietimageurl() {
        return dietimageurl;
    }

    public void setDietimageurl(String dietimageurl) {
        this.dietimageurl = dietimageurl == null ? null : dietimageurl.trim();
    }

    public Date getSqdate() {
        return sqdate;
    }

    public void setSqdate(Date sqdate) {
        this.sqdate = sqdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}