package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08사다리게임4 {
	public static void main(String[] args) {
		//네이버 사다리 타기
		//인원수 3명 고정 
		
		//선생님 코드 - 인원수 설정 가능하도록 변경
		int count = 4;
		
		Scanner sc = new Scanner(System.in);
		
		List<String> people = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		System.out.println("이름을 "+ count +"개 입력하세요.");
		for(int i=0; i< count; i++) {			
			people.add(sc.nextLine());
		}
		
		System.out.println("당첨항목 " +count+"개 입력하세요.");
		for(int i=0; i<count; i++) {
			result.add(sc.nextLine());
		}
		
		
		Collections.shuffle(result); //항목 섞기
		
		for(int i=0; i<count; i++) {
			System.out.println(people.get(i) + " → " +result.get(i));
		}
	}
}
