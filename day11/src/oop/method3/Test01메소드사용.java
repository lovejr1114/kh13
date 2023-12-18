package oop.method3;

public class Test01메소드사용 {
	public static void main(String[] args) {
		Mobile a = new Mobile();
		Mobile b = new Mobile();
		Mobile c = new Mobile();
		
		a.data("SK", "5G언택트 52", 52000, 200, 1000, 2000);
		b.data("KT", "5G 세이브", 45000, 100, 900, 1500);
		c.data("LG", "5G시그니처",130000, 500, 2000, 2500);
		
		System.out.println("통신사 요금제 정보");
		a.information();
		b.information();
		c.information();
	}
}
