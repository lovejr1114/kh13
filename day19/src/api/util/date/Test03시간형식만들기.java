package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03시간형식만들기 {
	public static void main(String[] args) {
//		밑에 형식으로 만들어보자 (날짜와 시간은 현재로. 형식만 갖춰서)
//		2023년 7월 11일
//		오후 1시 5분
//		13:05:30
//		2023-07-11 화 13:05:30
		
		Date a = new Date();		
		
		SimpleDateFormat fmt1 = new SimpleDateFormat("y년 M월 d일");		
		System.out.println(fmt1.format(a));
		
		SimpleDateFormat fmt2 = new SimpleDateFormat("a h시 m분");
		System.out.println(fmt2.format(a));
		
		SimpleDateFormat fmt3 = new SimpleDateFormat("HH:mm:ss");
		System.out.println(fmt3.format(a));
		
		SimpleDateFormat fmt4 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		//여기서는 yyyy-MM-dd 이런식으로 하는 이유는 자릿수를 맞추기 위한 것.
		//ex) 2000-01-04  /   0100-04-09  이런식으로 자릿수 맞추기위해서.
		System.out.println(fmt4.format(a));
	}
}
