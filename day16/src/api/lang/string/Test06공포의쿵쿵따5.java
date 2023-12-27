package api.lang.string;

import java.util.Scanner;

public class Test06공포의쿵쿵따5 {
	public static void main(String[] args) {
		//(Q)제시어 변경
		Scanner sc = new Scanner(System.in);
		String given = "바나나"; //밖으로 빼고 누적 관리

		while(true) {
		System.out.print(given+"! 쿵쿵따!");
		String input = sc.next();
//		char last = given.charAt(2); //+2지점 글자
		char last = given.charAt(given.length()-1); //마지막글자
		char first = input.charAt(0);

		//판정 계산
		boolean isLengthOk = input.length() == 3;
		boolean isConnect = first == last;
		boolean isOk = isLengthOk && isConnect;
		if(isOk) {
			//제시어를 입력값으로 변경
			given=input;
		}
		else { //입력이 잘못되었다면
			break; //나가라
		}
		}
		
		//게임오버처리
		System.out.println("GAME OVER!");
	}
}
