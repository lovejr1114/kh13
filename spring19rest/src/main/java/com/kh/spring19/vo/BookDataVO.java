package com.kh.spring19.vo;

import java.util.List;

import com.kh.spring19.dto.BookDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//무한 스크롤을 위한 VO
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BookDataVO {
	private List<BookDto> list;
	private int count;
	private boolean last;
}
