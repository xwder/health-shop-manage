package com.cqust.shop.pojo;

public class ItemInfo {
	public Integer id;
	public Integer storeid;
	public String ppic;
	public double pprice;
	public Integer pStock;
	public String pname;
	public Integer sid;
	public String storename;
	public String sdz;
	public Integer psellnum;

	public void setPsellnum(Integer psellnum) {
		this.psellnum = psellnum;
	}

	public Integer getPsellnum() {
		return psellnum;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPpic() {
		return ppic;
	}

	public void setPpic(String ppic) {
		this.ppic = ppic;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public void setpStock(Integer pStock) {
		this.pStock = pStock;
	}

	public Integer getpStock() {
		return pStock;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getSid() {
		return sid;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getSdz() {
		return sdz;
	}

	public void setSdz(String sdz) {
		this.sdz = sdz;
	}

}
