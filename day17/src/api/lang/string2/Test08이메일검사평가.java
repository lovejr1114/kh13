package api.lang.string2;

import java.util.Scanner;

public class Test08이메일검사평가 {
	public static void main(String[] args) {
		/*사용자에게 입력받은 이메일이 유효한지 검사
		요구사항
		반드시 @가 한 개 있어야 한다
		@ 앞부분과 뒷부분에 글자가 있어야 한다
		@ 앞부분은 아이디와 동일한 형식으로 검사
		네이버 아이디 검사 코드 참조
		(5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.)
		@ 뒷부분은 기관 주소가 들어온다
		기관 명칭이 우선 나오고 확장자가 등장한다
		(ex) 삼성이면 ooooo@samsung.com
		기관 명칭은 소문자 3글자 ~ 20글자 사이로 설정가능
		확장자는 다음 중 하나만 가능
		.co.kr
		.com
		.net
		.org
		.dev
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이메일을 입력해주세요. \n: ");
		String email = sc.nextLine();
		
		String regex = "^[a-z][a-z0-9_]{6,23}[a-z0-9]@[a-z0-9]{4,15}\\.(co\\.kr|net|com|org)$";

		
		System.out.println(email.matches(regex));
	}
}
