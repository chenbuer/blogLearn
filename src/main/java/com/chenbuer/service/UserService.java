package com.chenbuer.service;

import com.chenbuer.entity.User;

public interface UserService {


	/**
	 * ͨ���û�����ȡ�û�
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	
	public User find();
}
