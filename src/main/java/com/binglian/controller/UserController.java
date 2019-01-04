package com.binglian.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binglian.pojo.User;
import com.binglian.pojo.VO.UserVO;
import com.binglian.service.UserService;
import com.binglian.utils.BinglianJSONResult;
import com.binglian.utils.MD5Utils;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/regist")
	public BinglianJSONResult regist(@RequestBody User user) throws Exception{
		String password=user.getPassword();
		if(StringUtils.isBlank(user.getUsername())
				||StringUtils.isBlank(user.getPassword())){
			return BinglianJSONResult.ok("用户和密码不能为空");
		}
		
		//判断是否存在用户
		User result=userService.queryName(user.getUsername());
		
		if(result == null){
			userService.addUser(user);
		}else{
			return BinglianJSONResult.errorMsg("用户已存在");
		}
		
		UserVO userVO=new UserVO();
		BeanUtils.copyProperties(user, userVO);
		return BinglianJSONResult.ok(userVO);
	}
	
	@PostMapping("/login")
	public BinglianJSONResult login(@RequestBody User user) throws Exception {
		//判断账户和密码是否为空
		if(StringUtils.isBlank(user.getUsername()) ||
				StringUtils.isBlank(user.getPassword())){
			return BinglianJSONResult.errorMsg("用户和密码不能为空");
		}
		
		//判断是否存在用户
		User usernameIsExist=userService.queryName(user.getUsername());
		User Result=null;
		if(usernameIsExist !=null){
			Result=userService.queryForLogin(user.getUsername(), MD5Utils.getMD5Str(user.getPassword()));
			if(Result == null){
				return BinglianJSONResult.errorMsg("用户或密码不正确");
			}
		}
		UserVO userVO=new UserVO();
		BeanUtils.copyProperties(Result, userVO);
		return BinglianJSONResult.ok(userVO);
	}
}
