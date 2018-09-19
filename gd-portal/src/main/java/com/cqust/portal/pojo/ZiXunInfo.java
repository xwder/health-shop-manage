package com.cqust.portal.pojo;

import java.util.Date;

public class ZiXunInfo {
	 private Integer id;

	    private String title;

	    private Date createtime;

	    private Date updatetime;

	    private String author;

	    private Integer zxtypeid;

	    private String infortext;
	    
	    private String zxtypename;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getCreatetime() {
			return createtime;
		}

		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}

		public Date getUpdatetime() {
			return updatetime;
		}

		public void setUpdatetime(Date updatetime) {
			this.updatetime = updatetime;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Integer getZxtypeid() {
			return zxtypeid;
		}

		public void setZxtypeid(Integer zxtypeid) {
			this.zxtypeid = zxtypeid;
		}

		public String getInfortext() {
			return infortext;
		}

		public void setInfortext(String infortext) {
			this.infortext = infortext;
		}

		public String getZxtypename() {
			return zxtypename;
		}

		public void setZxtypename(String zxtypename) {
			this.zxtypename = zxtypename;
		}

		
}
