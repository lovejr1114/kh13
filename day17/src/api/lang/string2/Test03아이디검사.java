package api.lang.string2;

import java.util.Scanner;

public class Test03아이디검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		String regex = "^[a-z0-9][a-z0-9-_]{4,19}$";
//		String regex = "^[a-z0-9]{1}[a-z0-9-_]{4,19}$";
		//{1} 써도되지만 권장하지는 않는다. 하지만 헷갈리면 적어도됨. 근데 {0}은 안됨
		 
		if(id.matches(regex)) {
			System.out.println("멋진 아이디입니다!");
		}
		else {
			System.out.println("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
		}
	}
}
