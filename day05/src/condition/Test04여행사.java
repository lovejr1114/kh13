package condition;

import java.util.Scanner;

public class Test04여행사 {
	public static void main(String[] args) {
		//KH여행사
		//'어디든 무조건 1사람 1박에 10만원
		//여름매출 저조해서 여름에 여행하는 사람 추가로 20% 할인 진행
		//사용자에게 인원수, 기간(일), 예정(월)을 입력 받아 예상 금액 구하여 출력
		//단, 여름은 6,7,8월입니다.
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("여행인원을 입력해주세요 : ");
		int person = sc.nextInt();
		System.out.print("여행 가실 날짜(월)를 입력해주세요 : ");
		int month = sc.nextInt();
		System.out.print("여행 가실 날짜(일)를 입력해주세요 : ");
		int day = sc.nextInt();
		
		int price = 100000;
		int discount = 20;
		
		//
		boolean summer = month > 5 && month < 9;
				//System.out.println(summer);

		int pay = person * day * price;
		//System.out.println(pay);
		
		
		//출력
		if(summer) {
			int total = pay * (100-discount) /100;
			System.out.println("여행 금액은 총 " + total + "원입니다.");
			
		}
		else {
			System.out.println("여행 금액은 총 " + pay + "원입니다.");
		}
	}

}
