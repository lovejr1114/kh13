package oop.inherit6_1;

public class Hwp extends DocumentFile {
	//추가되는 필드는 없음
	
	public Hwp(String filename, int pageSize) {
		super(filename, pageSize);
	}
	public Hwp(String filename, long filesize, int pageSize) {
		super(filename, filesize, pageSize);
	}
	public Hwp(String filename, long filesize) {
		super(filename, filesize);
	}
	public Hwp(String filename) {
		super(filename);
	}	
	
	//추가되는 메소드 구현
	public void preview() {
		System.out.println("문서 미리보기 기능");
	}
	
	//출력 란에 굳이 다른 내용정보 출력 하지 않아도 됨 (선택사항)
}
