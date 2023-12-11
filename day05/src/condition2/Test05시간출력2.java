package condition2;

import java.util.Scanner;

public class Test05시간출력2 {
	public static void main(String[] args) {
		//사용자가 초를 입력하면 입력된 값에 따라 시간 정보 출력
		//방금 전 = 작성한 지 10초가 미만
		//?초 전 = 작성한 지 10초 이상 1분 미만
		//?분 전 = 작성한 지 1분 이상 1시간 미만
		//?시간 전 = 작성한 지 1시간 이상 1일 미만
		//?일 전 = 작성한 지 1일 이상
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("초를 입력 하세요 : ");
		int second = sc.nextInt();
	
		
		String write;
		int time;
		if(second < 10) {		
			time = second;
			write = "방금 전";
		}
		else if(second < 60) {
			time = second;
			write = time + "초 전";
		}
		else if(second < 60 * 60) {
			time = second / 60;
			write = time + "분 전";
		}
		else if(second < 24 * 60 * 60) {
			time = second / 60 / 60;
			write = time + "시간 전";
		}
		else {
			time = second / 24 /60 / 60;
			write = time + "일 전";
		}
		
		
		//출력
		System.out.println(write + " 작성");
	}

}
