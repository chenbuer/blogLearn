package com.chenbuer.service;

import com.chenbuer.entity.User;

public interface UserService {


	/**
	 * 通过用户名获取用户
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	
	public User find();
}
