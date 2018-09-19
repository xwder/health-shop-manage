package com.cqust.pojo;

import java.util.Date;

public class TOrderstatistics {
    private Integer id;

    private Integer storesqcount;

    private Integer totalordercount;

    private Integer cancelordercount;

    private Integer complordercount;

    private Double totalamount;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoresqcount() {
        return storesqcount;
    }

    public void setStoresqcount(Integer storesqcount) {
        this.storesqcount = storesqcount;
    }

    public Integer getTotalordercount() {
        return totalordercount;
    }

    public void setTotalordercount(Integer totalordercount) {
        this.totalordercount = totalordercount;
    }

    public Integer getCancelordercount() {
        return cancelordercount;
    }

    public void setCancelordercount(Integer cancelordercount) {
        this.cancelordercount = cancelordercount;
    }

    public Integer getComplordercount() {
        return complordercount;
    }

    public void setComplordercount(Integer complordercount) {
        this.complordercount = complordercount;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}