package api.lang.string;

import java.util.Scanner;

public class Test05닉네임검사 {
	public static void main(String[] args) {
		/*api.lang.string.Test05닉네임검사
사용자에게 프로그램 내에서 사용할 닉네임을 입력받아 운영 규칙에 어긋나는지 검사 후 출력하세요

운영규칙
닉네임은 2글자 이상 10글자 이하로만 설정 가능합니다
닉네임에는 운영자라는 단어를 쓸 수 없습니다
(추가) 닉네임 온전한 한글이나 숫자로만 작성 가능합니다

운영규칙에 어긋나지 않는 닉네임이라면 올바른 닉네임입니다 출력
운영규칙에 어긋나는 닉네임이라면 잘못된 닉네임입니다 출력*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("닉네임 입력 : ");
		String nick = sc.next();
		
		
		String forbid = "운영자";
		if(nick.contains(forbid)) {
			System.out.println("잘못된 닉네임입니다");
		}
		else if(nick.length() >= 2 && nick.length() <= 10) {
			System.out.println("올바른 닉네임입니다");
		}
		else {
			System.out.println("잘못된 닉네임입니다");
		}
		

	}
}
