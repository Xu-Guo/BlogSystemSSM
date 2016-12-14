package com.xuguo.entity;

/**
 * paging Model class
 * @author 
 *
 */
public class PageBean {

	private int page; // page number
	private int pageSize; // number of record within one page
	private int start;  // number of start page
	
	
	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return (page-1)*pageSize;
	}
	
	
}
