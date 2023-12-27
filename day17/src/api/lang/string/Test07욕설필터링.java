package api.lang.string;

import java.util.Scanner;

public class Test07욕설필터링 {
	public static void main(String[] args) {
		/*
		사용자가 임의의 문자열을 입력했을 때 이 안에 포함된 욕설을 모두 마스킹 처리하세요
		이번에는 사용자가 띄어쓰기가 있는 문자열을 입력해야 합니다.
		String input = sc.nextLine();

		욕설 샘플은 다음과 같습니다.
		수박, 조카, 시베리아, 개나리, 신발끈, 
		지옥, 주옥, 십장생, 십자수, 게불
		  */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("마음 속에 있는 말 입력 : ");
		String input = sc.nextLine();
		
		String[] texts = new String[] {
			"수박","조카","시베리아","개나리","신발끈",
			"지옥","주옥","십장생","십자수","게불"
		};
//		input =  input.replace(texts[3], "***"); //바꾼 결과를 원본에 덮어쓰기
		
		
		for(int i=0; i<texts.length -1; i++) {
			input =  input.replace(texts[i], "***");
		}
		
		System.out.println(input);
	}
}
