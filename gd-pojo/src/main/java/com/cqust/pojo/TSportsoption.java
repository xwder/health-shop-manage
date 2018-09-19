package com.cqust.pojo;

public class TSportsoption {
    private Integer id;

    private String sportname;

    private Double energy;

    private String sportdescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname == null ? null : sportname.trim();
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public String getSportdescribe() {
        return sportdescribe;
    }

    public void setSportdescribe(String sportdescribe) {
        this.sportdescribe = sportdescribe == null ? null : sportdescribe.trim();
    }
}