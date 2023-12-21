package oop.inherit8;

public class Galaxy23FE extends Phone {


	public Galaxy23FE(String number, String color) {
		this.setNumber(number)	;
		this.setColor(color);
	}

	@Override
	public void show() {
		System.out.println("전화번호 : " + this.getNumber() + ", 색상 : " + this.getColor());
	}

	@Override
	public void call() {
		System.out.println("갤럭시23FE 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시23FE 문자 기능 실행");
	}
	
	//추가 메소드
	public void samsungPay() {
		System.out.println("갤럭시23FE 삼성페이 기능 실행");
	}
	public void bixby() {
		System.out.println("갤럭시23FE 음성인식 기능 실행");
	}

}
