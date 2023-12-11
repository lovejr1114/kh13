package loop;

import java.util.Scanner;

public class Test04숫자입력 {
	public static void main(String[] args) {
		//사용자에게 7개 숫자 입력 받아서 출력
		//예시) 1번째 숫자 : 23    -> 입력하신 숫자는 "23"입니다.
		//2번째 숫자 : 15   -> 입력하신 숫자는 "15" 입니다. (반복)
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; //인트로 하나 꺼내준다. 그리고 '0'인 이유는 입력한 숫자만 더해야하기 때문에
		//for(int i=1 ; i <= 7 ; i=i+1) {
		for(int i=1 ; i <= 7 ; i+=1) { //더하기 1만 한다면 for(int i=1 ; i <= 7 ; i++) 라고 적어도 됨
			System.out.print(i+ "번 째 숫자 입력 : ");
			int number = sc.nextInt();
			System.out.println("입력하신 숫자는 \"" + number + "\"입니다.");
			sum = sum+number; //반복문 안에 더하는 식을 넣어줘야 한다.
					}
		System.out.println(sum); //계산 출력은 for문 밖으로 빼줘야 한다.
	}

}

