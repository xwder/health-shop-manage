package com.cqust.pojo;

public class TItemcollocation {
    private Integer id;

    private Integer pid;

    private String collocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCollocation() {
        return collocation;
    }

    public void setCollocation(String collocation) {
        this.collocation = collocation == null ? null : collocation.trim();
    }
}