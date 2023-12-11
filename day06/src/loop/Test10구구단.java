package loop;

import java.util.Scanner;

public class Test10구구단 {
	public static void main(String[] args) {
		//사용자에게 원하는 '단'을 입력 받아 구구단 문제 내고 정답을 입력 받는 프로그램 구현
		//구구단 : (3)   3x1 = (3) '정답!'  / 3x2 = 5 '땡!'
		//3x2 = (6) '정답!' .... 이렇게 3x9까지 입력 받고 '게임 끝!' 끝내는 과정.
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int num = sc.nextInt();
		
		
		for(int i=1; i <= 9; i=i+1) {
			System.out.print(num + "X" + i + "= ");
			int number = sc.nextInt();
			boolean answer = num * i == number;
			if(answer) {
				System.out.println("정답!");				
			}
			else {
				System.out.println("땡!");
			}
		}
		System.out.println("게임 끝!");
		sc.close();
	}

}
