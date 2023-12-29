package api.util.calendar;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test04기념일계산기3 {
	public static void main(String[] args) {
//		사용자에게 문자열로 YYYY-MM-DD 형식의 날짜를 입력받습니다.
//		입력된 날짜를 기준으로한 기념일을 계산하여 출력
//
//		100일 간격으로 계속
//		1년 간격으로 계속
//		100일, 200일, 300일, 1주년, 400일, 500일, 600일, 700일, 2주년
		
		//선생님 풀이
		
		//사용자가 입력한 날짜부터 100일 뒤를 구하여 출력
		String input = "2023-12-29";
		int year = Integer.parseInt(input.substring(0, 4));
		int month = Integer.parseInt(input.substring(5,7));
		int day = Integer.parseInt(input.substring(8));
		
		Calendar c = Calendar.getInstance();
//		c.set(Calendar.YEAR, year);
//		c.set(Calendar.MONTH, month-1); //사용자 입력값에 -1처리 해야함. 월은 0~11까지라서
//		c.set(Calendar.DATE, day + 100); //1주년이면 +366일
		c.set(year, month-1, day + 100);
		
		
		//날짜 출력
		Date d= c.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E요일");
		System.out.println(fmt.format(d));
	}
}
