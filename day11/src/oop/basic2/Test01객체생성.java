package oop.basic2;

public class Test01객체생성 {
	public static void main(String[] args) {
		//4명의 학생 데이터를 생성
		
		Student a =new Student();
		a.name = "뽀로로";
		a.grade = 1;
		a.score = 70;
		
		System.out.println("이름 : " +a.name + ", 학년 : " + a.grade + ", 점수 : " + a.score);

		
		Student b = new Student();
		b.name = "크롱";
		b.grade = 1;
		b.score = 55;
		
		System.out.println("이름 : " +b.name + ", 학년 : " + b.grade + ", 점수 : " + b.score);
		
		Student c = new Student();
		c.name = "포비";
		c.grade = 2;
		c.score = 80;
		
		System.out.println("이름 : " +c.name + ", 학년 : " + c.grade + ", 점수 : " + c.score);

		
		Student d = new Student();
		d.name = "해리";
		d.grade = 2;
		d.score = 75;
		
		System.out.println("이름 : " +d.name + ", 학년 : " + d.grade + ", 점수 : " + d.score);
	}
}
