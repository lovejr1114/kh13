package data;

public class Test09만나이 {
	public static void main(String[] args) {
		//오늘은 2023년 12월 6일
		//2000년 1월 1일생의 만나이를 구하여 출력하라
		//단, 생년월일은 20231206처럼 8자리 숫자형태로 제공됩니다.
		//단, 일은 고려하지 않고 월까지만 고려합니다.
		//287개월 23살이 나와야함..
		
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
		
		//20231206 중, 10000으로 나눠 네 자리수 (출생연도)를 구한다.
		//그리고 월 단위인  12월을 구하기 위해 20231206 몫 100 나머지 100
		//(또는 나머지 100 나누기 100해보고 안나오면 월 나올 때까지 입력해보기)
		//일 수도 월 단위 계산법과 똑같이 계산해준다.
		//구한 값을 낮은 단위인 개월 수로 바꿔준다. (계산한 연도 * 12(변하지않는상수) + 일 수)
		//현재 시간에서 출생한날짜를 빼준다.
		//위 나온 값에서 12개월을 나눠준다. 그럼 만 나이가 나온다.
		

	}

}
