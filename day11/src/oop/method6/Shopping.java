package oop.method6;

public class Shopping {
	String name;
	String type;
	int price;
	boolean dawn;
	boolean event;
	
	void data(String name, String type, int price, boolean dawn) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.dawn = dawn;
	}
	
	void data(String name, String type, int price, boolean dawn, boolean event) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.dawn = dawn;
		this.event = event;
	}
	
	void information() {
		System.out.println("<온라인 쇼핑몰 상품 정보>");
		System.out.println("상품명 : " + this.name);
		System.out.println("상품분류 : "+ this.type);
		if(this.event) {
			int discount = this.price * 90 /100;
			System.out.println("판매가 : " + discount + "원 (행사중) (원가 : " +this.price+"원, 10%할인)" );
		}
		else {
		System.out.println("판매가 : " + this.price);
		}
		if(this.dawn) {
			System.out.println("새벽 배송 가능한 상품이므로 배송비 2500원이 추가됩니다.");
		}
		System.out.println();
	}
	
}
