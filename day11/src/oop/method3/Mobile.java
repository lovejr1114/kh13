package oop.method3;

public class Mobile {
	//멤버 변수 (필드)
	String telecom;
	String product;
	int money;
	int gb;
	int call;
	int message;
	
	void information() {
		System.out.println();
		System.out.println("통신사 : " + this.telecom);
		System.out.println("상품명 : " + this.product);
		System.out.println("월정액 : " + this.money + "원");
		System.out.println("데이터 : "+this.gb+"GB, 통화 : "+this.call+"분, 문자 : "+this.message+"건");
	}
	
	void data(String telecom, String product, int money, int gb, int call, int message) {
		this.telecom = telecom;
		this.product = product;
		this.money = money;
		this.gb = gb;
		this.call = call;
		this.message = message;
	}
}
