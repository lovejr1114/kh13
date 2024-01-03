package api.util.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test03팔로우 {
	public static void main(String[] args) {
//		다음 요구사항대로 사용자에게 팔로우를 설정 또는 해제할 수 있는 프로그램을 구현
//
//		사용자의 아이디를 입력합니다.
//		사용자의 아이디가 저장소에 없는 경우 "팔로우 설정 완료" 출력
//		사용자의 아이디가 저장소에 있는 경우 "팔로우 삭제 완료" 출력
//		팔로우 설정 또는 삭제에 맞는 저장소 처리를 추가적으로 구현
//		사용자가 종료라는 글자를 입력하면 등록된 팔로우 대상 수를 출력
		Scanner sc = new Scanner(System.in);
		
		// TreeSet은 팔로우 목록 출력이 필요한 경우
		// HashSet은 팔로우 여부 확인만 할 경우
		Set<String> follow = new HashSet<>();
		Set<String> unfollow = new HashSet<>();

		while(true) {
			System.out.print("사용자 아이디 : ");
			String id = sc.nextLine();
			
			if(id.equals("종료")) {
				break;
			}
				
			if(follow.add(id)) {
				System.out.println(id+"님을 팔로우 하였습니다.");
			}
			else {
				follow.remove(id);
				unfollow.add(id);
				System.out.println(id+"님을 언팔로우 하였습니다.");				
			}
		}
		
		sc.close();
		System.out.println("팔로우 : " + follow.size()+"명");
		System.out.println("언팔로우 : " + unfollow.size()+"명");
	}
}
