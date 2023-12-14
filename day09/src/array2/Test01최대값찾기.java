package array2;

public class Test01최대값찾기 {
	public static void main(String[] args) {
		
		//(Q) 가장 큰 데이터는 어디있어요?
		//(A) 1번 위치
		
		int[] numbers = new int[] {30,50,20,10,40};
		
		int max = 0; //0을 가장 큰 위치라고 가정
//		for(int i=1; i<=4; i++) { //1부터 4까지 반복하며.
		for(int i=1; i<numbers.length; i++) { //1부터 마지막까지 반복하며.
			//number[max] -  현재 내가 알고있는 가장 큰 값
			//number[i] - 현재 비교할 대상의 값
			if(numbers[max] < numbers[i]) {
				max = i; //위치를 갱신
			}
			
			System.out.println("MAX = " + max);
			System.out.println("value = " + numbers[max]);
		}
		
	}

}
