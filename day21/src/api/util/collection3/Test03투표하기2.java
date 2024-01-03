package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03투표하기2 {
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
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new HashMap<>();
//		
//		votes.put("피카츄",1);
//		votes.put("라이츄", 3);
		
		while(true) {
			System.out.print("이름 입력 : ");
			String user = sc.nextLine();
			
			if(user.equals("종료")) {
				break;
			}
		
			Integer count = votes.get(user); //득표수 추출 (없으면 null)
			if(count != null) {//투표 이력이 있으면
				votes.put(user, count+1); //+1 한 다음 재설정
				System.out.println("["+user+"] 투표 완료! 득표수 "+(count+1));
			}
			else {//투표 이력이 없다면
//				System.out.println("기록 무");
				votes.put(user, 1); //득표수 1로 저장
				System.out.println("["+user+"] 투표 완료! 득표수 "+1);
			}
		}
		
		sc.close();
		//출력
		System.out.println(votes);
	}
}
