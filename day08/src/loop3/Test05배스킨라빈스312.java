package loop3;

import java.util.Scanner;

public class Test05배스킨라빈스312 {
	public static void main(String[] args) {
//		베스킨라빈스31 게임은 사용자들이 번갈아서 
//		숫자를 1~3개 골라 31을 말하게 되는 사람이 지는 게임입니다.
//		사용자에게 반복적으로 1~3 사이의 숫자를 입력받아 
//		다음과 같이 게임이 진행될 수 있도록 구현해보세요

//		현재 숫자 : 1
//		숫자 개수(1~3) 입력 : 2

//		현재 숫자 : 3
//		숫자 개수(1~3) 입력 : 3

//		현재 숫자 : 6
//		숫자 개수(1~3) 입력 : 1

//		현재 숫자 : 7
//		숫자 개수(1~3) 입력 : ?

//		현재 숫자 : 31
//		숫자 개수(1~3) 입력 : 1

//		당신은 패배했습니다.
		
		Scanner sc = new Scanner(System.in);
		
		int now = 1;
		
		while(true) {
			System.out.println("현재 차례 : " + now);
			System.out.print("개수(1~3) 입력 : ");
			int num = sc.nextInt();
			
			//만약에 사용자가 1~3이 아닌 수를 입력했다면 건너뛰고 다시 시작
			//if(num < 1 || num > 3) {} 또는
			if(!(num >=1 && num <=3)) {//선생님은 39줄 보다 40줄 추천
				continue; //반복문 안에서만 쓸 수 있음. 위 조건과 불일치하면 다시 되돌아감.
			}
			
		//사용자가 선택한 숫자 개수에 따른 멘트 출력
			for(int i=0; i< num; i++) {
				System.out.print(now + i);
				System.out.print("\t");
			}
			System.out.println("선택");
			
			now += num;
			
			//숫자를 증가 시켰을 때 31보다 크다면 31을 말한 것과 같다.
			if(now > 31) {
				System.out.println("당신은 패배했습니다.");
				break;
			}		
		}

	}

}
