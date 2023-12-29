package api.time;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Test02기간구하기2 {
	public static void main(String[] args) {
//		사용자에게 'YYYY-MM-DD' 형태로 두 개의 날짜를 입력 받아서
//		두 날짜의 차이 구하여 출력
//		
//		###요구사항
//		- 반드시 먼저 입력한 날짜가 나중에 입력한 날짜보다 이전이어야합니다.
//		- 그렇지 않을 경우 '차이를 계산할 수 없습니다' 메세지 출력
//		- 차이는 '?년 ?개월 ?일' 형태로 출력
		
		//선생님 풀이
		
		String str1 = "2023-05-08";
		String str2 = "2024-01-01";
		
		LocalDate a = LocalDate.parse(str1);
		LocalDate b = LocalDate.parse(str2);
		
		//a가 b보다 이전인지 판정
//		System.out.println(a.isBefore(b));
		if(a.isBefore(b)) {
			Period period = Period.between(a, b);
			System.out.println(period.getYears()+"년");
			System.out.println(period.getMonths()+"개월");
			System.err.println(period.getDays()+"일");
		}
		else {
			System.out.println("기간을 구할 수 없습니다.");
		}
	}
}
