package com.binglian.service;

import com.binglian.pojo.Admin;
import com.binglian.pojo.User;

public interface AdminService {
	/**
	 * 根据username 查询密码
	 * @param username
	 * @return
	 */
	String loginPassword(String username);

	/**
	 * 根据username查询角色
	 * @param username
	 * @return
	 */
	String queryRolse(String username);
	
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean queryUsernameIsExist(String username);

	
	/**
	 * 查询用户是否匹配成功
	 * @param username
	 * @param pwd
	 * @return
	 */
	public Admin queryUserForLogin(String username,String password);
}
