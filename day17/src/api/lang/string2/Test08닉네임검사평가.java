package api.lang.string2;

import java.util.Scanner;

public class Test08닉네임검사평가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣0-9]{1,10}$";

		
		if(id.matches(regex)) {
			System.out.println("멋진 아이디입니다!");
		}
		else {
			System.out.println("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
		}
	}
}
