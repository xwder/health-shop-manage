package com.cqust.pojo;

public class TStoreinfo {
    private Integer id;

    private Integer userid;

    private String storelogoimg;

    private String storename;

    private String sname;

    private String sphone;

    private String sid;

    private String slicense;

    private String sdz;

    private String saddr;

    private Integer isCheck;

    private String stype;

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

    public String getStorelogoimg() {
        return storelogoimg;
    }

    public void setStorelogoimg(String storelogoimg) {
        this.storelogoimg = storelogoimg == null ? null : storelogoimg.trim();
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSlicense() {
        return slicense;
    }

    public void setSlicense(String slicense) {
        this.slicense = slicense == null ? null : slicense.trim();
    }

    public String getSdz() {
        return sdz;
    }

    public void setSdz(String sdz) {
        this.sdz = sdz == null ? null : sdz.trim();
    }

    public String getSaddr() {
        return saddr;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr == null ? null : saddr.trim();
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype == null ? null : stype.trim();
    }
}