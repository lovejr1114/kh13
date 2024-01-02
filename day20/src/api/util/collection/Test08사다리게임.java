package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08사다리게임 {
	public static void main(String[] args) {
		//네이버 사다리 타기
		//인원수 3명 고정 = 개수를 고정하면 반복문이 굳이 나오지 않아도 된다(많은 것이 아니면)
		
		Scanner sc = new Scanner(System.in);
		
		List<String> people = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		for(int i=1; i<=3; i++) {
			System.out.print("이름  : ");
			String name = sc.nextLine();
			people.add(name);
		}
		
		for(int i=1; i<=people.size(); i++) {
			System.out.print("입력 : ");
			String input = sc.nextLine();
			result.add(input);
		}
		
		
		Collections.shuffle(result); //항목 섞기
		
		for(int i=0; i<people.size(); i++) {
			System.out.println(people.get(i) + " → " +result.get(i));
		}
	}
}
