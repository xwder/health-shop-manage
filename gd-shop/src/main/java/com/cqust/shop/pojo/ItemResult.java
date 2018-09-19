package com.cqust.shop.pojo;

import java.util.List;

import com.cqust.pojo.TProduct;

public class ItemResult {
	//商品列表
		private List<TProduct> itemList;
		//总记录数
		private long recordCount;
		//总页数
		private long pageCount;
		//当前页
		private long curPage;
		
		public List<TProduct> getItemList() {
			return itemList;
		}
		public void setItemList(List<TProduct> itemList) {
			this.itemList = itemList;
		}
		public long getRecordCount() {
			return recordCount;
		}
		public void setRecordCount(long recordCount) {
			this.recordCount = recordCount;
		}
		public long getPageCount() {
			return pageCount;
		}
		public void setPageCount(long pageCount) {
			this.pageCount = pageCount;
		}
		public long getCurPage() {
			return curPage;
		}
		public void setCurPage(long curPage) {
			this.curPage = curPage;
		}
		
}
