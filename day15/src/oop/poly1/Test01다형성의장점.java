package oop.poly1;

import java.util.Random;

public class Test01다형성의장점 {
	public static void main(String[] args) {
		
		//Q : 랜덤으로 아이폰14나 15 중 하나를 추첨해라
		
		Random r = new Random();
		//약속 : 아이폰 14(0) , 아이폰15(1)
		
		int choice = r.nextInt(2); //0부터 2개
		if(choice == 0) {
			IPhone14 phone = new IPhone14();
			phone.call();
			phone.sms();		
		}
		else {
			IPhone15 phone = new IPhone15();
			phone.call();
			phone.sms();
		}
		
		//else문으로 끝나면 추첨된 핸드폰 객체를 알 수 없다 (객체 사용 불가하다)
	}
}
