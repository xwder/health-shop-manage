package com.cqust.mshop.pojo;

import java.util.Date;

public class CustomProduct {
	private Integer id;

	private Integer storeid;

	private String pname;

	private String pms;

	private Double pprice;

	private String ppic;

	private Date pcreattime;

	private Integer isHot;

	private Integer pstock;

	private Integer psellnum;

	private Integer isSell;

	private String ptype;

	private String pdesc;

	private String strIsSell;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPms() {
		return pms;
	}

	public void setPms(String pms) {
		this.pms = pms;
	}

	public Double getPprice() {
		return pprice;
	}

	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}

	public String getPpic() {
		return ppic;
	}

	public void setPpic(String ppic) {
		this.ppic = ppic;
	}

	public Date getPcreattime() {
		return pcreattime;
	}

	public void setPcreattime(Date pcreattime) {
		this.pcreattime = pcreattime;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getPstock() {
		return pstock;
	}

	public void setPstock(Integer pstock) {
		this.pstock = pstock;
	}

	public Integer getPsellnum() {
		return psellnum;
	}

	public void setPsellnum(Integer psellnum) {
		this.psellnum = psellnum;
	}

	public Integer getIsSell() {
		return isSell;
	}

	public void setIsSell(Integer isSell) {
		this.isSell = isSell;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getStrIsSell() {
		return strIsSell;
	}

	public void setStrIsSell(String strIsSell) {
		this.strIsSell = strIsSell;
	}

}
