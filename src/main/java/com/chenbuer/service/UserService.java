package com.chenbuer.service;

import com.chenbuer.entity.User;

public interface UserService {


	/**
	 * ͨ���û�����ȡ�û�
	 * @param userName
	 * @return
	 */
	User getUserByUserName(String userName);
	
	/**
	 * ��ȡ��������Ϣ
	 * @return
	 */
	User find();
	
}
