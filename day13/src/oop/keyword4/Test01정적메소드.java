package oop.keyword4;

public class Test01정적메소드 {
	public static void main(String[] args) {
		System.out.println("11의 제곱 : " + Robot.square(11));		
		System.out.println("폭5,높이7 삼각형 넓이 : " + Robot.triangle(5, 7));
		System.out.println("원의 넓이 : " + Robot.circle(5));
		System.out.println("지하철 요금 : " + Robot.subway(1995));
		System.out.println("2000년은 윤년인가? " + Robot.leap(2000));
		System.out.println("157/45의 BMI = " + Robot.bmi(157, 45));
	}
}
