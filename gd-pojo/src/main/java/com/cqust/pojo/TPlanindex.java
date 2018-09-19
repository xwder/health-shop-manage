package com.cqust.pojo;

import java.util.Date;

public class TPlanindex {
    private Integer id;

    private Integer userid;

    private Integer nutritionistid;

    private Date startdate;

    private Date enddate;

    private Integer plantype;

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

    public Integer getNutritionistid() {
        return nutritionistid;
    }

    public void setNutritionistid(Integer nutritionistid) {
        this.nutritionistid = nutritionistid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getPlantype() {
        return plantype;
    }

    public void setPlantype(Integer plantype) {
        this.plantype = plantype;
    }
}