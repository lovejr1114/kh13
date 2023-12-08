
package condition2;

import java.util.Scanner;

public class Test02지하철요금 {
	public static void main(String[] args) {
		//어르신 65세이상 무료
		//성인 20이상65미만 1400원
		//청소년 14이상 20미만 800원
		//어린이 8이상 14미만 500원
		//영유아 8미만 무료
		//-시간 되면 카드보증금 500원 추가계산
		
		//사용자 나이 입력받아 요금 계산
		
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 나이 입력 : ");
		int age = sc.nextInt();
		
		int	 adultP = 1400;
		int teenP = 800;
		int kidsP = 500;
		int deposit = 500;
		
		boolean old = age >= 65;
		boolean adult = 20 <= age && age <65;
		boolean teen = 14 <= age && age < 20;
		boolean kids = 8 <= age && age < 14;
	
		
		//
		if(old) {
			System.out.println("65세 이상으로 무료입니다.");			
		}
		else if(adult) {
			System.out.println("성인 요금은 " + adultP + "원입니다.");
			System.out.println("카드 보증금은 " + deposit + "원으로 총 금액은 " 
			+ (adultP+deposit) +"원입니다" );
		}
		else if(teen) {
			System.out.println("청소년 요금은 " + teenP + "원입니다");
			System.out.println("카드 보증금은 " + deposit + "원으로 총 금액은 " 
			+ (teenP+deposit) +"원입니다" );
			}
		else if(kids) {
			System.out.println("어린이 요금은 " + kidsP + "원입니다");			
			System.out.println("카드 보증금은 " + deposit + "원으로 총 금액은 " 
			+ (kidsP+deposit) +"원입니다" );
		}
		else {
			System.out.println("영유아이므로 무료입니다");
		}
		
	}

}
