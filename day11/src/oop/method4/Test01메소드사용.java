package oop.method4;

public class Test01메소드사용 {
	public static void main(String[] args) {
		
		Cafe a = new Cafe();
		Cafe b = new Cafe();
		Cafe c = new Cafe();
		Cafe d = new Cafe();
		
		a.data("아메리카노", "음료", 2500, true);
		b.data("모카라떼", "음료", 3500, false);
		c.data("치즈케이크", "디저트", 5000, true);
		d.data("마카롱", "디저트", 3000, false);
		
		a.information();
		b.information();
		c.information();
		d.information();
	}
}
