package api.util.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test02조회수중복방지2 {
	public static void main(String[] args) {
//		유튜브에서는 크리에이터에게 조회수를 기반으로 한 수익을 제공합니다.
//		따라서 조회수가 의미 없이 마구잡이로 올라가는 것을 방지하려고 합니다.
//
//		사용자가 보고 싶은 영상 제목을 입력합니다
//		사용자가 입력한 영상 제목을 시청한 기록이 있을 경우 "조회수 증가 없이 영상만 재생합니다"를 출력합니다
//		사용자가 입력한 영상 제목을 시청한 기록이 없을 경우 "조회수 증가 후 영상을 재생합니다"를 출력합니다
//		사용자가 종료라는 글자를 입력하기 전까지 반복합니다
//		사용자가 종료라는 글자를 입력하면 여태까지 시청한 영상 개수를 출력하세요
		
//		제목 : (비전공자의 자바 도전기)
//		시청 기록이 없어 조회수 증가 후 영상을 재생합니다
//		제목 : (비전공자의 자바 도전기2)
//		시청 기록이 없어 조회수 증가 후 영상을 재생합니다
//		제목 : (비전공자의 자바 도전기)
//		이미 시청한 영상이므로 조회수 증가 없이 영상을 재생합니다
//		제목 : (종료)
//		총 2개의 영상을 시청하셨습니다
		Scanner sc = new Scanner(System.in);
		
		//정렬이 필요하지 않으므로 HashSet으로 구현
		Set<String> youtubeList = new HashSet<>();
		
		while(true) {
			System.out.print("영상 제목 : ");
			String user = sc.nextLine(); //sc.next()는 띄어쓰기가 안됨
		
			//종료 -> else if로 하기엔 if와 연관이 없으므로 먼저 if로 해준다.
			if(user.equals("종료")) {
				break;
			}
		
			//- Set은 중복이 불가능하므로 add의 결과로도 존재 여부 파악이 가능
			if(youtubeList.add(user)) { //추가했을 때 true나오면 본 적이 없는 영상
				System.out.println("시청 기록이 없어 조회수 증가 후 영상을 재생합니다.");
			}
			else {
				System.out.println("이미 시청한 영상이므로 조회수 증가 없이 영상을 재생합니다.");
			}
		}
		sc.close();
		System.out.println("총 "+youtubeList.size()+"개의 영상을 시청하셨습니다");
	}
}
