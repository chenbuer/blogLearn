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
	int getBlogCount(Map map);
	
	/**
	 * 添加博客
	 * @param blog
	 */
	void save(Blog blog);
	
	/**
	 * 删除博客
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * 根据Id找到Blog
	 * @param id
	 * @return
	 */
	Blog findById(Integer id);
	
	/**
	 * 修改Blog
	 * @param map
	 */
	void update(Blog blog);
}
