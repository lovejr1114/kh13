package array2;

import java.util.Random;

public class Test06배열섞기2 {
	public static void main(String[] args) {
		/*
		 * 배열에 30 50 20 10 40 저장하고 다음 규칙에 따라 데이터 섞어보기.
		 * - 실행 할 때마다 다른 위치로 바뀌도록 섞고싶음
		 * - 배열의 모든 자리가 1번은 반드시 바뀌어야함
		 * - 바뀌는 자리가 같은 자리여도 상관 없음
		 * - 모든 자리가 교체 된 후 배열을 출력
		 */
		Random r = new Random();
		
		//데이터 준비
		int[] numbers = new int[] {30, 50, 20, 10, 40};


		for(int i=0; i<numbers.length; i++) {
			//맨 앞자리 (+0 지점) 를 랜덤한 위치와 변경
			int index = r.nextInt(numbers.length); //0부터 5개 //0부터 4까지
			System.out.println("index =  " + index);
			
			//교체(swap) - [0]과 [index]를 교체한다.
			int backup = numbers[i];
			numbers[i] = numbers[index];
			numbers[index] = backup;
			}
		
		//출력
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
	}
}
