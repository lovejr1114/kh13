package oop.inherit3;

//공통 부분들을 모아 만든 상위(super) 클래스
public class Browser {
	//필드
	private String url;
	
	//메소드
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void refresh() {
		System.out.println("새로고침 기능");
	}
	public void move() {
		System.out.println("페이지 이동 기능");
	}	
}
