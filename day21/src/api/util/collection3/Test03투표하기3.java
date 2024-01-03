package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03투표하기3 {
	public static void main(String[] args) {
//		사용자에게 이름을 입력받아 투표를 진행할 수 있도록 프로그램을 만드세요
//
//		사용자에게 반복적으로 이름을 입력받습니다
//		입력받은 이름이 처음 입력된 이름이라면 득표수를 1로 저장합니다
//		입력받은 이름이 이미 입력된 이름이라면 기존 득표수에 1을 더하여 저장합니다
//		투표가 완료되면 현재 투표된 이름의 득표수를 출력합니다
//		이름 입력 시 종료라는 글자가 입력되면 투표 프로그램을 종료하고 모든 값을 출력합니다
//		동명이인은 있을 수 없습니다.
//		이름 입력 : (피카츄)
//		[피카츄] 현재 1표 획득!
//		이름 입력 : (라이츄)
//		[라이츄] 현재 1표 획득!
//		이름 입력 : (피카츄)
//		[피카츄] 현재 2표 획득!
//		이름 입력 : (피카츄)
//		[피카츄] 현재 3표 획득!
//		이름 입력 : (라이츄)
//		[라이츄] 현재 2표 획득!
//		이름 입력 : (종료)
//		프로그램을 종료합니다.
//		{피카츄=3, 라이츄=2}
		
		//저장소 생성
		Map<String, Integer> votes = new HashMap<>();

		//더미 데이터 추가
		//votes.put("피카츄", 25);
		//votes.put("라이츄", 17);

		Scanner sc = new Scanner(System.in);

		while(true) {
			//사용자 입력
			System.out.print("투표할 대상 이름 : ");
			String input = sc.nextLine();
			if(input.equals("종료")) {
				break;
			}

			//판정
			Integer count = votes.get(input);//득표수 추출(없으면 null)
			if(count == null) {
				count = 1;
			}
			else {
				count = count + 1;
			}
			votes.put(input, count);
			System.out.println("["+input+"] 투표 완료! 득표수 "+count);

			}

		sc.close();

		//출력
		System.out.println(votes);
	}
}
