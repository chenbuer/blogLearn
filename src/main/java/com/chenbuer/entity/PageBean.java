package com.chenbuer.entity;

public class PageBean {

	private int page;//第几页
	private int pageSize;//每页记录数
	private int start;//起始页，这个在SQL中使用，不是自己带上来的
	
	public PageBean() {
	}

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
	
	//获取到start方法
	public int getStart() {
		start = (page-1)*pageSize;
		return start;
	}
	
}
