package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test09카드게임3 {
	public static void main(String[] args) {
//		트럼프 카드에서 사용자가 입력한 장수 만큼의 카드를 랜덤으로 섞은 뒤 추첨하는 프로그램을 구현하려고 합니다. 
//		콘솔 환경이기 때문에 그래픽으로 구현하긴 어려우니 글자로 대체해서 보여주려고 합니다.
//		(ex : 하트3, 스페이드A)
//
//		카드는 총 52장이 있습니다.
//		52장은 4종류의 모양으로 구분됩니다(하트/스페이드/클로버/다이아)
//		각각의 모양에는 A,2,3,4,5,6,7,8,9,10,J,Q,K가 존재합니다.
//
//		카드 한 덱(52장)을 생성
//		카드덱을 셔플
//		사용자가 원하는 만큼 출력
//		추가
//		다 구현한 뒤 4명이 포커를 친다고 가정하고 한 사람당 7장씩 카드를 나눠준 뒤 각자가 가진 패를 출력해보세요.
		
		
		//비어있는 카드 덱 생성
		List<String> deck = new ArrayList<>();
		
		//카드덱에 카드 추가
		deck.add("하트 A");
		deck.add("하트 2");
		deck.add("하트 3");
		deck.add("하트 4");
		deck.add("하트 5");
		deck.add("하트 6");
		deck.add("하트 7");
		deck.add("하트 8");
		deck.add("하트 9");
		deck.add("하트 10");
		deck.add("하트 J");
		deck.add("하트 Q");
		deck.add("하트 K");
		
		deck.add("클로버 A");
		deck.add("클로버 2");
		deck.add("클로버 3");
		deck.add("클로버 4");
		deck.add("클로버 5");
		deck.add("클로버 6");
		deck.add("클로버 7");
		deck.add("클로버 8");
		deck.add("클로버 9");
		deck.add("클로버 10");
		deck.add("클로버 J");
		deck.add("클로버 Q");
		deck.add("클로버 K");
		
		deck.add("스페이드 A");
		deck.add("스페이드 2");
		deck.add("스페이드 3");
		deck.add("스페이드 4");
		deck.add("스페이드 5");
		deck.add("스페이드 6");
		deck.add("스페이드 7");
		deck.add("스페이드 8");
		deck.add("스페이드 9");
		deck.add("스페이드 10");
		deck.add("스페이드 J");
		deck.add("스페이드 Q");
		deck.add("스페이드 K");
		
		deck.add("다이아몬드 A");
		deck.add("다이아몬드 2");
		deck.add("다이아몬드 3");
		deck.add("다이아몬드 4");
		deck.add("다이아몬드 5");
		deck.add("다이아몬드 6");
		deck.add("다이아몬드 7");
		deck.add("다이아몬드 8");
		deck.add("다이아몬드 9");
		deck.add("다이아몬드 10");
		deck.add("다이아몬드 J");
		deck.add("다이아몬드 Q");
		deck.add("다이아몬드 K");
		
		//카드 덱 섞기
		Collections.shuffle(deck);
		System.out.println("카드 장 수 = "+ deck.size() +"장");
		
		//입력으로 변경
		Scanner sc = new Scanner(System.in);
		System.out.print("장수(1~52) : ");
		int count = sc.nextInt();
		if(count >= 1 && count <= 52) {
			for(int i=0; i<count; i++) {
				System.out.println(deck.get(0));
				deck.remove(0);
			}
		}
		else {
			System.out.println("유효하지 않은 장수");
		}
		
	}
}
