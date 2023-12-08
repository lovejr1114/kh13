package condition;

import java.util.Scanner;

public class Test04여행사2 {
	public static void main(String[] args) {
		//KH여행사
		//'어디든 무조건 1사람 1박에 10만원
		//여름매출 저조해서 여름에 여행하는 사람 추가로 20% 할인 진행
		//사용자에게 인원수, 기간(일), 예정(월)을 입력 받아 예상 금액 구하여 출력
		//단, 여름은 6,7,8월입니다.
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 입력 : ");
		int people = sc.nextInt();  //금액과 관련 된 데이터
		System.out.print("여행가는 달(1~12) 입력 : ");
		int month = sc.nextInt(); //할인과 관련 된 데이터
		System.out.print("여행 기간(일) 입력 : ");
		int day = sc.nextInt(); //금액과 관련 된 데이터
		
		int price = 100000;

		
		//
		boolean summer = month == 6 || month == 7 || month == 8;
	
		
		
		//출력
		if(summer) {
			int total = people * day * price; //원래 금액
			int discount = total * 20 /100; //할인 금액
			int result = total - discount; //총 금액
			System.out.println("어머! 여름에 여행 가시네요?");
			System.out.println("예상 금액은 " + total + "원입니다");
			System.out.println("할인금액은 " + discount + "원입니다");
			System.out.println("총 금액은  " + result + "원입니다.");
			
		}
		else {
			int total = people * day * price;
			System.out.println("아쉽지만 행사 대상은 아닙니다");
			System.out.println("예상 금액은 " + total + "원입니다.");
		}
	}

}
