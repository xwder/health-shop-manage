package com.cqust.pojo;

import java.util.Date;

public class TUserdietplan {
    private Integer id;

    private Integer userid;

    private Integer dietitionid;

    private Date dietday;

    private String remarks;

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

    public Integer getDietitionid() {
        return dietitionid;
    }

    public void setDietitionid(Integer dietitionid) {
        this.dietitionid = dietitionid;
    }

    public Date getDietday() {
        return dietday;
    }

    public void setDietday(Date dietday) {
        this.dietday = dietday;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}