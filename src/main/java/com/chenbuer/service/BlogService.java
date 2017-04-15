package com.chenbuer.service;

import java.util.List;
import java.util.Map;

import com.chenbuer.entity.Blog;

public interface BlogService {


	/**
	 * ���·��г�Blog
	 * @return
	 */
	List<Blog> countList();
	
	/**
	 * ��ҳ��ѯBlog
	 * @param map
	 * @return
	 */
	List<Blog> listBlogWithPage(Map map);
	
	/**
	 * ��ѯBlog����
	 * @return
	 */
	int getBlogCount(Map map);
	
	/**
	 * ��Ӳ���
	 * @param blog
	 */
	void save(Blog blog);
}
