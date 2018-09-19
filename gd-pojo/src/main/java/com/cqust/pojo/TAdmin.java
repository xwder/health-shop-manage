package com.cqust.pojo;

public class TAdmin {
    private Integer id;

    private String adminname;

    private String adminpsswd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpsswd() {
        return adminpsswd;
    }

    public void setAdminpsswd(String adminpsswd) {
        this.adminpsswd = adminpsswd == null ? null : adminpsswd.trim();
    }
}