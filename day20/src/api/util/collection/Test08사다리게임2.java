package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08사다리게임2 {
	public static void main(String[] args) {
		//네이버 사다리 타기
		//인원수 3명 고정 
		
		//선생님 코드 - 반복문 없이
		
		Scanner sc = new Scanner(System.in);
		
		List<String> people = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		System.out.println("이름을 3개 입력하세요.");
		people.add(sc.nextLine());
		people.add(sc.nextLine());
		people.add(sc.nextLine());
		
		System.out.println("당첨항목 3개 입력하세요.");
		result.add(sc.nextLine());
		result.add(sc.nextLine());
		result.add(sc.nextLine());
		
		
		Collections.shuffle(result); //항목 섞기
		
		for(int i=0; i<people.size(); i++) {
			System.out.println(people.get(i) + " → " +result.get(i));
		}
	}
}
