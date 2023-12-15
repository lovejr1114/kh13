package array3;

public class Test01선택정렬 {
	public static void main(String[] args) {
		
		int[] numbers = new int[] {30,50,20,10,40};
		
		//최솟값 구하기
		int min = 0;  //처음 위치
		for(int i=1; i<numbers.length; i++) {   //최소값 구할 때 i는 1부터 시작.(0은 포함하지 않는다.)
			if(numbers[min] > numbers[i]) {
				min = i;
			}
		}
		
		//최소값 제일 앞에다 배치해주기 (위치 변경) [0]<->[3]
		int backup = numbers[0];
		numbers[0] = numbers[min];
		numbers[min] = backup;
			
		//출력
		for(int i=0; i<numbers.length; i++) {
				System.out.println(numbers[i]);
		}
	}
}
