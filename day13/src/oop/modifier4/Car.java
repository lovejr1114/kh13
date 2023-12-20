package oop.modifier4;

public class Car {
	private String name;
	private int speed;
	
	//아무 키워드도 사용하지 않으면 접근제한은 package로 설정
	//- 다른 패키지에서는 접근이 불가
	//만약 모두에게 공개하고싶다면 public 키워드를 붙이자
	public Car(String name, int speed) {
		this.setName(name);
		this.setSpeed(speed);
	}
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getSpeed() {
		return speed;
	}
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void information() {
		System.out.println("이름 : " + this.name);
		System.out.println("속도 : " + this.speed);
	}
}
