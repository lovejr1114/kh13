package loop3;

import java.util.Scanner;

public class Test06모래성게임2 {
	public static void main(String[] args) {
//		최초에 100이라는 숫자를 정해두고 사용자에게 1~9 사이의
		//숫자를 입력받아 0을 만드는 사람이 패배하도록 모래성 게임을 구현하세요
//		남은 숫자 : 100
//		가져갈 숫자(1~9) 입력 : 5
//		남은 숫자 : 95
//		가져갈 숫자(1~9) 입력 : 9
//		남은 숫자 : 86
//		가져갈 숫자(1~9) 입력 : ?
//		...
//		남은 숫자 : 1
//		가져갈 숫자(1~9) 입력 : 1
//		당신은 패배했습니다
		
		Scanner sc = new Scanner(System.in);
		
		int now = 100;
		
		while(true) {
			System.out.println("현재 남은 숫자" + now);
			System.out.print("가져갈 숫자(1~9) 입력 : ");
			int get = sc.nextInt();
			
			if(!(get >= 1 && get <= 9)) {
				continue;
		}
		
		for(int i=0; i<get; i++) {
			System.out.print(now - i);
			System.out.print("\t");			
		}
		System.out.println();
		
		now -= get;
		
		//종료조건 - 더이상 남은 숫자가 없다면
		if(now <= 0) {
			break;
		}
		}	
		System.out.println("모래성이 무너졌습니다.");
	}

}
