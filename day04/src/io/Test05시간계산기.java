package io;

import java.util.Scanner;

public class Test05시간계산기 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("입실시간 입력 : ");
		int inTime = sc.nextInt();
		System.out.print("퇴실시간 입력 : ");
		int outTime = sc.nextInt();
		
		//계산
		int inHour = inTime / 100, inMinute = inTime % 100;
		//System.out.println(inHour);
		//System.out.println(inMinute);
		int outHour = outTime / 100, outMinute = outTime % 100;
		//System.out.println(outHour);
		//System.out.println(outMinute);
		int study = (outHour * 60 + outMinute) - (inHour * 60 + inMinute);
		//System.out.println(study);
		int stuH = study / 60, stuM = study % 60;
		//System.out.println(stuH);
		//System.out.println(stuM);
		
		
		//출력
		System.out.println("수업에 참여한 시간은 총 " + stuH + "시간 " + stuM + "분입니다.");
	}

}
