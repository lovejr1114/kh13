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
	private Integer beginRow, endRow;
	
	//없을 수도 있어서 int가 아니라 Integer
}
