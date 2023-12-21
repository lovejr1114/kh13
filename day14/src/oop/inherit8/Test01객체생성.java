package oop.inherit8;

public class Test01객체생성 {
	public static void main(String[] args) {
		
		Galaxy23FE p1 = new Galaxy23FE("010-1111-2222","핑크");
		p1.show();
		p1.call();
		p1.sms();
		p1.samsungPay();
		p1.bixby();
		
		GalaxyFold5 p2 = new GalaxyFold5("010-2222-3333","검정");
		p2.show();
		p2.call();
		p2.sms();
		p2.samsungPay();
		p2.iris();
		
		IPhone14 p3 = new IPhone14("010-3333-4444","스페이스그레이");
		p3.show();
		p3.call();
		p3.sms();
		p3.itunes();
		p3.siri();
		
		IPhone15 p4= new IPhone15("010-4444-4444","블루");
		p4.show();
		p4.call();
		p4.sms();
		p4.faceTime();
		p4.siri();
	}
}
