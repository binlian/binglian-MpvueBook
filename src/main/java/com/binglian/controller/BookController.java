package com.binglian.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.binglian.pojo.Book;
import com.binglian.pojo.VO.BookPageVO;
import com.binglian.pojo.VO.BookVO;
import com.binglian.service.BookService;
import com.binglian.utils.BinglianJSONResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("admin/book")
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	/**
	 * 添加书籍
	 * @param book
	 * @return
	 */
	@PostMapping("/add")
	public BinglianJSONResult bookAdd(@RequestBody Book book){
		//判断书籍名称和作者是否为空
		if(StringUtils.isBlank(book.getBookTitle()) || StringUtils.isBlank(book.getBookAuthor()) 
				||StringUtils.isBlank(book.getBookImg()) || StringUtils.isBlank(book.getBookDesc())){
			return BinglianJSONResult.errorMsg("书籍标题和作者、图片地址、描述不能为空");
		}
		
		bookService.save(book);
		BookVO bookVO=new BookVO();
		BeanUtils.copyProperties(book, bookVO);
		return BinglianJSONResult.ok(bookVO);
	}
	
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public BinglianJSONResult delete(@RequestParam(name="id")Integer id){
		bookService.deleteById(id);
		return BinglianJSONResult.ok("删除成功");
	}
	
	/**
	 * 分页列表书籍
	 * @param page
	 * @param size
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(@RequestParam(value="page",defaultValue="1")Integer page,
						@RequestParam(value="size",defaultValue="10")Integer size,
						ModelMap model){
		PageHelper.startPage(page,size);
		List<Book> books=bookService.listAll();
		PageInfo<Book> bookPage=new PageInfo<>(books);
		
		BookPageVO<Book> bookPageVO=new BookPageVO<>();
		bookPageVO.setPage(bookPage.getPageNum());
		bookPageVO.setTotal(bookPage.getPages());
		bookPageVO.setRecords(bookPage.getTotal());
		bookPageVO.setRows(books);
		bookPageVO.setNextPage(bookPage.getNextPage());
		bookPageVO.setPrePage(bookPage.getPrePage());
		
		model.addAttribute("BookList", bookPageVO);
		return "admin/list";
	}
	
	/*
	 * 先要把编辑书籍 返回给前端 在声明一个方法提交修改的内容
	 * 编辑书籍
	 */
	@GetMapping("/edit")
	public String editArticle(@RequestParam(name="id") Integer id,ModelMap model){
		Book book=bookService.findById(id);
		
		model.addAttribute("Book", book);
		return "admin/edit";
	}
	
	@PostMapping("/update")
	public BinglianJSONResult update(@RequestBody Book book){
		if(book.getId() ==null || StringUtils.isBlank(book.getBookTitle())){
			return BinglianJSONResult.errorMsg("id和标题不能为空");
		}
		
		Book bookupdate=bookService.findById(book.getId());
		bookupdate.setBookAuthor(book.getBookAuthor());
		bookupdate.setBookDesc(book.getBookDesc());
		bookupdate.setBookImg(book.getBookImg());
		bookupdate.setBookTitle(book.getBookTitle());
		bookService.update(bookupdate);
		return BinglianJSONResult.ok("添加成功");
	}
	
	
}
