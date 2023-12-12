package random;

import java.util.Random;
import java.util.Scanner;

public class Test03랜덤구구단 {
	public static void main(String[] args) {
//		10개의 랜덤 구구단 문제를 출제하는 프로그램을 구현하세요
//		2단 부터 19단 까지의 범위 내에서 출제
//		사용자에게 입력을 받아 정답, 오답 판정
//		사용자가 맞힌 문제 수를 카운트하여 출력
//		맞힌 문제 하나당 점수를 부여
//		쉬운 문제는 10점 (2~11단, x1)
//		어려운 문제는 15점 (나머지)
//		사용자가 획득한 점수를 누적합산하여 출력
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		

		
		int score = 0;
		int count = 0;
		for(int i=1; i<=10; i++) {
			int dan = r.nextInt(18) +2;
			int num = r.nextInt(9) +1;
			
			System.out.print(dan + "X" + num + "= ");
			int answer = num * dan;
			int user = sc.nextInt();

			if(answer == user && (dan <= 11||num==1)) {
				System.out.println("정답!");
				count++;
				score += 10;
			}
			else if(answer == user && dan <= 19) {
				System.out.println("정답!");
				count++;
				score += 15;
			}
			else {
				System.out.println("땡!");
			}

		}
		System.out.println("정답 개수는 " + count +"개이며, " + score + "점입니다.");
	}

}
