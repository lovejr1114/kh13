package array2;

import java.util.Random;

public class Test03로또번호카운트2 {
	public static void main(String[] args) {
		//KH로또 연구소. 가장 많이 나오는 로또 번호가 몇 번인지 궁금.
		//알고싶어서 시뮬레이션 진행. 로또번호 1000번정도 추첨.
		//각각 나온 횟수 저장.
		// 1. 번호별로 나온 횟수 출력
		// 2. 가장 많이 나온 번호 출력 (동점이면 아무거나)
		
		//우선은 로또가 아니라 주사위를 10번 던진다고 가정.
		//중요한건 주사위 내역은 저장의 대상이 아니다.
				
		Random r = new Random();
		
		int[] counts = new int[6];

				
		for(int i=0; i<10; i++) {
			int number = r.nextInt(6) +1;		
			System.out.println(number);
			
			if(number == 1) {
				counts[0]++;
			}
			else if(number == 2) {
				counts[1]++;
			}
			else if(number == 3) {
				counts[2]++;
		}
			else if(number == 4) {
				counts[3]++;
			}
			else if(number == 5) {
				counts[4]++;
			}
			else {
				counts[5]++;
			}
	}
		System.out.println("1 나온 횟수 : "+counts[0]);
		System.out.println("2 나온 횟수 : "+counts[1]);
		System.out.println("3 나온 횟수 : "+counts[2]);
		System.out.println("4 나온 횟수 : "+counts[3]);
		System.out.println("5 나온 횟수 : "+counts[4]);
		System.out.println("6 나온 횟수 : "+counts[5]);
	}
}
