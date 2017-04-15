package com.chenbuer.entity;

import java.util.Date;

/**
 * ����ʵ����
 * @author czy
 *
 */
public class Blog {
	private int id;
	private String title;
	private String summary;//ժҪ
	private Date releaseDate;
	private int clickHit;//�Ķ�����
	private int replyHit;//���۴���
	private String content;
	private String keyWord;//�ؼ����ö��ŷֿ�
	
	private BlogType blogType;//typeId���ã�������BlogType����
	private Integer typeId;
	private String releaseDateStr;//�����ݿ���û�С�
	private int blogCount;//������ʾ��ĳ���·ݲ��͵����������ݿ���û�С�
	
	
	public Blog(String title, String summary, String content, String keyWord, Integer typeId) {
		super();
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.keyWord = keyWord;
		this.typeId = typeId;
	}
	
	
	public Blog() {
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getClickHit() {
		return clickHit;
	}
	public void setClickHit(int clickHit) {
		this.clickHit = clickHit;
	}
	public int getReplyHit() {
		return replyHit;
	}
	public void setReplyHit(int replyHit) {
		this.replyHit = replyHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	public int getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(int blogCount) {
		this.blogCount = blogCount;
	}

	
}
