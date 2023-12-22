package oop.inherit8_1;

public class IPhone14 extends IPhone {

	
	public IPhone14(String number, String color) {
		super(number, color);
	}

	@Override
	public void siri() {
		System.out.println("IPhone14의 음성인식 기능 실행 ");
	}

	@Override
	public void call() {
		System.out.println("IPhone14의 전화 기능 실행 ");
	}

	@Override
	public void sms() {
		System.out.println("IPhone14의 문자 기능 실행 ");
	}

	//추가 기능
		public void itunes() {
			System.out.println("IPhone14의 아이튠즈 기능 실행");
		}
}
