package condition;

public class Test01조건3 {
	public static void main(String[] args) {
		//홀수 짝수 판정 프로그램
		//- 주어진 값이 홀수라면 "홀수입니다" 출력
		//- 주어진 값이 짝수라면 "짝수입니다" 출력

		//입력
		int number = 127;
		
		//계산
		boolean odd = number % 2 != 0; 
		
		//출력
		if(odd) {
			System.out.println("홀수입니다.");  //odd가 true일 때 나옴.
		}
		
		
		if(!odd) { //부정적인 표현보단 알아보기 쉬운 코드로 ex) != 같이..
			System.out.println("짝수입니다.");
			
		}
	}

}
