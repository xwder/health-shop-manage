package com.cqust.pojo;

public class TFood {
    private Integer id;

    private String foodname;

    private Double foodquantity;

    private Integer materialid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }
}