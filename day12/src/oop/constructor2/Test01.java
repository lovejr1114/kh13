package oop.constructor2;

public class Test01 {
	public static void main(String[] args) {
		Music r1 = new Music("Perfect Night","르세라핌",104250,91835);
		Music r2 = new Music("첫 눈","EXO",83127,90805);
		Music r3 = new Music("Drama","aespa",64590,174519);
		Music r4 = new Music("To.X","태연",58826,70313);
		
		System.out.println("<음원 차트>");
		r1.information();
		r2.information();
		r3.information();
		r4.information();
	}
}
