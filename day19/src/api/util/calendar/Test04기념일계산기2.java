package api.util.calendar;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test04기념일계산기2 {
	public static void main(String[] args) {
//		사용자에게 문자열로 YYYY-MM-DD 형식의 날짜를 입력받습니다.
//		입력된 날짜를 기준으로한 기념일을 계산하여 출력
//
//		100일 간격으로 계속
//		1년 간격으로 계속
//		100일, 200일, 300일, 1주년, 400일, 500일, 600일, 700일, 2주년
		
		//선생님 풀이
		
		//오늘부터 계산한 1주년을 구하여 출력
		Calendar c = Calendar.getInstance();
		
		
		//[1] set() 과 get() 으로 풀기
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 100);
		
		//[2] add()로 풀기
//		c.add(Calendar.DATE, 100);
		
		
		//날짜 출력
		Date d= c.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E요일");
		System.out.println(fmt.format(d));
	}
}
