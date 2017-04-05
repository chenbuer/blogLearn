package com.chenbuer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenbuer.dao.LinkDao;
import com.chenbuer.entity.Link;
import com.chenbuer.service.LinkService;

/**
 * linkService的实现类
 * @author czy
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
	
	@Resource
	private LinkDao linkDao;

	public List<Link> list() {
		return linkDao.list();
	}


}
