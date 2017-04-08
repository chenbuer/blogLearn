package com.chenbuer.dao;

import java.util.List;

import com.chenbuer.entity.BlogType;

/**
 * 博客类型DAO接口
 * @author czy
 *
 */
public interface BlogTypeDao {
	List<BlogType> countList();
	BlogType findById(Integer id);
}
