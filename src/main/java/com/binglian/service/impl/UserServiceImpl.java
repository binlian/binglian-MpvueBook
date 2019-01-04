package com.binglian.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binglian.mapper.UserMapper;
import com.binglian.pojo.User;
import com.binglian.service.UserService;
import com.binglian.utils.MD5Utils;
import com.mysql.fabric.xmlrpc.base.Data;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryName(String username) {
		User user=new User();
		user.setUsername(username);
		User result=userMapper.selectOne(user);
		return result;
	}

	

	@Override
	public void addUser(User user) {
		user.setId(null);
		user.setCreateTime(new Date());
		try {
			user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userMapper.insert(user);
	}



	@Override
	public User queryForLogin(String username, String password) {
		Example example=new Example(User.class);
		Criteria criteria=example.createCriteria();
		
		criteria.andEqualTo("username",username);
		criteria.andEqualTo("password",password);
		
		User result=userMapper.selectOneByExample(example);
		return result;
	}

}
