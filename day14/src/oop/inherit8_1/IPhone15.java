package oop.inherit8_1;

public class IPhone15 extends IPhone {

	
	public IPhone15(String number, String color) {
		super(number, color);
	}

	@Override
	public void siri() {
		System.out.println("IPhone15의 음성인식 기능 실행 ");
	}

	@Override
	public void call() {
		System.out.println("IPhone15의 전화 기능 실행 ");
	}

	@Override
	public void sms() {
		System.out.println("IPhone15의 문자 기능 실행 ");
	}

	//추가 기능
		public void faceTime() {
			System.out.println("IPhone15의 영상통화 기능 실행");
		}
}
