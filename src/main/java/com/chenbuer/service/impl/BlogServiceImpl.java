package com.chenbuer.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenbuer.dao.BlogDao;
import com.chenbuer.entity.Blog;
import com.chenbuer.service.BlogService;

/**
 * blogService的实现类
 * @author czy
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
	
	@Resource
	private BlogDao blogDao;

	public List<Blog> countList() {
		return blogDao.countList();
	}

	public List<Blog> listBlogWithPage(Map map) {
		return blogDao.listBlogWithPage(map);
	}

	public int getBlogCount(Map map) {
		return blogDao.getBlogCount(map);
	}

	public void save(Blog blog){
		blogDao.save(blog);
	}

	public void delete(Integer id) {
		blogDao.delete(id);
	}

	public Blog findById(Integer id) {
		return blogDao.findById(id);
	}

	public void update(Blog blog) {
		blogDao.update(blog);
	}
}
