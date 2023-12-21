package oop.inherit8;

public class IPhone15 extends Phone {

	
	public IPhone15(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}

	@Override
	public void show() {
		System.out.println("전화번호 : " + this.getNumber() + ", 색상 : " + this.getColor());
	}

	@Override
	public void call() {
		System.out.println("IPhone15 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("IPhone15 문자 기능 실행");
	}
	//추가 메소드
	public void faceTime() {
		System.out.println("IPhone15 영상통화 기능 실행");
	}
	public void siri() {
		System.out.println("IPhone15 음성인식 기능 실행");
	}

}
