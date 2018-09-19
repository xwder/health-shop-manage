package com.cqust.mshop.pojo;

import java.util.Date;

public class CustomLoginLog {
	 private Integer id;

	    private Integer uid;

	    private String username;

	    private Date logindate;

	    private String loginip;

	    private Integer loginstatus;
	    
	    private String strloginstatus;

	    private String loginps;
	    
	    public void setStrloginstatus(String strloginstatus) {
			this.strloginstatus = strloginstatus;
		}
	    public String getStrloginstatus() {
			return strloginstatus;
		}

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
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

	    public Date getLogindate() {
	        return logindate;
	    }

	    public void setLogindate(Date logindate) {
	        this.logindate = logindate;
	    }

	    public String getLoginip() {
	        return loginip;
	    }

	    public void setLoginip(String loginip) {
	        this.loginip = loginip == null ? null : loginip.trim();
	    }

	    public Integer getLoginstatus() {
	        return loginstatus;
	    }

	    public void setLoginstatus(Integer loginstatus) {
	        this.loginstatus = loginstatus;
	    }

	    public String getLoginps() {
	        return loginps;
	    }

	    public void setLoginps(String loginps) {
	        this.loginps = loginps == null ? null : loginps.trim();
	    }
	}
