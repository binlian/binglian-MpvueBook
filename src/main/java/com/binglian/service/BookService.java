package com.binglian.service;

import java.util.List;

import com.binglian.pojo.Book;
import com.binglian.pojo.User;

public interface BookService {

	//根据id查询书籍
	Book findById(int id);
	
	//根据id删除书籍
	void deleteById(int id);
	
	//获取所有书籍所有内容
	List<Book> listAll();
	
	//添加书籍
	void save(Book book);
	//更新书籍
	int update(Book book);
}
