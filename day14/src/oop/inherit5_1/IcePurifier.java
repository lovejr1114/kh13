package oop.inherit5_1;
//얼음 정수기
public class IcePurifier extends Purifier {
	
	public IcePurifier(String company, int price) {
		super(company, price);
	}
	
	public void cold() {
		System.out.println("냉수 1잔 추출");
	}
	public void ice() {
		System.out.println("얼음 추출");
	}
	
	void information() { // 정수기 클래스(상속 super)에 넣으면 된다.(종류는 출력불가할듯)
		System.out.println();
		System.out.println("업체 : " + this.getCompany());
		System.out.println("가격 : " + this.getPrice());
		System.out.println("종류 : 얼음정수기");
	}
}
