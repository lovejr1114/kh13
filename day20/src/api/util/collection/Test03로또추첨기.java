package api.util.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test03로또추첨기 {
	public static void main(String[] args) {
//		ArrayList를 만들어 이번 주 예상 로또 번호 6개를 추첨하여 저장한 뒤 출력
//		(단, Random클래스를 사용하고, 중복된 번호는 추첨할 수 없다)
//
//		주의사항
//		Generic type에는 class 형태만 작성할 수 있습니다. 
		
		//[1] ArrayList를 만들고 숫자 6개를 저장한 뒤 출력
		ArrayList<Integer> lotto = new ArrayList<>();
		
		lotto.add(11);
		lotto.add(4);
		lotto.add(44);
		lotto.add(23);
		lotto.add(31);
		lotto.add(1);
		
		System.out.println(lotto);
		
	}
}
