package com.kh.spring10.dto;

import lombok.Data;

@Data
public class ReplyDto {
	private int replyNo;
	private String replyContent;
	private String replyTime;
//	private Date replyTime; // 시간을 출력하려면 데이터보다 String으로 해줘야함
	private String replyWriter;
	private int replyOrigin;
	
}
