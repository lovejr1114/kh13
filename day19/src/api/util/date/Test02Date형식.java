package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02Date형식 {
	public static void main(String[] args) {
		//Date를 이용해 구한 현재시각을 원하는 형식으로 출력해보자
		//- 자바는 형식을 직접 바꾸는 것이 아니라 ~Format 클래스 형태로 제공
		
		Date d = new Date(); //정보만 얻어온다.
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		//api에 SimpleDateFormat 검색하여 읽어보자. letter들이 표로 나와있음
		System.out.println(fmt.format(d));
	}
}
