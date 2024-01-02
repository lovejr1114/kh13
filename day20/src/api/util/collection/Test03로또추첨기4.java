package api.util.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test03로또추첨기4 {
	public static void main(String[] args) {
//		ArrayList를 만들어 이번 주 예상 로또 번호 6개를 추첨하여 저장한 뒤 출력
//		(단, Random클래스를 사용하고, 중복된 번호는 추첨할 수 없다)
//
//		주의사항
//		Generic type에는 class 형태만 작성할 수 있습니다. 
		
		//[3] 반복문으로 변환 (while)
		ArrayList<Integer> lotto = new ArrayList<>();
		Random r = new Random();
		
		while(lotto.size() < 6) { //번호가 6개가 될 때까지
			int number = r.nextInt(45) +1;
			if(lotto.contains(number) == false) { //없는 번호라면
				lotto.add(number);
			}
		
		}
		
		System.out.println(lotto);
		
	}
}
