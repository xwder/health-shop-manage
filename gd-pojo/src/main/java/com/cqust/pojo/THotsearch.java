package com.cqust.pojo;

import java.util.Date;

public class THotsearch {
    private Integer id;

    private String hotname;

    private Integer hotcount;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotname() {
        return hotname;
    }

    public void setHotname(String hotname) {
        this.hotname = hotname == null ? null : hotname.trim();
    }

    public Integer getHotcount() {
        return hotcount;
    }

    public void setHotcount(Integer hotcount) {
        this.hotcount = hotcount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}