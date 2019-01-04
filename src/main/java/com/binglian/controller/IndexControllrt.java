package com.binglian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllrt {

	
	@RequestMapping("/admin/index")
	public String adminLogin(){
		return "admin/index";
	}
	
	@RequestMapping("/admin/login")
	public String adminlogin(){
		return "admin/login";
	}
//	@RequestMapping("/admin/book/list")
//	public String bookList(){
//		return "admin/list";
//	}
	
//	@RequestMapping("hello")
//	public String heloo(){
//		return "hello";
//	}

	@RequestMapping("/admin/yan")
	public String helloo(){
		return "login";
	}
	
	@RequestMapping("admin/book/edit")
	public String edit(){
		return "admin/edit";
	}
}
