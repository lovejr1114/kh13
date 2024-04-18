package com.kh.spring19.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "사원 정보 객체") //springdoc에 추가되는 설명
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EmpDto {
	private int empNo;
	private String empName;
	private String empDept;
	private String empDate;
	private String empSal;
}
