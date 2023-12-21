package oop.inherit4;

public class Iphone15 extends Phone{

	public Iphone15(String number) {
		super(number);
	}

	@Override
	public void internet() {
		System.out.println("사파리 브라우저 실행");
	}

	
}
