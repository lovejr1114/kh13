package condition;

import java.util.Scanner;

public class Test02국밥가격 {
	public static void main(String[] args) {
		//KH국밥집 국밥 한 그릇 7천원
		//65세 이상 어르신에게 30% 할인된 가격으로 판매
		//사용자에게 출생년도 8자리 입력받고 (한국나이로 계산)
		//주문할 수량 입력받아서 결제할 금액 출력
		
		int rice = 7000;
		int discount = 30;
		int year = 2023;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("귀하의 생년월일 8자리를 입력 해 주세요 : " );
		int birth = sc.nextInt();
		System.out.print("주문 할 국밥 수량을 입력 해 주세요 : ");
		int orderCount = sc.nextInt();
		
		//계산
		int age = birth / 10000;
		int age2 = year - age + 1;
		int price = rice * orderCount;
		int pay = price * (100-discount) / 100;


		boolean disAge = age2 >= 65;

		
		//65세 이상일 때 30퍼 할인된 가격 적용
		//if(disAge == disPri)
			//System.out.println();
		
		
		//출력
		if (disAge) {
			//int pay = price * (100-discount) / 100;
			System.out.print("결제 금액은" + pay + "원입니다.");
		}

		


	}

}
