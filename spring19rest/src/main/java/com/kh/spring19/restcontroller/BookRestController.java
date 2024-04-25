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
import com.kh.spring19.vo.BookDataVO;

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
	public BookDataVO list(@PathVariable int page, @PathVariable int size){
		List<BookDto> list = bookDao.selectListByPagin(page, size);
		int count = bookDao.count();
		int endRow = page * size;
		boolean last = endRow >= count;
		return BookDataVO.builder()
					.list(list) //화면에 표시할 목록
					.count(count) //총 데이터 개수
					.last(last) //마지막 여부
				.build();
	}
}
