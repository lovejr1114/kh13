package oop.inherit8;

public class GalaxyFold5 extends Phone {

	
	public GalaxyFold5(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}

	@Override
	public void show() {
		System.out.println("전화번호 : " + this.getNumber() + ", 색상 : " + this.getColor());
	}

	@Override
	public void call() {
		System.out.println("갤럭시폴드5 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시폴드5 문자 기능 실행");
	}
	
	//추가 메소드
	public void samsungPay() {
		System.out.println("갤럭시폴드5 삼성페이 기능 실행");
	}
	public void iris() {
		System.out.println("갤럭시폴드5 홍채인식 기능 실행");
	}

}
