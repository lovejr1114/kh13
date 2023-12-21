package oop.inherit2;

public class Test01상속이있는경우 {
	public static void main(String[] args) {
		GalaxyFold5 p1 = new GalaxyFold5();
		p1.call();
		p1.sms();
		p1.bixby();
		
		Iphone15 p2 = new Iphone15();
		p2.call();
		p2.sms();
		p2.siri();
	}
}
