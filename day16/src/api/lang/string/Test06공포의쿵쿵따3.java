package api.lang.string;

import java.util.Scanner;

public class Test06공포의쿵쿵따3 {
	public static void main(String[] args) {
		//(Q) 사용자가 입력한 단어가 "바나나"와 이어지는지 검사
		// = 사용자가 입력한 단어가 "나"로 시작하는지 검사		
//		String input = "나트륨";
//		System.out.println(input.startsWith("나")); //나로 시작하느냐 (권장하진 않음)
//		System.out.println(input.charAt(0)=='나'); //나로 시작하느냐
		
		Scanner sc = new Scanner(System.in);

		//(Q)제시어가 변수로 있어도 검사가 되나?
		String given = "바나나";
		System.out.print(given+"! 쿵쿵따!");
		String input = sc.next();
		//given의 마지막 글자로 input이 시작
		//given의 마지막글자, input의 첫글자
//		char last = given.charAt(2); //+2지점 글자
		char last = given.charAt(given.length()-1); //마지막글자
		char first = input.charAt(0);

		//판정 계산
		boolean isLengthOk = input.length() == 3;
		boolean isConnect = first == last;
		System.out.println("글자수 = "+ isLengthOk);
		System.out.println("연결 = " + isConnect);
	}
}
