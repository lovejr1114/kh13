package condition2;

import java.util.Scanner;

public class Test03여행사프로모션 {
	public static void main(String[] args) {
		//KH여행사 프로모션 진행
		//무조건 1인당 1박 10만원
		//사용자에게 인원수,기간(일),예정(월) 입력받아
		//봄 3,4,5 할인 20
		//여름 6,7,8, 할인 10
		//가을 9,10,11 할인 30
		//겨울 12,1,2 할인 5
		
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("여행 인원 수 입력 : ");
		int people = sc.nextInt();
		System.out.print("여행 예정 월 입력 : ");
		int month = sc.nextInt();
		System.out.print("여행 예정 일 입력 : ");
		int day = sc.nextInt();
		int price = 100000;
		
	
		//boolean spring = month == 3 || month == 4 || month == 5;
	//	boolean summer = month == 6 || month == 7 || month == 8;
		//boolean fall = month == 9 || month == 10 || month == 11;
	//	boolean winter = month == 12 || month == 1 || month == 2;
		
		
		//
		int discount;
		if(month == 3 || month == 4 || month == 5) {
			discount = 20;
		}
		else if(month == 6 || month == 7 || month == 8) {
			discount = 10;
		}
		else if(month == 9 || month == 10 || month == 11) {
			discount = 30;
		}
		else {
			discount = 5;
		}
		
		int pay = people * day * price; //총 금액
		int event = pay * discount / 100; //할인 금액
		int result = pay - event; //총 금액
		
		System.out.println("여행 총 비용은 " + pay + "원입니다.");
		System.out.println("할인율은 " + discount + "% 입니다.");
		System.out.println("할인 금액은 " + event + "원입니다.");
		System.out.println("할인 된 여행 비용은 " + result + "원입니다.");
		
		
	}

}
