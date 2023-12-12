package random;

import java.util.Random;

public class Test02랜덤생성 {
	public static void main(String[] args) {
		//다음 제시 된 값을 생성해보세요
		
		Random r = new Random(); //도구 생성
		
		//공식 : int number = r.nextInt(개수) + 시작수;

		//1. 로또 번호 1개를 추첨한 결과 - 로또 1부터 45개
		int lotto = r.nextInt(45) +1;
		System.out.println("로또 번호 : " + lotto);
		
		//2. 두 자리 정수 중 한 개를 추첨한 결과 - 10부터 99까지 - 10부터 90개
		int num = r.nextInt(90) +10;
		System.out.println("두 자리 정수 중 한 개 : " + num);
		
		//3. 6자리 OTP 번호 한 개를 생성한 결과 - 0부터시작은 출력되지않음
		//100000부터 999999까지 - 100000부터 900000까지
		int otp = r.nextInt(900000) + 100000;
		System.out.println("6자리 OTP 번호 한 개 : " + otp);
		
		//주의 - Random은 문자열을 만들 수 없다. 그러니까 약속을 한다.
		
		//4. 동전의 앞/뒤 중 하나를 생성한 결과
		//앞을 1이라 하고 뒤를2라고 한다. 1부터 2까지 - 1부터 2개
		//int coin = r.nextInt(2) + 1; 
		//식을 더 간단히 하고싶으면 앞(0) 뒤(1)이라고 정한다. - 0부터 1까지 - 0부터 2개
		int coin = r.nextInt(2);
		if(coin == 0) {
			System.out.println("동전=앞");
		}
		else {
			System.out.println("동전=뒤");
		}

		//5. 가위/바위/보 중 하나를 생성한 결과
		//가위(0) 바위(1) 보(2)  - 0부터 3개
		int rsp = r.nextInt(3);
		switch(rsp) { //if로 해도되고 스위치로 해도 됨
		case 0:
			System.out.println("가위");
			break;
		case 1:
			System.out.println("바위");
			break;
		case 2:
			System.out.println("보");
			break;
		}
		
		

	}

}
