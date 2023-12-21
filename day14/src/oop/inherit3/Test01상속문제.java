package oop.inherit3;

public class Test01상속문제 {
	public static void main(String[] args) {
		//상위(super) 클래스는 객체를 만들면 안된다 ex) Browser b1 = new ... 이렇게 상위클래스는 X
		
		Chrome b1 = new Chrome();
		System.out.println("<Chrome>");
		b1.setUrl("https://www.google.com");
		b1.refresh();
		b1.move();
		b1.develop();
		b1.chromeStore();
		
		Edge b2 = new Edge();
		System.out.println("<Edge>");
		b2.setUrl("https://www.daum.net");
		b2.refresh();
		b2.move();
		b2.fullScreen();
		
		Whale b3 = new Whale();
		System.out.println("<Whale>");
		b3.setUrl("https://www.naver.com");
		b3.refresh();
		b3.move();
		b3.papago();
		b3.naverSearch();
	}
}
