package oop.method9;

public class Account {
	//멤버 변수(멤버 필드) - 데이터
	String name;
	double basicRate;
	double preRate;
	int monthly;
	int year;
	
	//멤버 메소드 - 코드
	void data(String name, double basicRate, double preRate, int monthly, int year) {
		this.name = name;
		this.basicRate = basicRate;
		this.preRate = preRate;
		this.monthly = monthly;
		this.year = year;
	}
	
	int getMonthly() {
		return this.monthly * 12;
	}
	int interest() {
		return (int) (getMonthly() * (this.basicRate+this.preRate)/100);
	}
	int balance() {
		return interest() + this.monthly * 12;
	}
	int exp() {
		return balance() * this.year;
	}
	boolean tax() {
		return this.year <= 3;
	}
	
	
	
	void information() {
		System.out.println("<적금 통장 정보>");
		System.out.println("예금주 : " + this.name);
		System.out.println("기본 이율 : " +this.basicRate+ "%");
		System.out.println("우대 이율 : "+this.preRate + "%");
		System.out.println("월부금 : "+this.monthly);
		System.out.println("예치기간(년) : "+this.year);
		
		System.out.println("예상 이자 : " + interest()+"원");
		System.out.println("1년간 예금할 금액 : " + getMonthly()+"원");
		System.out.println("만기 시 예상 금액 : " + exp()+"원");
		
		if(tax()) {
			System.out.println("과세상품입니다.");
		}
		else {
			System.out.println("비과세상품입니다.");
		}
		System.out.println();
	}
}
