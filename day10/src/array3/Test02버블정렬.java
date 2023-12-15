package array3;

public class Test02버블정렬 {
	public static void main(String[] args) {
		
		int[] numbers = new int[] {30,50,20,10,40};
		
		//버블정렬 (bubble sort) - 인접한 두 개의 값을 비교하여 교체하는 방식
		
		for(int k=0; k <numbers.length-1; k++) {
			for(int i=0; i<numbers.length-1-k; i++) {
				//k를 빼주는이유는,, 불필요한 계산을 안하려고 하기 때문이다..(최적화)
				
				if(numbers[i] > numbers[i+1]) {
					int backup = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = backup;
				}
			}		
		}
		
//          1회차		
//			if(numbers[0] > numbers[1]) {
//				int backup = numbers[0];
//				numbers[0] = numbers[1];
//				numbers[1] = backup;
//			}
//
//			if(numbers[1] > numbers[2]) {
//				int backup = numbers[1];
//				numbers[1] = numbers[2];
//				numbers[2] = backup;
//			}
//
//			if(numbers[2] > numbers[3]) {
//				int backup = numbers[2];
//				numbers[2] = numbers[3];
//				numbers[3] = backup;
//			}
//
//			if(numbers[3] > numbers[4]) {
//				int backup = numbers[3];
//				numbers[3] = numbers[4];
//				numbers[4] = backup;
//			}
		
//			2회차
//			if(numbers[0] > numbers[1]) {
//				int backup = numbers[0];
//				numbers[0] = numbers[1];
//				numbers[1] = backup;
//			}
//
//			if(numbers[1] > numbers[2]) {
//				int backup = numbers[1];
//				numbers[1] = numbers[2];
//				numbers[2] = backup;
//			}
//			3회차
//			if(numbers[0] > numbers[1]) {
//				int backup = numbers[0];
//				numbers[0] = numbers[1];
//				numbers[1] = backup;
//			}

				
		//출력
		for(int i=0; i<numbers.length; i++) {
		System.out.println(numbers[i]);
		}
	}
}
