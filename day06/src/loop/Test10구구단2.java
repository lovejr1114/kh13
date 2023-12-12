package loop;

import java.util.Scanner;

public class Test10구구단2 {
	public static void main(String[] args) {
		//사용자에게 원하는 '단'을 입력 받아 구구단 문제 내고 정답을 입력 받는 프로그램 구현
		//구구단 : (3)   3x1 = (3) '정답!'  / 3x2 = 5 '땡!'
		//3x2 = (6) '정답!' .... 이렇게 3x9까지 입력 받고 '게임 끝!' 끝내는 과정.
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 구구단 : ");
		int dan = sc.nextInt();
		
		
		System.out.println(dan + "단 시작!");
		for(int i=1; i <= 9; i=i+1) {
			System.out.print(dan + "X" + i + "= "); //문제 출력
			int user = sc.nextInt(); //사용자 입력
			int answer = dan * i; //실제 정답 계산
			if(user == answer) { //정답이라면
				System.out.println("정답!");				
			}
			else { //오답이라면
				System.out.println("땡!");
			}
		}
		System.out.println("게임 끝!");
		sc.close();
	}

}
