package loop2;

import java.util.Scanner;

public class Test03등급판정 {
	public static void main(String[] args) {
		//사용자에게 10개의 시험점수를 입력 받아서 A등급과 B등급의 개수를 출력
		//- A등급 85점 이상 100점 이하
		//- B등급 70점 이상 85점 미만
		//시험점수 0~100
		
		Scanner sc = new Scanner(System.in);
		
		int totalA = 0;
		int totalB = 0;
		//int totalE = 0;
		for(int i=1; i<=10; i++) {
			System.out.print("시험 점수를 입력하세요 : ");
			int score = sc.nextInt();
			if(85 <= score && score <= 100) {
				System.out.println("A");
				totalA++;
			}
			else if(70 <= score && score < 85) {
				System.out.println("B");
				totalB++;
			}
			//else {
			//	System.out.println("등급책정 불가");
			//	totalE++;
			//}		
		}		
		System.out.println("A 등급의 개수는 " + totalA + "개");
		System.out.println("B 등급의 개수는 " + totalB + "개");
		//System.out.println("등급책정 불가 개수는 " + totalE + "개");
	}

}
