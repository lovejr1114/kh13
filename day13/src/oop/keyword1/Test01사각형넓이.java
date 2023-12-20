package oop.keyword1;

public class Test01사각형넓이 {
	public static void main(String[] args) {
		Calculator c = new Calculator(5, 7);
		System.out.println("넓이 : " + c.getResolution());
		
		Calculator c2 = new Calculator(6, 6);
		System.out.println("넓이 : " + c2.getResolution());
	}
}
