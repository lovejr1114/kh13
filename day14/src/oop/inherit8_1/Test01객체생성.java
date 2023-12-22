package oop.inherit8_1;

public class Test01객체생성 {
	public static void main(String[] args) {
		
		Galaxy23FE p1 = new Galaxy23FE("010-1111-1111","로즈골드");		
		GalaxyFold5 p2 = new GalaxyFold5("010-2222-2222","블랙");	
		IPhone14 p3 = new IPhone14("010-3333-3333","스페이스그레이");
		IPhone15 p4= new IPhone15("010-4444-4444","블루");
		
		p1.show();
		p1.call();
		p1.sms();
		p1.samsungPay();
		p1.bixby();
		
		p2.show();
		p2.call();
		p2.sms();
		p2.samsungPay();
		p2.iris();
		
		p3.show();
		p3.call();
		p3.sms();
		p3.siri();
		p3.itunes();
		
		p4.show();
		p4.call();
		p4.sms();
		p4.siri();
		p4.faceTime();
	}
}
