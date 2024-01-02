package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기 {
	public static void main(String[] args) {
//		자바를 최초 제시어로 하는 끝말잇기 게임을 구현
//
//		게임오버 조건은 다음과 같습니다.
//		이전 단어와 이어지지 않는 단어를 입력한 경우
//		한글 2~6글자가 아닌 단어 입력(띄어쓰기 허용하지 않음)
//		한 번이라도 입력한 적이 있는 단어를 또 입력한 경우
		
		Scanner sc = new Scanner(System.in);
		List<String> concluding = new ArrayList<>();
		
		concluding.add("자바");

		while(true) {
			String given = concluding.get(concluding.size()-1); //저장소에 있는 마지막 단어
			System.out.println("[제시어] " + given);
			System.out.print("입력 : ");
			String user = sc.nextLine();

			//판정 = 한글 2~6글자 + 처음 입력한 단어 + 이어지는 단어
			boolean isKoreanWord = user.matches("^[가-힣]{2,6}$");
			boolean isContain = concluding.contains(user);
			boolean isConnect = given.charAt(given.length()-1) == user.charAt(0);
			boolean isPass = isKoreanWord && !isContain && isConnect;
			
			if(isPass) {
				concluding.add(user);
			}
			else {
				System.out.println("게임 오버");
				break;
			}
		}
		
		sc.close();
		
		System.out.println("<입력한 모든 단어들>");
		for(int i=0; i<concluding.size(); i++) {
			String word = concluding.get(i);
			System.out.println("- " +word);
		}
	}
}
