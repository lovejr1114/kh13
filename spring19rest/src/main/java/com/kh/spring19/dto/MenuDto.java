package com.kh.spring19.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MenuDto {
	private int menuNo;
	private String menuNameKor;
	private String menuNameEng;
	private String menuType;
	private int menuPrice;
}
