package com.cqust.mshop.pojo;

import java.util.Date;

public class OrderStatus {
	 private Integer id;

	    private Double total;

	    private Date ordertime;

	    private String orderstates;
	    
	    private Integer intOrderstates;

	    private String username;

	    private String userphone;

	    private String useraddr;

	    private Integer userid;

	    private Integer storeid;

	    private String message;

	    private Integer delstatus;

	    private String ordercomment;
	    
	    public void setIntOrderstates(Integer intOrderstates) {
			this.intOrderstates = intOrderstates;
		}
	    public Integer getIntOrderstates() {
			return intOrderstates;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}

		public Date getOrdertime() {
			return ordertime;
		}

		public void setOrdertime(Date ordertime) {
			this.ordertime = ordertime;
		}

		public String getOrderstates() {
			return orderstates;
		}

		public void setOrderstates(String orderstates) {
			this.orderstates = orderstates;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUserphone() {
			return userphone;
		}

		public void setUserphone(String userphone) {
			this.userphone = userphone;
		}

		public String getUseraddr() {
			return useraddr;
		}

		public void setUseraddr(String useraddr) {
			this.useraddr = useraddr;
		}

		public Integer getUserid() {
			return userid;
		}

		public void setUserid(Integer userid) {
			this.userid = userid;
		}

		public Integer getStoreid() {
			return storeid;
		}

		public void setStoreid(Integer storeid) {
			this.storeid = storeid;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Integer getDelstatus() {
			return delstatus;
		}

		public void setDelstatus(Integer delstatus) {
			this.delstatus = delstatus;
		}

		public String getOrdercomment() {
			return ordercomment;
		}

		public void setOrdercomment(String ordercomment) {
			this.ordercomment = ordercomment;
		}

}
