package com.cqust.pojo;

import java.util.Date;

public class TUserstatistics {
    private Integer id;

    private Date dates;

    private Integer accesscount;

    private Integer registercount;

    private Integer logincount;

    private Integer addvipusercount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getAccesscount() {
        return accesscount;
    }

    public void setAccesscount(Integer accesscount) {
        this.accesscount = accesscount;
    }

    public Integer getRegistercount() {
        return registercount;
    }

    public void setRegistercount(Integer registercount) {
        this.registercount = registercount;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Integer getAddvipusercount() {
        return addvipusercount;
    }

    public void setAddvipusercount(Integer addvipusercount) {
        this.addvipusercount = addvipusercount;
    }
}