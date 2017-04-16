package com.chenbuer.entity;

import java.util.List;
/**
 * 这个entity是后台在请求blog的datagrid时候用来返回的结构，可以参见http://www.jeasyui.net/tutorial/21.html
 * @author czy
 *
 */
public class AdminBlogList {
	private List<Blog> rows;
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Blog> getRows() {
		return rows;
	}

	public void setRows(List<Blog> rows) {
		this.rows = rows;
	}
	
}
