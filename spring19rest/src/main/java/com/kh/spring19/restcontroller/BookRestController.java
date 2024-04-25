package com.kh.spring19.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dao.BookDao;
import com.kh.spring19.dto.BookDto;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookDao bookDao;
	
	//목록
	@GetMapping("/")
	public List<BookDto> list(){
		return bookDao.selectList();
	}
	
	//페이징
	@GetMapping("/page/{page}/size/{size}")
	public List<BookDto> list(@PathVariable int page, @PathVariable int size){
		return bookDao.selectListByPagin(page, size);
	}
}
