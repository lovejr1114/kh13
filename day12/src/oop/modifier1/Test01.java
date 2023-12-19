package oop.modifier1;

public class Test01 {
	public static void main(String[] args) {
		Book a = new Book();
		
		a.data("마흔에 읽는 쇼펜하우어", "강용수", 15300, 850);
		
		a.information();
	}
}
