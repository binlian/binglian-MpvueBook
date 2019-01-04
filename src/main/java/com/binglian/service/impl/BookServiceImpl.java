package com.binglian.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binglian.mapper.BookMapper;
import com.binglian.pojo.Book;
import com.binglian.service.BookService;
import com.mysql.fabric.xmlrpc.base.Data;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public Book findById(int id) {
		bookMapper.findById(id);
		return bookMapper.findById(id);
	}

	@Override
	public void deleteById(int id) {
		bookMapper.deleteById(id);
	}

	@Override
	public void save(Book book) {
		book.setCreateTime(new Date());
		book.setUpdateTime(new Date());
		book.setId(null);
		bookMapper.insert(book);
	}

	@Override
	public List<Book> listAll() {

		return bookMapper.selectAll();
	}

	@Override
	public int update(Book book) {
		book.setUpdateTime(new Date());
		return bookMapper.updateById(book);
	}

}
