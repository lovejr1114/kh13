package oop.method9;

public class Test01 {
	public static void main(String[] args) {
		
		Account a = new Account();
		Account b = new Account();
		Account c = new Account();
		
		a.data("유재석", 2.20, 1, 500000, 2);
		b.data("강호동", 2.5, 1, 500000, 2);
		c.data("신동엽", 2.35, 1.5, 600000, 3);
		
		a.information();
		b.information();
		c.information();
	}
}
