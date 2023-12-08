package condition;

public class Test03과속카메라2 {
	public static void main(String[] args) {
		
		//입력
		int speed = 60;
		
		//계산
		boolean over = speed > 50;
		
		
		//출력
		if(over) {
			//int total = (speed - 50) / 10 * 10000 +30000;
			int total = speed /10 * 10000 - 20000;
			System.out.println("과속! 벌금 " + total + "원");
		}
		else {
			System.out.println("벌금 0원");
	}
		
	}
}
