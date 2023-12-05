package data;

public class Test03영화관 {
	public static void main(String[] args) {
		//입력 - 문제에서 주어진 값들을 변수에 저장
		int adultPrice = 12000;
		int teenPrice = 8500;
		int adultPerson = 2;
		int teenPerson = 2;
		
		//계산
		int adultTotal = adultPrice * adultPerson;
		//System.out.println(adultTotal);
		int teenTotal = teenPrice * teenPerson;
		//System.out.println(teenTotal);
		int total = adultTotal + teenTotal;
		
		//출력 - 문제에서 요구하는 값을 화면에 출력
		System.out.println(total);
	}

}
