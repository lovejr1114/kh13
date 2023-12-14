package array2;

public class Test05배열뒤집기 {
	public static void main(String[] args) {
		//30, 50, 20, 10, 40을 배열에 저장하고
		//이 배열의 모든 데이터의 위치를 반대로 뒤집은 뒤 출력하세요
		//내 풀이 ㅋ
		
		int[] numbers = new int[] {30,50,20,10,40};
		
		int tmp1 = numbers[0];
		numbers[0] = numbers[4];
		numbers[4] = tmp1;
		
		int tmp2 = numbers[1];
		numbers[1] = numbers[3];
		numbers[3] = tmp2;

		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		System.out.println(numbers[4]);
		
	}
}
