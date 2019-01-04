package com.binglian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binglian.pojo.Admin;
import com.binglian.pojo.VO.AdminVO;
import com.binglian.service.AdminService;

import com.binglian.utils.BinglianJSONResult;
import com.binglian.utils.MD5Utils;

@RestController
@RequestMapping("admins")
public class AdminUserController {

	@Autowired
	private AdminService adminService;
	@RequestMapping("/login")
	public BinglianJSONResult login(@RequestParam(name="yan") String yan,
							@RequestParam(name="username") String username,
							@RequestParam(name="password") String password,
							HttpSession session) throws Exception{
		
		//1.判断用户密码是否为空
		if(StringUtils.isBlank(username)
				|| StringUtils.isBlank(password)){
			return BinglianJSONResult.errorMsg("用户名和密码不能为空");
		}
		//判断验证码不能为空
		if(StringUtils.isBlank(yan)){
			return BinglianJSONResult.errorMsg("验证码不能为空");
		}
				
		//从session中获取随机数
				
		String random=(String) session.getAttribute("RANDOMVALIDATECODEKEY");
				
		if(!yan.equalsIgnoreCase(random)){
			return BinglianJSONResult.errorMsg("验证码错误");
		}
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token =new UsernamePasswordToken(username,password);
		
		try {
			subject.login(token);
			if (subject.isAuthenticated()==true) {
				return BinglianJSONResult.ok("成功");
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return BinglianJSONResult.errorMap("失败");
	}
	 
}
