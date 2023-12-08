
package condition2;

import java.util.Scanner;

public class Test02지하철요금2 {
	public static void main(String[] args) {
		//어르신 65세이상 무료
		//성인 20이상65미만 1400원
		//청소년 14이상 20미만 800원
		//어린이 8이상 14미만 500원
		//영유아 8미만 무료
		//-시간 되면 카드보증금 500원 추가계산
		
		//사용자 나이 입력받아 요금 계산
		
		//계산 과정을 조건으로 처리

				//입력
				int age = 65;

				int price;
				if(age >= 65 || age < 8) {//어르신 또는 영유아
					price = 0;
				}
				else if(age >= 20) {
					price = 1400;
				}
				else if(age >= 14) {
					price = 800;
				}
				else {
					price = 500;
				}

				int card = 500;
				int result = price + card;

				//출력
				System.out.println("요금 : " + price + "원");
				System.out.println("카드보증금 "+card+"원");
				System.out.println("결제금액 : " + result+"원");
		
	}

}
