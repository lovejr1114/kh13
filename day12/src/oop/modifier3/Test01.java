package oop.modifier3;

public class Test01 {
	public static void main(String[] args) {
		Sellphone a = new Sellphone();
		Sellphone b = new Sellphone();
		Sellphone c = new Sellphone();
		Sellphone d = new Sellphone();
		
		a.data("갤럭시 Fold4", "SK", 1800000);
		b.data("갤럭시 Fold4", "KT", 1750000, 24);
		c.data("아이폰15", "LG", 2000000, 30);
		d.data("아이폰15", "SK", 1990000);
		
		a.information();
		b.information();
		c.information();
		d.information();
	}
}
