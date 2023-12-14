package array2;

import java.util.Random;

public class Test03로또번호카운트5 {
	public static void main(String[] args) {
		//KH로또 연구소. 가장 많이 나오는 로또 번호가 몇 번인지 궁금.
		//알고싶어서 시뮬레이션 진행. 로또번호 1000번정도 추첨.
		//각각 나온 횟수 저장.
		// 1. 번호별로 나온 횟수 출력
		// 2. 가장 많이 나온 번호 출력 (동점이면 아무거나)

				
		Random r = new Random();
		
		int[] counts = new int[45];

				
		for(int i=0; i<1000; i++) {
			int number = r.nextInt(45) +1;		
//			System.out.println(number);
			
			//1이 나오면 [0] 증가, 2가 나오면 [1] 증가 ...
			//number가 나오면 [number-1] 증가
			
			counts[number-1]++;     // 이게 1번 문제
			}
	
		//1번에 대한 풀이
		for(int i=0; i<counts.length; i++) {			
			System.out.println((i+1) + "나온 횟수 : "+counts[i]);
		}

	}
}
