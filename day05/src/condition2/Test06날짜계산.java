package condition2;

import java.util.Scanner;

public class Test06날짜계산 {
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
		
		
		//
		boolean leap = year % 4 == 0;	
		
		
		
		String day;
		int last;
		if(month == 1 || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10 || month ==12) {
			last = 31;
			day = year +"년 " + month + "월은 " + last + "일까지 있습니다.";
		}
		else if(month == 4 || month == 6 || month ==9 || month == 11) {
			last = 30;
			day = year +"년 " + month + "월은 " + last + "일까지 있습니다.";
		}
		else if(year % 4 == 0 && month == 2) {
			last = 29;
			day = year +"년 " + month + "월은 윤년이며, " + last + "일까지 있습니다.";
		}
		else {
			last = 28;
			day = year +"년 " + month + "월은 " + last + "일까지 있습니다.";
		}
		
		
		
		
		//
		System.out.println();
		System.out.println(day);
	}

}
