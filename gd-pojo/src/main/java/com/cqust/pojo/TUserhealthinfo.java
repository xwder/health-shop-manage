package com.cqust.pojo;

import java.util.Date;

public class TUserhealthinfo extends TUserhealthinfoKey {
    private String username;

    private Double height;

    private Double weight;

    private Integer sex;

    private Date birthday;

    private String dietprefe;

    private String notlikefoods;

    private String healstatus;

    private String medhis;

    private String senfoods;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDietprefe() {
        return dietprefe;
    }

    public void setDietprefe(String dietprefe) {
        this.dietprefe = dietprefe == null ? null : dietprefe.trim();
    }

    public String getNotlikefoods() {
        return notlikefoods;
    }

    public void setNotlikefoods(String notlikefoods) {
        this.notlikefoods = notlikefoods == null ? null : notlikefoods.trim();
    }

    public String getHealstatus() {
        return healstatus;
    }

    public void setHealstatus(String healstatus) {
        this.healstatus = healstatus == null ? null : healstatus.trim();
    }

    public String getMedhis() {
        return medhis;
    }

    public void setMedhis(String medhis) {
        this.medhis = medhis == null ? null : medhis.trim();
    }

    public String getSenfoods() {
        return senfoods;
    }

    public void setSenfoods(String senfoods) {
        this.senfoods = senfoods == null ? null : senfoods.trim();
    }
}