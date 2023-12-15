package array2;

import java.util.Random;

public class Test06배열섞기3 {
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
			//현재 위치와 같은 위치가 나오지 않도록 추가적인 재추첨을 하는 코드
			int index;
			while(true) {
				index = r.nextInt(numbers.length); //0부터 5개 //0부터 4까지
				if(i != index) break;
			}
			System.out.println("현재 위치 : " + i + "바꿀 위치 : " + index);
			
			//교체(swap) - [i]과 [index]를 교체한다.
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
