package oop.inherit5;

public class IcePurifier extends Purifier {
	public IcePurifier(String company, int price) {
		super(company, price);
	}
	
	public void cold() {
		System.out.println("냉수 1잔");
	}
	public void ice() {
		System.out.println("얼음");
	}
	
	void information() {
		System.out.println();
		System.out.println("업체 : " + this.getCompany());
		System.out.println("가격 : " + this.getPrice());
		System.out.println("종류 : 얼음정수기");
	}
}
