package array;

import java.util.Scanner;

public class Test05배열입력 {
	public static void main(String[] args) {
		//배열을 만들고 사용자에게 숫자를 5개 입력받아 저장한 뒤 출력
		
		int[] numbers = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<numbers.length; i++) {
			System.out.print("숫자를 입력해주세요 : ");
			numbers[i] = sc.nextInt();
		}
		
		sc.close();
		System.out.print("입력하신 숫자 : ");
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i]);
			System.out.print("  ");
		}
		
	}

}
