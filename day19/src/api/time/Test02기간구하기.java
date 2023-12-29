package api.time;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Test02기간구하기 {
	public static void main(String[] args) {
//		사용자에게 'YYYY-MM-DD' 형태로 두 개의 날짜를 입력 받아서
//		두 날짜의 차이 구하여 출력
//		
//		###요구사항
//		- 반드시 먼저 입력한 날짜가 나중에 입력한 날짜보다 이전이어야합니다.
//		- 그렇지 않을 경우 '차이를 계산할 수 없습니다' 메세지 출력
//		- 차이는 '?년 ?개월 ?일' 형태로 출력
		
		try {		
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY-MM-DD 형식으로 입력해주세요.");
		System.out.print("날짜 입력 : ");
		String input1 = sc.nextLine();
		System.out.print("날짜 입력 : ");
		String input2 = sc.nextLine();
		
		int year1 = Integer.parseInt(input1.substring(0,4));
		int month1 = Integer.parseInt(input1.substring(5,7));
		int day1 = Integer.parseInt(input1.substring(8));
		int year2 = Integer.parseInt(input2.substring(0,4));
		int month2 = Integer.parseInt(input2.substring(5,7));
		int day2 = Integer.parseInt(input2.substring(8));
		
		if(year1 > year2) {
			throw new Exception("차이를 계산할 수 없습니다.");
		}
		if(!(month1 >= 1 && month1 <=12) || !(month2>=1&&month2<=12)){
			throw new Exception("1~12월만 입력 가능합니다.");
		}
		
		LocalDate a = LocalDate.of(year1, month1, day1);
		LocalDate b = LocalDate.of(year2, month2, day2);
		
		Period period = Period.between(a, b);
//		System.out.println(period.getYears());
//		System.out.println(period.getMonths());
//		System.err.println(period.getDays());
		
		System.out.println("차이는 " + period.getYears()+"년 "+
		period.getMonths()+"개월 " +period.getDays()+"일");
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
