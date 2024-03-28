package com.kh.spring10.dto;

import lombok.Data;

@Data
//@Setter @Getter @NoArgsConstructor @ToString 이것을 한 번에 묶은 것이 @Data
public class PocketmonDto {
	private int pocketmonNo;
	private String pocketmonName;
	private String pocketmonType;
}
