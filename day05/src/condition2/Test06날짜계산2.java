package condition2;

import java.util.Scanner;

public class Test06날짜계산2 {
	public static void main(String[] args) {
		//사용자에게 연도와 월 입력 받아 해당 달의 마지막 날짜를 구하여 출력
		//큰달 : 31일까지 존재 (1,3,5,7,8,10,12)
		//작은달 : 30일까지존재 (4,6,9,11)
		//2월 : 윤년일 경우 29일, 아닐 경우 28일까지 존재
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
	
		int day;
		if(month == 2) {
			boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
			if(leap) {
				day = 29;
			}
			else {
				day =28;
			}
		}
		else if(month == 4 || month == 6 || month ==9 || month == 11) {
			day = 30;
		}
		else {
			day = 31;
		}
		
		
		
		
		//
		System.out.println(year + "년 " + month + "월은 " + day + "일까지 있습니다.");
	}

}
