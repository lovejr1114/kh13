package data4;

public class Test07윤년판정 {
	public static void main(String[] args) {
		

		//연도가 4의 배수라면 1년이 366일
		//100의 배수가 될 경우 윤년이 아니다
		//400의 배수라면 100의 배수여도 윤년이다
		//2100년에 윤년인지 아닌지 판정 출력
		
		//입력
		//int obYear = 2100;
		
		//계산
		//boolean multi = obYear % 4 == 0 ;
		//System.out.println(multi);
		//boolean  four = obYear % 400 == 0 && obYear % 100 == 0;
		//System.out.println(four);
		//boolean = 2100년은 윤년인가
		//boolean result = 
		
		//선생님 풀이
		//입력
		int year = 2100;
		
		//계산
		//boolean condition1 = year가 4의 배수?
		boolean condition1 = year % 4 ==0;
		//boolean condition2 = year가 100의 배수가 아닌가?
		boolean condition2 = year % 100 != 0;
		//boolean condition3 = year가 400의 배수?
		boolean condition3 = year % 400 == 0;
		System.out.println(condition3);
		
		boolean leap = condition3 || (condition1 && condition2);
		
		//출력
		System.out.println("윤년인가요? " + leap);
	}

}
