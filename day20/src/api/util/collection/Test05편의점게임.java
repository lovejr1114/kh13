package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05편의점게임 {
	public static void main(String[] args) {
//		편의점게임은 다음과 같이 진행합니다.
//		사용자에게 편의점에 가면~ 출력
//		사용자가 편의점에 있을법한 물건을 입력
//		한 번이라도 입력한 적이 있는 물건이면 게임오버
//		입력한 적이 없는 물건이면 등록 후 1번부터 진행
//		게임 오버가 되면 여태까지 입력된 물건들을 모두 출력
//
//		편의점에가면~ (핫도그)
//		편의점에가면~ (김밥)
//		편의점에가면~ (라면)
//		편의점에가면~ (핫도그)
//		게임 오버!
//		<입력한 물건들>
//		- 핫도그
//		- 김밥
//		- 라면
		
		Scanner sc = new Scanner(System.in);
		
		List<String> store = new ArrayList<>();
	
		while(true) {			
			System.out.print("편의점에 가면~ ");
			String user = sc.nextLine();
			
			if(store.contains(user)) { //이미 있는 값이면
				System.out.println("게임 오버");
				break;
			}
			else { //입력한 적 없는 값이면
				store.add(user);
			}
		}
			System.out.println( store);
	}
}
