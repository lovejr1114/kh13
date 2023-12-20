package oop.keyword4;

public class Robot {
	//제곱을 구할 수 있는 메소드 (square)
	//값이 다르다면 오버로딩으로도 가능하다. 하지만 같은건 굳이 X
	public static double square(double number) {
		return number * number;
	}
//	public static int square(int number) {
//		return number * number;
//	}
	
	//삼각형 넓이를 구할 수 있는 메소드 (triangle)
	//=폭 x 높이 ÷ 2
	public static double triangle(double width, double height) {
		return width * height / 2;
	}
	
	//원의 넓이를 구할 수 잇는 메소드 (circle)
	//=반지름*반지름(반지름의 제곱) x 원주율
	public static double circle(double radius) {
//		return 3.14 * (radius * radius);
		return square(radius) * 3.14;
	}
	
	//출생연도 4자리로 지하철 요금 계산 (subway)
	//-성인 (20 이상 65미만) 1400원
	//-청소년 (14 이상 20 미만) 800원
	//-어린이 (8 이상 14 미만) 500원
	//-그 외 0원
	public static int subway(int birth) {
		int year = 2023; //자동으로 컴퓨터시간 불러오는 코드 넣어보기
		int age = year - birth + 1;
		if(age < 8 || age >= 65) {
			return 0;
		}
		else if(age >= 20) {
			return 1400;
		}
		else if(age >= 14) {
			return 800;
		}
		else {
			return 500;
		}
	}
	
	//연도 4자리 넣으면 윤년인지 아닌지 판정하는 메소드 (leap)
	public static boolean leap(int year) {
		boolean con1 = year % 4 == 0;
		boolean con2 = year % 100 != 0;
		boolean con3 = year % 400 == 0;
		boolean leap = con3 || (con1 && con2);
		return leap;
//		if(leap) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}
	
	//키(cm)와 몸무게(kg)로  BMI 계산하는 메소드 (bmi)
	public static double bmi(double cm, double kg) {
		double m = cm / 100;
		return kg / (m * m);
	}
}
