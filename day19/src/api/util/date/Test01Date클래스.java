package api.util.date;

import java.util.Date;

public class Test01Date클래스 {
	public static void main(String[] args) {
		//Date클래스
		//- 결론: 밀레니엄버그(Y2K)로 인해 대부분의 기능이 비추천됨
		//- 현재 시각을 구하는 기능은 여전히 사용
		
		Date a = new Date();
		Date b = new Date(2023,12,29);
		
		System.out.println("a = "+a);
		System.out.println("b =" +b);
	}
}
