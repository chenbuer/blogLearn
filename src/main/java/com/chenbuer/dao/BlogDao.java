package com.chenbuer.dao;

import java.util.List;
import java.util.Map;

import com.chenbuer.entity.Blog;

/**
 * 用户DAO接口
 * @author czy
 *
 */
public interface BlogDao {

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
	int getBlogCount();
}
