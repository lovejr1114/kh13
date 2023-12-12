package loop2;

import java.util.Scanner;

public class Test03등급판정2 {
	public static void main(String[] args) {
		//사용자에게 10개의 시험점수를 입력 받아서 A등급과 B등급의 개수를 출력
		//- A등급 85점 이상 100점 이하
		//- B등급 70점 이상 85점 미만
		//시험점수 0~100
		
		Scanner sc = new Scanner(System.in);
		
		int countA = 0;
		int countB = 0;

		for(int i=0; i<10; i++) {
			System.out.print("시험 점수를 입력하세요 : ");
			int score = sc.nextInt();
			
			if(85 <= score) {
//				System.out.println("A");
				countA++;
			}
			else if(70 <= score) {
//				System.out.println("B");
				countB++;
			}
		}		
		System.out.println("A 등급의 개수는 " + countA + "개");
		System.out.println("B 등급의 개수는 " + countB + "개");
	}

}
