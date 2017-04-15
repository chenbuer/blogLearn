package com.chenbuer.service;

import java.util.List;
import java.util.Map;

import com.chenbuer.entity.Blog;

public interface BlogService {


	/**
	 * 按月份列出Blog
	 * @return
	 */
	List<Blog> countList();
	
	/**
	 * 分页查询Blog
	 * @param map
	 * @return
	 */
	List<Blog> listBlogWithPage(Map map);
	
	/**
	 * 查询Blog总数
	 * @return
	 */
	int getBlogCount(Map map);
	
	/**
	 * 添加博客
	 * @param blog
	 */
	void save(Blog blog);
}
