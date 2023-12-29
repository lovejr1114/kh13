package api.util.calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test04기념일계산기 {
	public static void main(String[] args) {
//		사용자에게 문자열로 YYYY-MM-DD 형식의 날짜를 입력받습니다.
//		입력된 날짜를 기준으로한 기념일을 계산하여 출력
//
//		100일 간격으로 계속
//		1년 간격으로 계속
//		100일, 200일, 300일, 1주년, 400일, 500일, 600일, 700일, 2주년
		
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜 입력(YYYY-MM-YY) : ");
		String input = "2023-12-29"; //sc.nextLine();
		
		LocalDate current = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println("입력된 날짜 : "+input);
		System.out.println("100일 째 되는 날 : "+ current.plusDays(100));
		System.out.println("200일 째 되는 날 : "+ current.plusDays(200));
		System.out.println("300일 째 되는 날 : "+ current.plusDays(300));
		System.out.println("1년 째 되는 날 : "+current.plusYears(1));
		System.out.println("400일 째 되는 날 : "+ current.plusDays(400));
		System.out.println("500일 째 되는 날 : "+ current.plusDays(500));
		System.out.println("600일 째 되는 날 : "+ current.plusDays(600));
		System.out.println("700일 째 되는 날 : "+ current.plusDays(700));
	}
}
