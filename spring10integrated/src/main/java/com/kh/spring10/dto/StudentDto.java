package com.kh.spring10.dto;

import lombok.Data;

@Data
public class StudentDto {
	private int studentId;
	private String name;
	private int koreanScore;
	private int mathScore;
	private int englishScore;
	
	public int getTotal() {
		return koreanScore+mathScore+englishScore;
	}
	public float getAverage() {
		return getTotal() / 3f;
	}
}
