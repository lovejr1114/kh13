package array2;

public class Test05배열뒤집기3 {
	public static void main(String[] args) {
		//30, 50, 20, 10, 40을 배열에 저장하고
		//이 배열의 모든 데이터의 위치를 반대로 뒤집은 뒤 출력하세요
		//쌤 풀이
		
		//배열 준비
		int[] numbers = new int[] {30,50,20,10,40};
		
		//교체
		//1. numbers[0]과  [4] 바꾼다.
		//2. [1]과 [3] 바꾼다.
		
		int backup = numbers[0];
		numbers[0] = numbers[4];
		numbers[4] = backup;
		
		backup = numbers[1];
		numbers[1] = numbers[3];
		numbers[3] = backup;
		//이런 코드는 확장성이 떨어지고 4칸만 되어도 에러가 난다.
		
		
		//출력
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i]);
			System.out.print("\t");
		}
		
	}
}
