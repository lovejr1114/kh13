package data;

public class Test09만나이 {
	public static void main(String[] args) {
		//오늘은 2023년 12월 6일
		//2000년 1월 1일생의 만나이를 구하여 출력하라
		//단, 생년월일은 20231206처럼 8자리 숫자형태로 제공됩니다.
		//단, 일은 고려하지 않고 월까지만 고려합니다.
		//287개월 23살
		
		//입력 
		int current = 20231206;
		int birth = 20000101;
		
		//계산
		int today = current / 10000; //2023
		//System.out.println(today);
		int age = birth / 10000; //2000
		//System.out.println(age);
		
		int year = today - age; //23
		//System.out.println(year);
		int a = year *12;
		//System.out.println(a);
		
		int month = current / 100 % 100; //12
		//System.out.println(month);

		int day = birth / 100 % 100; //1
		//System.out.println(day);




		//선생님 계산법
		
		//계산
		int currentYear = current / 10000; //2023
		int currentMonth = current % 10000 / 100; //12
		int birthYear = birth / 10000; //2000
		int birthMonth = birth % 10000 / 100; //1
		
		int now = currentYear * 12 + currentMonth;
		int before = birthYear * 12 + birthMonth;
		int gap =  now - before; //개월 수
		//System.out.println(gap);
		
		int age1 = gap / 12;
		
		//출력
		System.out.println(age1);
		

	}

}
