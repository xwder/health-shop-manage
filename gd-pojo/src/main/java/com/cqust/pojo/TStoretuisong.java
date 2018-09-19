package com.cqust.pojo;

import java.util.Date;

public class TStoretuisong {
    private Integer id;

    private Integer storeid;

    private String storename;

    private Date tstime;

    private String tstext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public Date getTstime() {
        return tstime;
    }

    public void setTstime(Date tstime) {
        this.tstime = tstime;
    }

    public String getTstext() {
        return tstext;
    }

    public void setTstext(String tstext) {
        this.tstext = tstext == null ? null : tstext.trim();
    }
}