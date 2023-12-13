package random;

import java.util.Random;
import java.util.Scanner;

public class Test03랜덤구구단2 {
	public static void main(String[] args) {
//		10개의 랜덤 구구단 문제를 출제하는 프로그램을 구현하세요
//		2단 부터 19단 까지의 범위 내에서 출제
//		사용자에게 입력을 받아 정답, 오답 판정
//		사용자가 맞힌 문제 수를 카운트하여 출력
//		맞힌 문제 하나당 점수를 부여
//		쉬운 문제는 10점 (2~11단, x1)
//		어려운 문제는 15점 (나머지)
//		사용자가 획득한 점수를 누적합산하여 출력
		
		//정답을 연속으로 맞히면 콤보
		//콤보도 카운트
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		

		int size = 10;
		int correctEasy = 0, correctDifficult = 0; //개수
		int score = 0; //점수
		int combo = 0;
		
		//for(int i=1; i<=10; i++) 이것도 좋지만
		for(int i=0; i<size; i++) { //이렇게 쓰이는게 나중에 더 잘먹힘 (0부터하고 부등호하나)
			int left = r.nextInt(18) +2; // 2부터 19사이 / 2부터 18개
			int right = r.nextInt(9) +1;
			
			System.out.print(left + "X" + right + "= ");
			int user = sc.nextInt();

			if(user == left*right) { //정답이라면
				//어려운 문제라면 - 12단 이상이면서 x2 이상
				if(left >= 12 && right >= 2) { 
//					System.out.println("어려운 문제 클리어");
					correctDifficult++;
					score += 15;
					combo++;
					if(combo >= 2) { //콤보를 2이상일 때 보여준다.
						System.out.println(combo+ "Combo!");
					}
					else { //오답이라면
						combo = 0;
					}
				}
				else { //쉬운 문제라면 - 11단 이하이거나 x1인경우
//					System.out.println("쉬운 문제 클리어");
					correctEasy++;
					score += 10;
				}

			}
		}
		System.out.println("게임 끝!");
		System.out.println("쉬운 문제 정답 개수는 " + correctEasy  +"개입니다.");
		System.out.println("어려운 문제 정답 개수는 " + correctDifficult  +"개입니다.");		
		System.out.println("총 획득 점수 : " + score + "점입니다.");
	}

}