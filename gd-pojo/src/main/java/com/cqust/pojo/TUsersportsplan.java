package com.cqust.pojo;

import java.util.Date;

public class TUsersportsplan {
    private Integer id;

    private Integer userid;

    private Integer dietitionid;

    private Date soprtsdate;

    private String plansportsid;

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

    public Date getSoprtsdate() {
        return soprtsdate;
    }

    public void setSoprtsdate(Date soprtsdate) {
        this.soprtsdate = soprtsdate;
    }

    public String getPlansportsid() {
        return plansportsid;
    }

    public void setPlansportsid(String plansportsid) {
        this.plansportsid = plansportsid == null ? null : plansportsid.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}