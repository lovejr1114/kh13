package oop.inherit6_1;

public class Ppt extends DocumentFile {
	//추가필드없음
	//생성자 맞춤
	public Ppt(String filename, int pageSize) {
		super(filename, pageSize);
	}
	public Ppt(String filename, long filesize, int pageSize) {
		super(filename, filesize, pageSize);
	}
	public Ppt(String filename, long filesize) {
		super(filename, filesize);
	}
	public Ppt(String filename) {
		super(filename);
	}
	
	//추가되는 메소드
	public void slideShow() {
		System.out.println("슬라이드쇼 시작");
	}

}
