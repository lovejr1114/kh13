package oop.inherit8_1;

public abstract class Phone {
	//필드
	private String number;
	private String color;
	
	//getter&setter
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//생성자
	public Phone(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}
	
	
	//메소드 (+추상 메소드)
	public final void show() { //다른 곳에서도 사용할거라 파이널로 불변하게 한다.
		System.out.println("<휴대전화 정보>");
		System.out.println("전화번호 : " + this.number);
		System.out.println("색상 : " + this.color);
	}
	//기능은 있어야하는데 내용은 모를 때
	public abstract void call();
	public abstract void sms();
	
}
