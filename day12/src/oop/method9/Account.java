package oop.method9;

public class Account {
	//멤버 변수(멤버 필드) - 데이터
	String name;
	float basicRate;
	float preRate;
	int monthly;
	int year;
	
	//멤버 메소드 - 코드
	void data(String name, float basicRate, float preRate, int monthly, int year) {
		this.name = name;
		this.basicRate = basicRate;
		this.preRate = preRate;
		this.monthly = monthly;
		this.year = year;
	}
	
	int getMonthly() {
		return this.monthly * 12;
	}
	int getTotal() {
		return this.getMonthly() * this.year;
	}
	int getInterest() {
		return (int) (getTotal() * getTotalRate() / 100);
	}
	int getBalance() {
		return getInterest() + this.monthly * 12;
	}
	int getExp() {
		return getBalance() * this.year;
	}
	boolean tax() {
		return this.year <= 3;
	}
	//총 적용 이율을 구하는 메소드
	float getTotalRate() {
		return this.basicRate + this.preRate;
	}
	String getName() {
		return this.name;
	}
	
	
	void information() {
		System.out.println("<적금 통장 정보>");
		System.out.println("예금주 : " + getName());
		System.out.println("예치기간(년) : "+this.year+"년");		
		System.out.print("적용이율 : 기본(" +this.basicRate+ "%) +");
		System.out.print(" 우대("+this.preRate + "%) = ");
		System.out.println("총 ("+getTotalRate()+"%)");
		System.out.println("월 입금액 : "+this.monthly);
		System.out.println("연 입금액 : " + this.getMonthly()+"원");
		System.out.println("총 입금액 : " + this.getTotal() +"원");
		System.out.println("총 이자 : " + this.getInterest()+"원");		
		System.out.println("만기 시 예상 금액 : " + getExp()+"원");
		
		if(tax()) {
			System.out.println("과세상품입니다.");
		}
		else {
			System.out.println("비과세상품입니다.");
		}
		System.out.println();
	}
}
