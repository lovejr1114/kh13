package data4;

public class Test03논리연산 {
	public static void main(String[] args) {
		//논리 연산
		//- 논리끼리 계산 할 때 사용
		//- &&(and), ||(or)을 이용하여 조합
		
		//예) 19살은 청소년인가요?
		//- 청소년은 14살부터 19살까지 입니다.
		
		int age = 19;
		//boolean teen = 14 <= age <= 19; <-잘못된 식, 논리연산끼리 묶어줘야함 && , ||
		boolean teen = 14 <= age&&age<=19;
		System.out.println("청소년인가요? " + teen);
	}

}
