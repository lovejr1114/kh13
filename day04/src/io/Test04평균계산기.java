package io;

import java.util.Scanner;

public class Test04평균계산기 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int korean = sc.nextInt();
		int english = sc.nextInt();
		int math = sc.nextInt();
		
		//계산
		int result = korean + english + math;
		int average = result / 3;
		
		//출력
		//System.out.println("국어점수 = " + korean);
		//System.out.println("영어점수 = " + english);
		//System.out.println("수학점수 = " + math);
		System.out.println("총 점수는 " + result + "점입니다.");
		System.out.println("평균 점수는 " + average + "점입니다.");
	}

}
