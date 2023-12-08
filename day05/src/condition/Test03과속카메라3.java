package condition;

public class Test03과속카메라3 {
	public static void main(String[] args) {
		
		//입력
		int speed = 60;
		int limit = 50; //제한속도
		int per = 10; //벌금 구간(km)
		int step = 10000; //벌금 증가분 (원)
		int base = 30000; //최저벌금 (원)
		
		//계산
		boolean over = speed > limit;
		
		
		//출력
		if(over) {
			int total = (speed - limit) / per * step +base;
			//int total = speed /per * step - 20000;
			System.out.println("과속! 벌금 " + total + "원");
		}
		else {
			System.out.println("벌금 0원");
	}
		
	}
}
