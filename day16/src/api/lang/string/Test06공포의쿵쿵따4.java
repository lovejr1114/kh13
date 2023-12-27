package api.lang.string;

import java.util.Scanner;

public class Test06공포의쿵쿵따4 {
	public static void main(String[] args) {
		//(Q)반복 추가
		Scanner sc = new Scanner(System.in);

		while(true) {
		String given = "바나나";
		System.out.print(given+"! 쿵쿵따!");
		String input = sc.next();
		//given의 마지막 글자로 input이 시작
		//given의 마지막글자, input의 첫글자
//		char last = given.charAt(2); //+2지점 글자
		char last = given.charAt(given.length()-1); //마지막글자
		char first = input.charAt(0);

		//판정 계산
		boolean isLengthOk = input.length() == 3;
		boolean isConnect = first == last;
		boolean isOk = isLengthOk && isConnect;
		if(isOk) {
			
		}
		else { //입력이 잘못되었다면
			break; //나가라
		}
		}
		
		//게임오버처리
		System.out.println("GAME OVER!");
	}
}
