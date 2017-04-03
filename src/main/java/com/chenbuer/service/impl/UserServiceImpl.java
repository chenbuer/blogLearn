package com.chenbuer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenbuer.dao.UserDao;
import com.chenbuer.entity.User;
import com.chenbuer.service.UserService;

/**
 * UserService的实现类
 * @author czy
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(userName);
	}

}
