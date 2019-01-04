package com.binglian.mapper;

import com.binglian.pojo.Book;
import com.binglian.utils.MyMapper;

public interface BookMapper extends MyMapper<Book> {
	
		//根据id删除文章
		int deleteById(int id);
		
		//根据id查询文章
		Book findById(int id);
		
		//根据id更新文章
		int updateById(Book book);
}