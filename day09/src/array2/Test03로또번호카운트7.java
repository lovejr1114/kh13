package array2;

import java.util.Random;

public class Test03로또번호카운트7 {
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
		
		//최대값의 위치(index)를 찾자
		int max = 0; //맨 앞이 가장 크다고 치자.
		for(int i=1; i<counts.length; i++) { //그다음부터 마지막까지 조회하며
			if(counts[max] < counts[i]) { //내가 아는 최대값보다 더 큰게 나타난다면
				max = i;
			}
			
		}
		//1번에 대한 풀이
		for(int i=0; i<counts.length; i++) {			
			System.out.println((i+1) + "나온 횟수 : "+counts[i]);
		}
	
		//2번에 대한 풀이   ++동점까지 출력하고싶다면
		for(int i=0; i<counts.length; i++) {
			if(counts[max] == counts[i]) { //가장 많이 나온 횟수랑 같은 칸이 있다면
				System.out.println("가장 많이 나온 수 " + (i + 1) + " (" + counts[i] + "번)");
			}
		}
	}
}
