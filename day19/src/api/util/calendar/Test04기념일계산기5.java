package api.util.calendar;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test04기념일계산기5 {
	public static void main(String[] args) {
//		사용자에게 문자열로 YYYY-MM-DD 형식의 날짜를 입력받습니다.
//		입력된 날짜를 기준으로한 기념일을 계산하여 출력
//
//		100일 간격으로 계속
//		1년 간격으로 계속
//		100일, 200일, 300일, 1주년, 400일, 500일, 600일, 700일, 2주년
		
		//선생님 풀이 (배열은 쓰지 않아도 되지만 반복문은 사용해줘야한다)
		
		//입력한 날짜부터 100일간격으로 출력해보자 //스캐너는 알아서
		String input = "2023-12-29";
		int year = Integer.parseInt(input.substring(0, 4));
		int month = Integer.parseInt(input.substring(5,7));
		int day = Integer.parseInt(input.substring(8));
		
		Calendar c = Calendar.getInstance();

		//구해야하는 날짜( 더해야하는 날짜)를 미리 저장
		int[] numbers = new int[] {
				100, 200, 300, 365+1, 400, 500, 600, 700, 730+1, 800, 900, 1000
		};
		
		for(int i=0; i<numbers.length; i++) {
			c.set(year, month-1, day + numbers[i]);
			
			//날짜 출력
			Date d= c.getTime();
			SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E요일");
			if(numbers[i] % 100 == 0) {
				System.out.println(numbers[i]+"일 뒤 : " +fmt.format(d));							
			}
			else {
				System.out.println(numbers[i]/365+"주년 : "+fmt.format(d));
			}
		}
	}
}
