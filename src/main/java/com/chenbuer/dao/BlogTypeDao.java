package com.chenbuer.dao;

import java.util.List;

import com.chenbuer.entity.BlogType;

/**
 * ��������DAO�ӿ�
 * @author czy
 *
 */
public interface BlogTypeDao {
	List<BlogType> countList();
	BlogType findById(Integer id);
}
