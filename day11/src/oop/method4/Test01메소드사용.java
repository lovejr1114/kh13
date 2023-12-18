package oop.method4;

public class Test01메소드사용 {
	public static void main(String[] args) {
		
		Cafe m1 = new Cafe();
		Cafe m2 = new Cafe();
		Cafe m3 = new Cafe();
		Cafe m4 = new Cafe();
		
		m1.data("아메리카노","음료",2500,"(행사중)");
		m2.data("모카라떼","음료",3500,"-");
		m3.data("치즈케이크", "디저트", 5000,"(행사중)");
		m4.data("마카롱", "디저트",3000,"-");
		
		m1.information();
		m2.information();
		m3.information();
		m4.information();
	}
}
