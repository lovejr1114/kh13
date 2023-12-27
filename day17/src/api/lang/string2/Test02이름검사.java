package api.lang.string2;

import java.util.Scanner;

public class Test02이름검사 {
	public static void main(String[] args) {
		/*사용자에게 한국이름을 입력받아 올바른 이름인지 검사 후 출력
		요구사항
		완성된 한글 글자만 사용 가능
		성은 1글자 또는 2글자
		이름은 1글자에서 5글자 사이*/
		
		Scanner sc = new Scanner(System.in);
		String name = "제갈정은"; //sc.next();
		
		//regex 는 regular expression(정규 표현식)의 줄임 표현이다
		String regex = "^[가-힣]{1,2}[가-힣]{1,5}$";
//		String regex = "^[가-힣]{2,7}$"; //이건 머리 더 써서 권장하지않는다
		
		//참고 :  낱자까지 모두 검사하고싶다면 ^[ㄱ-ㅎㅏ-ㅣ가-힣]{2,7}$
		
		if(name.matches(regex)) {//형식과 일치한다면			
			System.out.println("멋진 이름입니다!");
		}
		else {//형식과 일치하지 않는다면
			System.out.println("올바른 한국 이름이 아닙니다!");
		}
	}
}
