package com.chenbuer.dao;

import java.util.List;
import java.util.Map;

import com.chenbuer.entity.Blog;

/**
 * �û�DAO�ӿ�
 * @author czy
 *
 */
public interface BlogDao {

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
	int getBlogCount();
}
