package condition2;

import java.util.Scanner;

public class Test04체질량계산기 {
	public static void main(String[] args) {
		//18.5 미만 저체중
		// 18.5이상 23미만 정상
		//23이상 25미만 과체중
		//25이상 30미만 경도비만
		//30이상 중증도 비만
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("키를 입력 해 주세요.");
		double cm = sc.nextDouble();
		System.out.println("몸무게를 입력 해 주세요");
		double kg = sc.nextDouble();
		
		//
		double m = cm / 100;
		double bmi = kg / (m * m); // 18.26

		
		
		if(bmi < 18.5) {
			System.out.println("저체중입니다.");
		}
		else if(18.5 <= bmi && bmi < 23) {
			System.out.println("정상입니다.");
		}
		else if(23 <= bmi && bmi < 25) {
			System.out.println("과체중입니다.");
		}
		else if(25 <= bmi && bmi < 30) {
			System.out.println("경도 비만입니다.");
		}
		else {
			System.out.println("중증도 비만입니다.");
		}
		
		
		//출력
		System.out.println("사용자의 BMI 지수는 " + bmi + "입니다.");	
	}

}
