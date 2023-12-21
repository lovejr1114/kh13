package oop.inherit2;

//"휴대전화"의 공통점을 모아둔 추상적인 클래스
//-객체를 만들기 위함이 아니라 클래스를 편하게 만들기 위한 클래스
public class Phone {
	//공통 필드 - "휴대전화"라면 있어야하는 필드
	private String number; //핸드폰에는 전화번호가 있다
	private String color; // 핸드폰은 색상이 있다
	
	
	//공통 메소드 - "휴대전화"라면 있어야하는 기능
	public void call() { //휴대전화는 전화기능이 있어야 한다
		System.out.println("전화 기능");
	}
	public void sms() { //휴대전화는 문자 기능이 있어야 한다
		System.out.println("문자 기능");
	}
}
