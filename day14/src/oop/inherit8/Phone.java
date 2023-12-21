package oop.inherit8;

public abstract class Phone {
	//필드
	private String number;
	private String color;
	
	
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
	
	
//	public void information() {
//		System.out.println("전화번호 : " +this.getNumber());
//		System.out.println("색상 : " + this.getColor());
//	}
	
	//추상 메소드
	public abstract void show();
	public abstract void call();
	public abstract void sms();
	
}
