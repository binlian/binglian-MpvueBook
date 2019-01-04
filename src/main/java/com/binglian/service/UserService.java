package com.binglian.service;

import com.binglian.pojo.User;

public interface UserService {

	/*
	 * 判断用户是否存在
	 */
	User queryName(String username);
	
	/**
	 * 用户注册·
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 用户账户密码匹配
	 * @param username
	 * @param password
	 * @return
	 */
	User queryForLogin(String username,String password);

}
