package condition2;

import java.util.Scanner;

public class Test04체질량계산기2 {
	public static void main(String[] args) {
		//18.5 미만 저체중
		// 18.5이상 23미만 정상
		//23이상 25미만 과체중
		//25이상 30미만 경도비만
		//30이상 중증도 비만
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("키를 입력 해 주세요.");
		float cm = sc.nextFloat();
		System.out.println("몸무게를 입력 해 주세요");
		float kg = sc.nextFloat();
		
		//
		float m = cm / 100; //cm이 float이기 때문에 100 뒤에 f 붙이지 않아도 된다.
		float bmi = kg / (m * m); // 18.26

		
		//String status = "저체중" or "정상" or "과체중" or "경도비만" or "중증도비만"
		String status;		
		if(bmi < 18.5f) {
			status = "저체중";
		}
		else if(bmi < 23f) {
			status = "정상";
		}
		else if(bmi < 25f) {
			status = "과체중";
		}
		else if(bmi < 30f) {
			status = "경도 비만.";
		}
		else {
			status = "중증도 비만";
		}
		
		
		//출력
		System.out.println("사용자의 BMI 지수는 " + bmi + "입니다.");	
		System.out.println("사용자의 상태는 " + status + "입니다.");
	}

}
