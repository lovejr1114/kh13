package oop.method7;

public class Record {
	int grade;
	int group;
	String name;
	int korean;
	int english;
	int math;
	
	
	void data(int grade, int group, String name, int korean, int english, int math) {
		this.grade = grade;
		this.group = group;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	void information(){
		System.out.println("<학생 성적 정보>");
		System.out.println(this.grade+ "학년 " + this.group + "반");
		System.out.println("이름: " +this.name);
		System.out.println("국어 점수 : " + this.korean + "점");
		System.out.println("영어 점수 : " + this.english + "점");
		System.out.println("수학 점수 : " + this.math + "점");
		System.out.println("총점 : " + (this.korean + this.english + this.math) +"점");
		double average = (double)(this.korean + this.english + this.math) / 3;
		System.out.println("평균 : " + average + "점");
		if(this.korean >= 40 && this.english >= 40 && this.math >= 40 && average >= 60) {
			System.out.println("통과입니다.");
		}
		else {
			System.out.println("재평가입니다.");
		}
		System.out.println();
	}
}
