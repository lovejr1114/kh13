package api.util.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test03로또추첨기2 {
	public static void main(String[] args) {
//		ArrayList를 만들어 이번 주 예상 로또 번호 6개를 추첨하여 저장한 뒤 출력
//		(단, Random클래스를 사용하고, 중복된 번호는 추첨할 수 없다)
//
//		주의사항
//		Generic type에는 class 형태만 작성할 수 있습니다. 
		
		//[2] Random을 만들고 숫자를 랜덤으로 대체
		ArrayList<Integer> lotto = new ArrayList<>();
		Random r = new Random();
		
		lotto.add(r.nextInt(45) +1);
		lotto.add(r.nextInt(45) +1);
		lotto.add(r.nextInt(45) +1);
		lotto.add(r.nextInt(45) +1);
		lotto.add(r.nextInt(45) +1);
		lotto.add(r.nextInt(45) +1);
		
		System.out.println(lotto);
		
	}
}
