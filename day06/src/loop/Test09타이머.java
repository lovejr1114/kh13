package loop;

import java.util.Scanner;

public class Test09타이머 {
	public static void main(String[] args) {
		//사용자에게 '분'과 '초'를 입력 받아서 해당하는 시간만큼 메세지를 출력하는 프로그램 구현
		//분 입력 : 1 , 초 입력 : 30
		//1분 30초 후 알람이 울립니다.
		//1분 29초 후 알람이 울립니다.
		//1분 28초 후 알람이 울립니다. ...
		//0분 2초 후 알람이 울립니다.
		//0분 1초 후 알람이 울립니다.
		//0분 0초 후 알람이 울립니다.
		//띠링!
		
		Scanner sc = new Scanner(System.in);
		System.out.print("분 입력 : ");
		int min = sc.nextInt();
		System.out.print("초 입력 : ");
		int sec = sc.nextInt();
		
		int time = min * 60 + sec;
				
		
		for(int i=time; i>=0; i--) {
			int iMin = i /60;
			int iSec = i % 60;
			System.out.println(iMin +"분 " + iSec + "초 후 알람이 울립니다.");
		}
		System.out.println("띠링!");
	}

}
