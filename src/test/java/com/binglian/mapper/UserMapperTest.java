package com.binglian.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.binglian.pojo.User;
import com.binglian.utils.MD5Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

//	@Test
//	public void login() throws Exception{
//		User user=new User();
//		user=userMapper.login(MD5Utils.getMD5Str("heartache1"));
//		Assert.assertNotNull(user);
//	}
}
