package oop.inherit5_1;

public class MultiPurifier extends Purifier {
	public MultiPurifier(String company, int price) {
		super(company, price);
	}
	public void cold() {
		System.out.println("냉수 1잔 추출");
	}
	public void hot() {
		System.out.println("온수 1잔 추출");
	}
	
	void information() {
		System.out.println();
		System.out.println("업체 : "+this.getCompany());
		System.out.println("가격 : "+this.getPrice());
		System.out.println("종류 : 복합정수기");
	}
}
