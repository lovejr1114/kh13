package oop.inherit5;

public class Test01객체생성 {
	public static void main(String[] args) {
		IcePurifier p1 = new IcePurifier("코웨이", 500000);
		p1.information();
		p1.nomal();
		p1.cold();
		p1.ice();
		
		HotPurifier p2 = new HotPurifier("SK매직",650000);
		p2.information();
		p2.nomal();
		p2.hot();
		
		MultiPurifier p3 = new MultiPurifier("쿠쿠",450000);
		p3.information();
		p3.nomal();
		p3.cold();
		p3.hot();
	}
}
