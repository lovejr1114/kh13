package oop.inherit7;

//구현체 클래스
public class Iphone15 extends Phone {

	@Override
	public void call() {
		System.out.println("아이폰15 전화 기능");
	}

	@Override
	public void sms() {
		System.out.println("아이폰15 문자 기능");
	}

}
