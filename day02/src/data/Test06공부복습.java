package data;

public class Test06공부복습 {
	public static void main(String[] args) {
		//어제 복습한 시간은 총 2시간 45분이고
		//오늘 복습한 시간은 총 3시간 35분입니다.
		//이틀동안 공부한 시간은 총 몇시간 몇분인가요?
		
		//입력
		int yesterdayHours = 2;
		int yesterdayminutes = 45;
		
		int todayHours = 3;
		int todayminutes = 35;
		
		//계산
		int yesterday = (yesterdayHours * 60 ) + yesterdayminutes;
		//System.out.println(yesterday);
		int today = (todayHours * 60) + todayminutes;
		//System.out.println(today);
		int total = (yesterday+today) / 60;
		int totl = (yesterday+today) % 60;
		System.out.println(total);
		System.out.println(totl);
	
		
		//선생님 강의대로
		
		//입력
		int yesterdayHour = 2;
		int yesterdayMinute = 45;
		int todayHour = 3;
		int todayMinute = 35;
		
		//계산
		int yesterdayTotal = (yesterdayHour * 60) + yesterdayMinute;
		int todayTotal = todayHour * 60 + todayMinute;
		
		int finish = yesterdayTotal + todayTotal;
		
		int hour = finish / 60;
		int minute = finish % 60;
		//출력에서 계산하기 보다는 계산에서 변수를 더 만들어라.
		//finish라고 적은 이유는 위에 total이 이미 있기 때문에 다른 언어 적은거임..
		
		//출력
		System.out.println(hour);
		System.out.println(minute);
	}

}
