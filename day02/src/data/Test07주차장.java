package data;

public class Test07주차장 {
	public static void main(String[] args) {
		//KH주차장은 10분당 1500원의 요금을 받고 있습니다.
		//처음 9분까지는 돈을 받지 않고 10분이 되면 1500원, 20분이 되면 3000원으로 요금이 올라갑니다

		//11시 50분에 들어와서 17시 25분에 나간 차량의 요금을 출력
		//(단, 다음날까지 주차는 절대로 불가능합니다)
		
		
		//입력
		int timeMinute = 10;
		int timePrice = 1500;
		int inHour = 11 , inMinute = 50;
		int outHour = 17 , outMinute = 25;
		
		//계산
		int inTime = inHour * 60 + inMinute;
		//System.out.println(inTime);
		int outTime = outHour * 60 + outMinute;
		//System.out.println(outTime);
		int parkingTime = outTime - inTime; //335분
		//System.out.println(parkingTime);
		int parkingHour = parkingTime / 60;
		int parkingMinute = parkingTime % 60;
		//System.out.println(parkingHour);
		//System.out.println(parkingMinute);
		int totalT =  parkingTime / timeMinute;
		int pay = parkingTime / timeMinute * timePrice;
		//System.out.println(pay);
	
		
		//출력
		System.out.println("주차 시간은 " + parkingHour + "시간 " + parkingMinute + "분이며, 주차 요금은 총" + pay + "원입니다.");
			
	}

}
