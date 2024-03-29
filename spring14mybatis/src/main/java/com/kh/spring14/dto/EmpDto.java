package com.kh.spring14.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpDto {
	private int empNo;
	private String empName;
	private String empDept;
//	private Date empDate;
	private String empDate;
	private int empSal;
}
