package array;

import java.util.Random;

public class Test07확률뽑기2 {
	public static void main(String[] args) {
		//다음과 같은 아이템 추첨 확률이 주어졌을 때
		//실행하면 확률에 맞게 무작위로 하나의 항목이 추첨되도록 구현
		//- 금 상자 : 10%
		//- 은 상자 : 20%
		//- 철 상자 : 70%
		
		String[] items = new String[] {
				"금상자","은상자", "은상자", "철상자", "철상자",
				"철상자", "철상자", "철상자", "철상자", "철상자"
		};
		
		Random r = new Random();
//		int p = r.nextInt(10); //0부터 9까지 - 0부터 10개
		int p = r.nextInt(items.length);
		System.out.println("p = " + p);
		
		System.out.println("추첨 결과 = " + items[p]);
	}

}
