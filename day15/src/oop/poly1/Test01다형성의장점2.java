package oop.poly1;

import java.util.Random;

public class Test01다형성의장점2 {
	public static void main(String[] args) {
		
		//Q : 랜덤으로 아이폰14나 15 중 하나를 추첨해라
		
		Random r = new Random();
		//약속 : 아이폰 14(0) , 아이폰15(1)
		
		int choice = r.nextInt(2); //0부터 2개
		
		IPhone phone; //변수를 생성해준다
		
		if(choice == 0) {
			phone = new IPhone14(); //IPhone14 -> IPhone (업캐스팅)
		}
		else {
			phone = new IPhone15(); //IPhone15 -> IPhone (업캐스팅)
		}
		
		//생성 후에도 phone의 객체를 사용할 수 있다 (변수로 만들었기 때문에)
		phone.call();
		phone.sms();
	}
}
