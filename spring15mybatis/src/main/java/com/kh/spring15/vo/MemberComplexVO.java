package com.kh.spring15.vo;

import java.util.List;

import lombok.Data;

@Data
public class MemberComplexVO {
	private String memberId;
	private String memberNick;
	private String memberContact;
	private Integer minPoint, maxPoint;
	private String memberJoin;
	private String minLoginDate, maxLoginDate;
	private List<String> memberLevelList;
	private List<String> orderList;
	//없을 수도 있어서 int가 아니라 Integer
	
	private int page=1, size=10;
//	private Integer beginRow, endRow;
	
	//가상의 getter메소드
	public int getBeginRow() {
		return page * size - (size-1);
	}
	
	public int getEndRow() {
		return page * size;
	}
}
