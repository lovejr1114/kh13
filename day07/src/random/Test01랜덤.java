package random;

import java.util.Random;

public class Test01랜덤 {
	public static void main(String[] args) {
		//랜덤(Random)
		//-예측이 불가능한 값
		//-(예) 주사위,동전던지기,윷놀이,로또,가위바위보..... OTP번호(=조작된 랜덤)....
		//-예측은 안되지만 범위는 알 수 있어야 한다.
		//-자바는 완벽한 랜덤은 불가능, 유사랜덤 형태의 도구를 제공. 도구 이름이 Random
		
		Random r = new Random(); //도구 생성
		
		//Scanner와 명령이 비슷하므로 조심해야한다.
		int a = r.nextInt();
		System.out.println("a = " + a);
		
		//범위를 지정해서 랜덤을 추출할 수 있다.
		//(주의사항) 사람과 자바의 범위 개념이 다르다.
		//-사람은 주사위를 1부터 6까지라고 생각, 로또는 1부터 45까지.
		//-자바는 주사위 범위를 1부터 6개라고 생각.
		
		int dice = r.nextInt(6) + 1; //1부터 6개
		System.out.println("주사위 = " + dice);
	}

}
