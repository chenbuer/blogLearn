package com.chenbuer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenbuer.dao.BlogTypeDao;
import com.chenbuer.entity.BlogType;
import com.chenbuer.entity.Link;
import com.chenbuer.service.BlogTypeService;
import com.chenbuer.service.LinkService;

/**
 * blogTypeService的实现类
 * @author czy
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
	
	@Resource
	private BlogTypeDao blogTypeDao;

	public List<BlogType> countList() {
		return blogTypeDao.countList();
	}


}
