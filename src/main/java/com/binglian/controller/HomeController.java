package com.binglian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binglian.pojo.Book;
import com.binglian.service.BookService;
import com.binglian.utils.PagedResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping("book")
public class HomeController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public PagedResult list(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="size",defaultValue="10") Integer size){
		PageHelper.startPage(page,size);
		List<Book> books=bookService.listAll();
		PageInfo<Book> pageInfo=new PageInfo<>(books);
		
		PagedResult pagedResult=new PagedResult();
		pagedResult.setPage(page);
		pagedResult.setTotal(pageInfo.getPages());
		pagedResult.setRows(books);
		pagedResult.setRecords(pageInfo.getTotal());
		return pagedResult;
	}
}
