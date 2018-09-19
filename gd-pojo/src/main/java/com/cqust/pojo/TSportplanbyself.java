package com.cqust.pojo;

import java.util.Date;

public class TSportplanbyself {
    private Integer id;

    private Integer userid;

    private Integer sportid;

    private String sportname;

    private String sportdescribe;

    private Date plandate;

    private Integer planid;

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

    public Integer getSportid() {
        return sportid;
    }

    public void setSportid(Integer sportid) {
        this.sportid = sportid;
    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname == null ? null : sportname.trim();
    }

    public String getSportdescribe() {
        return sportdescribe;
    }

    public void setSportdescribe(String sportdescribe) {
        this.sportdescribe = sportdescribe == null ? null : sportdescribe.trim();
    }

    public Date getPlandate() {
        return plandate;
    }

    public void setPlandate(Date plandate) {
        this.plandate = plandate;
    }

    public Integer getPlanid() {
        return planid;
    }

    public void setPlanid(Integer planid) {
        this.planid = planid;
    }
}