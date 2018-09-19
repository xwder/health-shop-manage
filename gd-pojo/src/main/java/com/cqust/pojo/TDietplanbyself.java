package com.cqust.pojo;

import java.util.Date;

public class TDietplanbyself {
    private Integer id;

    private Integer userid;

    private Integer foodid;

    private String foodname;

    private Double foodquantity;

    private Double actualweight;

    private String type;

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

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public Double getFoodquantity() {
        return foodquantity;
    }

    public void setFoodquantity(Double foodquantity) {
        this.foodquantity = foodquantity;
    }

    public Double getActualweight() {
        return actualweight;
    }

    public void setActualweight(Double actualweight) {
        this.actualweight = actualweight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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