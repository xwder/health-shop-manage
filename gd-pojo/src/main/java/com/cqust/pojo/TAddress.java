package com.cqust.pojo;

public class TAddress {
    private Integer id;

    private String province;

    private String detailaddr;

    private String zipcode;

    private String receiptname;

    private String receipphone;

    private Integer userid;

    private Integer defauladdress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getDetailaddr() {
        return detailaddr;
    }

    public void setDetailaddr(String detailaddr) {
        this.detailaddr = detailaddr == null ? null : detailaddr.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getReceiptname() {
        return receiptname;
    }

    public void setReceiptname(String receiptname) {
        this.receiptname = receiptname == null ? null : receiptname.trim();
    }

    public String getReceipphone() {
        return receipphone;
    }

    public void setReceipphone(String receipphone) {
        this.receipphone = receipphone == null ? null : receipphone.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDefauladdress() {
        return defauladdress;
    }

    public void setDefauladdress(Integer defauladdress) {
        this.defauladdress = defauladdress;
    }
}