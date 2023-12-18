package oop.basic3;

public class Test01객체생성 {
	public static void main(String[] args) {
		
		Epl c1 = new Epl();
		Epl c2 = new Epl();
		Epl c3 = new Epl();
		Epl c4 = new Epl();
		
		c1.rank = 1;
		c1.club = "아스널";
		c1.win = 12;
		c1.draw = 3;
		c1.lose = 2;
		
		c2.rank = 2;
		c2.club = "리버풀";
		c2.win = 11;
		c2.draw = 5;
		c2.lose = 1;
		
		c3.rank = 3;
		c3.club = "애스턴 빌라";
		c3.win = 12;
		c3.draw = 2;
		c3.lose = 3;
		
		c4.rank = 4;
		c4.club = "맨시티";
		c4.win = 10;
		c4.draw = 4;
		c4.lose = 3;
		
		System.out.println("\t\t영국 축구 순위");
		System.out.println("순위\t클럽명\t\t승리\t무승부\t패배");
		System.out.println(c1.rank +"\t"+ c1.club +"\t\t"+ c1.win +
				"\t"+ c1.draw +"\t"+ c1.lose);
		System.out.println(c2.rank +"\t"+ c2.club +"\t\t"+ c2.win +
				"\t"+ c2.draw +"\t"+ c2.lose);
		System.out.println(c3.rank +"\t"+ c3.club + "\t" + c3.win +
				"\t"+ c3.draw +"\t"+ c3.lose);
		System.out.println(c4.rank +"\t"+ c4.club +"\t\t"+ c4.win +
				"\t"+ c4.draw +"\t"+ c4.lose);
	}
}
