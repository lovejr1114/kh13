package oop.method9;

public class Test01 {
	public static void main(String[] args) {
		
		Account a = new Account();
		Account b = new Account();
		Account c = new Account();
		
		a.data("유재석", 2.2f, 1f, 500000, 2);
		b.data("강호동", 2.5f, 1f, 500000, 2);
		c.data("신동엽", 2.35f, 1.5f, 600000, 3);
		
		a.information();
		b.information();
		c.information();
	}
}
