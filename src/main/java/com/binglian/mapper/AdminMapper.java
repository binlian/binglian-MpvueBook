package com.binglian.mapper;

import com.binglian.pojo.Admin;
import com.binglian.utils.MyMapper;

public interface AdminMapper extends MyMapper<Admin> {
	public Admin findByName(String username);
	
	//根据username返回password
	String getUserPassword(String username);
			
	//根据username返回rolse
	String getUserRolse(String username);
}