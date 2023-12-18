package oop.method6;

public class Test01객체생성 {
	public static void main(String[] args) {
		
		Shopping a = new Shopping();
		Shopping b = new Shopping();
		Shopping c = new Shopping();
		Shopping d = new Shopping();
		
		a.data("참이슬후레쉬", "주류", 1200, true, true);
		b.data("클라우드맥주", "주류", 3000, false, true);
		c.data("바나나킥", "과자", 1500, false, true);
		d.data("허니버터칩","과자",2000,true, false);
		
		a.information();
		b.information();
		c.information();
		d.information();
	}
}
