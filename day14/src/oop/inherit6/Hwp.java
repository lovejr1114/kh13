package oop.inherit6;

public class Hwp extends PapersFile {

	public Hwp(String name, int size, int page) {
		super(name, size, page);
	}
	
	public void perview() {
		System.out.println("미리보기 기능");
	}
	
	void output() {
		System.out.println("파일 이름 : " + this.getName());
		System.out.println("파일 크기 : " + this.getSize());
		System.out.println("페이지 수 : " + this.getPage());
	}
}
