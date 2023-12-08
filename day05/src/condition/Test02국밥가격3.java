package condition;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02국밥가격3 {
	public static void main(String[] args) {
		//KH국밥집 국밥 한 그릇 7천원
		//65세 이상 어르신에게 30% 할인된 가격으로 판매
		//사용자에게 출생년도 8자리 입력받고 (한국나이로 계산)
		//주문할 수량 입력받아서 결제할 금액 출력
		int price = 7000;
		int rate = 30;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("귀하의 생년월일 8자리를 입력 해 주세요 : " );
		int birth = sc.nextInt();
		System.out.print("주문 할 국밥 수량을 입력 해 주세요 : ");
		int count = sc.nextInt();
		
	
		
		//계산
		int year = birth / 10000;
		int age = 2023 - year + 1;
		//int age = LocalDate.now().getYear() - year + 1;

		
		boolean discount = age >= 65;
		
		
		//출력
		if(discount) { // 세미콜론 적지 않도록 조심하자. 세미콜론을 적으면 의미가 아예 달라짐.
			int total = price * count * (100-rate) / 100;
			System.out.println("가격 : " + total + "원");
			//할인대상(65세 이상) 이라면
			
		}
		else {  //else는 나머지조건이기 때문에 조건을 적을 수 없다.
			int total = price * count;
			System.out.println("가격 : " + total + "원");
			//할인대상이 아니라면
		}
		

	}

}
