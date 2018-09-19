package com.cqust.pojo;

import java.util.Date;

public class TStoreapplication {
    private Integer id;

    private Integer userid;

    private String ownname;

    private String phone;

    private String uid;

    private String uidimageurl;

    private String storename;

    private String storeaddr;

    private String detailaddr;

    private String storelicenseid;

    private String licenseimageurl;

    private Integer storetype;

    private Date sqdate;

    private Integer sqstatus;

    private String storelogoimg;

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

    public String getOwnname() {
        return ownname;
    }

    public void setOwnname(String ownname) {
        this.ownname = ownname == null ? null : ownname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getStoreaddr() {
        return storeaddr;
    }

    public void setStoreaddr(String storeaddr) {
        this.storeaddr = storeaddr == null ? null : storeaddr.trim();
    }

    public String getDetailaddr() {
        return detailaddr;
    }

    public void setDetailaddr(String detailaddr) {
        this.detailaddr = detailaddr == null ? null : detailaddr.trim();
    }

    public String getStorelicenseid() {
        return storelicenseid;
    }

    public void setStorelicenseid(String storelicenseid) {
        this.storelicenseid = storelicenseid == null ? null : storelicenseid.trim();
    }

    public String getLicenseimageurl() {
        return licenseimageurl;
    }

    public void setLicenseimageurl(String licenseimageurl) {
        this.licenseimageurl = licenseimageurl == null ? null : licenseimageurl.trim();
    }

    public Integer getStoretype() {
        return storetype;
    }

    public void setStoretype(Integer storetype) {
        this.storetype = storetype;
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

    public String getStorelogoimg() {
        return storelogoimg;
    }

    public void setStorelogoimg(String storelogoimg) {
        this.storelogoimg = storelogoimg == null ? null : storelogoimg.trim();
    }
}