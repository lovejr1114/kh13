package data4;

public class Test02성인인증 {
	public static void main(String[] args) {
		//사용자의 생년월일 8자리를 변수에 저장한 뒤 이 사람이 성인인지 판정하여 출력하도록 구현하는 프로그램을 만드세요

//예시 생년월일 : 20020507

//성인은 한국 나이로 20세 이상일 경우를 말합니다
//(연도만으로 나이를 계산합니다)
		
		//int birth = 20020507;  //<- 년도 바꿔서 입력해보고 나이 나오는지 검색해보기
		//int thisY = 2023;
		//int adultAge = 20;
		
		
		//계산
		//int year = birth / 10000;
		//System.out.println(year);
		//int age = (thisY+1) - year;
		//System.out.println(age);
		//boolean adult = age >= adultAge;
		//System.out.println("성인 입니까? : " +adult);
		
		
		//선생님 풀이
		//입력
		int birth = 20020507;
		
		//계산
		int birthYear = birth / 10000;
		
		int age = 2023 - birthYear + 1;
		boolean adult = age >= 20;  //'20'은 성인의 고정 숫자, 변수가 아니기 때문에 입력 안해도 된다.
		
		//출력
		System.out.println("나이 : " + age);
		System.out.println("성인 입니까? : " + adult);
	}

}
