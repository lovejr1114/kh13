package api.lang.string;

import java.util.Random;
import java.util.Scanner;

public class Test06공포의쿵쿵따6 {
	public static void main(String[] args) {
		//(Q)랜덤 단어 추첨, 라운드 추가
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		String[] words = new String[] {
				"바나나","불고기","고구마","서커스","강아지","고양이"
		};
		
		int position = r.nextInt(words.length);
		String given =words[position];
		int round = 1; //1라운드부터 시작하게 하겠다.
		while(true) {
		System.out.print(given+"! 쿵쿵따!");
		String input = sc.next();
		char last = given.charAt(given.length()-1);
		char first = input.charAt(0);

		//판정 계산
		boolean isLengthOk = input.length() == 3;
		boolean isConnect = first == last;
		boolean isOk = isLengthOk && isConnect;
		if(isOk) {
			given=input; //제시어를 입력값으로 변경
			round++; //맞히면 라운드 증가
		}
		else { //입력이 잘못되었다면
			break; //나가라
		}
		}
		
		//게임오버처리
		System.out.println("GAME OVER!");
		System.out.println("총 "+round+"라운드까지 진행");
	}
}
