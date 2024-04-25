package com.kh.spring19.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublication;
	private int bookPrice;
	private String bookPublisher;
	private int bookPageCount;
	private String bookGenre;

}
