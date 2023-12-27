package api.lang.string2;

import java.util.Scanner;

public class Test05날짜검사3 {
	public static void main(String[] args) {
		/*
		 사용자에게 생년월일을 입력받아서 올바른 형식인지 검사 후 출력

		요구사항
		연도는 1900 부터 2099년 사이에서 설정 (1900~2099)
		월은 1월부터 12월 사이에서 설정 (01~12)
		일은 월에 따라 다르긴 하지만 우선 31일로 고정 (01~31)
		형식은 YYYY-MM-DD 형태로 대시가 포함된다.

		업그레이드
		월에 따라 날짜가 다르게 설정되도록 구현(2월은 29일로 가정)
		윤년인지 아닌지 프로그램에서 판정하여 정규표현식에 반영
		*/
//		Scanner sc = new Scanner(System.in);
//		System.out.print("생년월일 입력 (YYYY-MM-DD) : ");	
		String birth = "2000-02-29";//sc.nextLine();
		
		//어떻게하면 birth의 앞 네자리를 뽑아서 정수로 바꿔서 year에 넣을 수 있을까?
		String yearPart = birth.substring(0,4); //birth의 앞 커서위치부터 순서대로
		
		//윤년계산은 프로그래밍 코드로 진행
		int year = Integer.parseInt(yearPart);
		boolean isLeap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0); //윤년계산공식
		
		//윤년 여부에 따라 검사식의 마지막 날짜를 구해서 적용
		int number;
		if(isLeap) {
			number = 9;
		}
		else {
			number = 8;
		}
		
		
		String regex = "^(19|20)[0-9]{2}-(02-(0[1-9]|1[0-9]|2[0-"+number+"])|(0[469]|11)-(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))$";
		
		if(birth.matches(regex)) {
			System.out.println("생년월일 설정 완료");
		}
		else {
			System.out.println("잘못된 날짜 형식입니다");
		}

	}
}
