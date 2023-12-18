package oop.method4;

public class Cafe {
	String menu;
	String sort;
	int price;
	String event;
	
	void information() {
		if(event == "(행사중)") {
			this.price = this.price - this.price*20/100;
			System.out.println("메뉴이름 : "+this.menu + this.event);
		}
		else{
			System.out.println("메뉴이름 : "+this.menu);
		}
		System.out.println("분류 : "+ this.sort);
		System.out.println("가격 : " + this.price + "원");
		System.out.println();
	}
	
	void data(String menu, String sort, int price, String event) {
		this.menu = menu;
		this.sort = sort;
		this.price = price;
		this.event = event;
	}
}
