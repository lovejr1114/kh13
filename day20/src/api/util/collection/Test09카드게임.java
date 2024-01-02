package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test09카드게임 {
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
		deck.add("하트A");
		deck.add("하트2");
		deck.add("하트3");
		deck.add("하트4");
		deck.add("하트5");
		deck.add("하트6");
		deck.add("하트7");
		deck.add("하트8");
		deck.add("하트9");
		deck.add("하트10");
		deck.add("하트J");
		deck.add("하트Q");
		deck.add("하트K");
		
		deck.add("클로버A");
		deck.add("클로버2");
		deck.add("클로버3");
		deck.add("클로버4");
		deck.add("클로버5");
		deck.add("클로버6");
		deck.add("클로버7");
		deck.add("클로버8");
		deck.add("클로버9");
		deck.add("클로버10");
		deck.add("클로버J");
		deck.add("클로버Q");
		deck.add("클로버K");
		
		deck.add("스페이드A");
		deck.add("스페이드2");
		deck.add("스페이드3");
		deck.add("스페이드4");
		deck.add("스페이드5");
		deck.add("스페이드6");
		deck.add("스페이드7");
		deck.add("스페이드8");
		deck.add("스페이드9");
		deck.add("스페이드10");
		deck.add("스페이드J");
		deck.add("스페이드Q");
		deck.add("스페이드K");
		
		deck.add("다이아몬드A");
		deck.add("다이아몬드2");
		deck.add("다이아몬드3");
		deck.add("다이아몬드4");
		deck.add("다이아몬드5");
		deck.add("다이아몬드6");
		deck.add("다이아몬드7");
		deck.add("다이아몬드8");
		deck.add("다이아몬드9");
		deck.add("다이아몬드10");
		deck.add("다이아몬드J");
		deck.add("다이아몬드Q");
		deck.add("다이아몬드K");
		
		//카드 덱 섞기
		Collections.shuffle(deck);
		System.out.println("카드 장 수 = "+ deck.size() +"장");
		
		//5장 꺼내기
		System.out.println(deck.get(0));
		System.out.println(deck.get(1));
		System.out.println(deck.get(2));
		System.out.println(deck.get(3));
		System.out.println(deck.get(4));
	}
}
