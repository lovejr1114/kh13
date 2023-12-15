package array3;

public class Test01선택정렬2 {
	public static void main(String[] args) {
		
		int[] numbers = new int[] {30,50,20,10,40};
				
		//선택 정렬(selection sort) - 최소값을 앞에서부터 채우는 방식
		
		//첫 번 째 회차에서 발생하는 일
		//-[0]부터 [4]사이에서 최소값의 위치를 찾아 [0]과 바꾼다
		
		//최솟값 구하기
		int min = 0;  //[0]이 가장 작은 값의 위치라고 치자.
		for(int i=1; i<numbers.length; i++) {   //최소값 구할 때 i는 1부터 시작.(0을 제일 작다고 했으니까.)
			if(numbers[min] > numbers[i]) {
				min = i;
			}
		}		
		int backup = numbers[0];
		numbers[0] = numbers[min];
		numbers[min] = backup;
			
		//출력
		for(int i=0; i<numbers.length; i++) {
				System.out.println(numbers[i]);
		}
	}
}
