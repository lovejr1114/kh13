package data2;

public class Test05PC방계산기 {
	public static void main(String[] args) {
		//1차로 이용시간 구하기
		//2차로 요금 구하기
		
		//입력
		//int inHour = 12, inMinute =20;
		int in = 1220;
		int out = 1530;
		
		int unitPrice = 1000;
		
		//계산
		int inHour = in /100; //들어온 시각
		int inMinute = in % 100; //들어온 분
		int outHour = out / 100; //나간 시각
		int outMinute = out % 100; //나간 분
		
		int inTime =  inHour * 60 + inMinute; //들어온 시간 변환 값
		int outTime = outHour * 60 + outMinute; //나간 시간 변환 값
		int time = outTime - inTime; //이용시간(분)
		//System.out.println(time);
		int hour = time / 60;
		int minute = time % 60;
		
		//분당 요금
		//double minutePrice = unitPrice / 60.0;
		//double minutePrice = unitPrice / 60d;
		double minutePrice = (double)unitPrice / 60;
		System.out.println(minutePrice);
		
		int result = (int)(time * minutePrice);
		result = result / 10 * 10;
		
		
		//출력
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(result);
		
		
		
	}

}
