package oop.method4;

public class Cafe {
	String menu;
	String sort;
	int price;
	boolean event;
	
	void data(String menu, String sort, int price, boolean event) {
		this.menu = menu;
		this.sort = sort;
		this.price = price;
		this.event = event;
	}
	
	
	void information() {
		System.out.println("<메뉴 정보>");
		if(this.event) {
			System.out.println("이름 : " + this.menu + " (행사중)");
		}
		else {
			System.out.println("이름 : " +this.menu);
		}
		System.out.println("분류 : "+ this.sort);
		
		//(주의) 할인은 즉석에서 계산해서 만들어내는것이지, 저장하는게 아니다.
		//그래서 변수보다는 출력 쪽에서 할인해주는게 좋다.
		if(this.event) {
			int discount =  this.price * 80 /100;
			System.out.println("가격 : " + discount + "원" + " (원가:" +
		this.price+"원, 20% 할인)");
		}
		else {
		System.out.println("가격 : " + this.price + "원");
		}
		System.out.println();
	}
	
}
