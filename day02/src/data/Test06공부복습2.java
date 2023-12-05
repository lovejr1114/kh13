package data;

public class Test06공부복습2 { //시간 따로 분 따로 계산
	public static void main(String[] args) {
		//어제 복습한 시간은 총 2시간 45분이고
		//오늘 복습한 시간은 총 3시간 35분입니다.
		//이틀동안 공부한 시간은 총 몇시간 몇분인가요?
		
		//입력
		int yesterdayHour = 2 , yesterdayMinute = 45;
		int todayHour = 3 , todayMinute = 35;
				
				//계산 -시간 따로 분 따로
		int minuteTotal = yesterdayMinute + todayMinute;
		int hour = yesterdayHour + todayHour + minuteTotal / 60;
		int minute = minuteTotal % 60;
		
		//출력
		System.out.println(hour);
		System.out.println(minute);
				
	}

}
