package loop3;

public class Test04현명한노인 {
	public static void main(String[] args) {
//		고대 그리스에는 현명한 노인이 살고 있습니다.
//		소문을 들은 왕이 노인에게 가서 이렇게 말했습니다.
//		"가지고 싶은게 있으면 무엇이든 줄터이니 한 번 말해봐라"
//		노인이 고민하더니 다음과 같이 말했습니다.
//		"저는 욕심이 없습니다. 
//		30일동안 처음에는 1골드만 주시고 그다음 날부터는 전날의 두 배를 주십시오"
//		이 노인이 일자별로 받게되는 골드를 구하여 출력
//		이 노인이 받게되는 총 골드를 구하여 출력
//		30일이 아니라 40일이었다면 얼마를 받는지 구하여 출력
		
		//코드 줄 위치 또 틀림.... ㅠㅠ
		
		int step = 2; //만들지 않아도 문제 없음! 처음엔 만들지 않고 해보는 것이 좋음
		int gold = 1;
		int pay = 0;
		
		for(int day=1; day<=30; day++) {
			System.out.println(day+"일 차 : "+gold + "골드"); //1번 문제
			gold *= step; //일자별 골드
			
			pay += gold;
		}
		System.out.println("30일동안 받는 골드 : " + pay); //2번 문제
		
		long step2 = 2L;
		long gold2 = 1L;
		long pay2 = 0L;
		
		for(int day=1; day<=40; day++) {
			gold2 *= step2;
			pay2 += gold2;
		}
		System.out.println("40일동안 받는 골드 : " + pay2); //3번 문제
	}
	

}
