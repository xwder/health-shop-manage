package com.cqust.mshop.pojo;

import java.util.Date;

public class CustomPbrowseRecord {
	  private Integer id;

	    private Integer pid;
	    
	    private String pname;

	    private Integer uid;

	    private String username;

	    private Date browsetime;

	    private Integer usertype;
	    
	    private String strusertype;

	    private String userip;

	    private Integer sid;
	    
	    public void setStrusertype(String strusertype) {
			this.strusertype = strusertype;
		}
	    public String getStrusertype() {
			return strusertype;
		}
	    
	    public void setPname(String pname) {
			this.pname = pname;
		}
	    public String getPname() {
			return pname;
		}

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

	    public Integer getUid() {
	        return uid;
	    }

	    public void setUid(Integer uid) {
	        this.uid = uid;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username == null ? null : username.trim();
	    }

	    public Date getBrowsetime() {
	        return browsetime;
	    }

	    public void setBrowsetime(Date browsetime) {
	        this.browsetime = browsetime;
	    }

	    public Integer getUsertype() {
	        return usertype;
	    }

	    public void setUsertype(Integer usertype) {
	        this.usertype = usertype;
	    }

	    public String getUserip() {
	        return userip;
	    }

	    public void setUserip(String userip) {
	        this.userip = userip == null ? null : userip.trim();
	    }

	    public Integer getSid() {
	        return sid;
	    }

	    public void setSid(Integer sid) {
	        this.sid = sid;
	    }
	}