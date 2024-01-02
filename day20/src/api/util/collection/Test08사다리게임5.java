package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08사다리게임5 {
	public static void main(String[] args) {
		//네이버 사다리 타기
		//인원수 3명 고정 
		
		//선생님 코드 - 인원수 입력 처리
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원수 설정 : ");
		int count = sc.nextInt();
		//nextInt() 다음에 nextLine()을 쓰려면 중간에 제거문장을 넣는다.
		sc.nextLine(); //다음 입력에 영향을 주는 잔여 엔터 정리
		//이거 안넣으면 이름 입력란에 엔터 영향 받아서 -1개 입력됨
		
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
		
		System.out.println("<추첨 결과>");
		for(int i=0; i<count; i++) {
			System.out.println(people.get(i) + " → " +result.get(i));
		}
	}
}
