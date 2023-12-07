package io;

import java.util.Scanner;

public class Test04평균계산기 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in); //스캐너는 하나만 사용해도 된다.
		System.out.println("국어 점수를 입력하세요.");
		int korean = sc.nextInt();
		System.out.println("영어 점수를 입력하세요.");
		int english = sc.nextInt();
		System.out.println("수학 점수를 입력하세요.");
		int math = sc.nextInt();
		
		//계산
		int result = korean + english + math;
		//int average = result / 3;
		double average = result / 3.0; //-> 평균은 소수점이 나와야하기 때문에 더블로 입력해준다.
		//double average = result / 3d;
		//double average = (double)result / 3;
		
		//출력
		//System.out.println("국어점수 = " + korean);
		//System.out.println("영어점수 = " + english);
		//System.out.println("수학점수 = " + math);
		System.out.println("총 점수는 " + result + "점입니다.");
		System.out.println("평균 점수는 " + average + "점입니다.");
	}

}
