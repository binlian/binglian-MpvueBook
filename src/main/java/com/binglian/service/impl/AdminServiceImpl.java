package com.binglian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.binglian.mapper.AdminMapper;
import com.binglian.pojo.Admin;
import com.binglian.pojo.User;
import com.binglian.service.AdminService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public String loginPassword(String username) {
		String password=adminMapper.getUserPassword(username);
		return password;
	}

	@Override
	public String queryRolse(String username) {
		String rolse=adminMapper.getUserRolse(username);
		return rolse;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean queryUsernameIsExist(String username) {
		
		Admin user=new Admin();
		user.setUsername(username);
		
		Admin result=adminMapper.selectOne(user);
		
		return result !=null ? true:false;
	}
	

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Admin queryUserForLogin(String username, String password) {

		Example example=new Example(Admin.class);
		Criteria criteria=example.createCriteria();
		
		criteria.andEqualTo("username", username);
		criteria.andEqualTo("password", password);
		
		Admin result=adminMapper.selectOneByExample(example);
		
		return result;
	}
}
