package com.chenbuer.entity;

/**
 * 博客类型实体类
 * @author czy
 *
 */
public class BlogType {
	private int id;
	private String typeName;
	private int orderNo;

	private int blogCount;//这个type下有多少个【这个不是数据库中的字段，而是自己统计的】
	
	public int getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(int blogCount) {
		this.blogCount = blogCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

}
