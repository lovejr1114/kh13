package oop.modifire5;

import oop.modifier4.Car;

public class Test01다른패키지 {
	public static void main(String[] args) {
		//Java는 기본 범위가 패키지(package)이다.
		//같은 패키지가 아니면 import가 필요하다.
		Car c = new Car("소나타",150);
		c.information();
	}
}
