package api.lang.string;

import java.util.Scanner;

public class Test06공포의쿵쿵따 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("쿵쿵따 게임을 시작합니다. 3글자의 단어를 입력해주세요");
		System.out.println("제시어 = 바나나");
		String first = "바나나";
		
		int count = 0;
		while (true) {
			System.out.print("단어 입력 : ");
			String user = sc.next();
			
			char ch = user.charAt(0);
			char lastChar = first.charAt(2);
			char firstChar = user.charAt(0);
			if(user.length() != 3 || !user.matches("[가-힣]+")) {
				System.out.println("게임 오버! 라운드 진행 횟수는 " + count +"회");
				break;
			}
			if(lastChar == firstChar) {
				first = user;
				System.out.println(first + " 쿵쿵따!");
				count++;
			}
			else {
				System.out.println("게임 오버! 라운드 진행 횟수는 " + count +"회");
				break;
			}
			System.out.println("다음 단어는 '"+user.charAt(2)+"'(으)로 시작하는 단어입니다.");
		}
	}
}
