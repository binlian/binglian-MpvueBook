package com.binglian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binglian.utils.RandomValidateCodeUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/yan")
@Slf4j
public class CodeController {

	private static final Logger logger=LoggerFactory.getLogger(CodeController.class);

	@RequestMapping(value="/getVerify")
	public void getVerif(HttpServletRequest request,HttpServletResponse response){
		try { 
		 	response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
		 	response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容 
		 	response.setHeader("Cache-Control", "no-cache"); 
		 	response.setDateHeader("Expire", 0);
		 	RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
		 	randomValidateCode.getRandcode(request, response);//输出验证码图片方法 
		 } catch (Exception e) {
		  	logger.error("获取验证码失败>>>>   ", e); 
		}
	}
}
