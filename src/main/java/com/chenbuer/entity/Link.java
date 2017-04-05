package com.chenbuer.entity;

/**
 * 友情链接
 * @author czy
 *
 */
public class Link {
	private int id;
	private String linkName;
	private String linkUrl;
	private int linkNo;//排序优先级

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public int getLinkNo() {
		return linkNo;
	}
	public void setLinkNo(int linkNo) {
		this.linkNo = linkNo;
	}
	
	

	
}
