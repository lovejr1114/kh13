package data2;

public class Test01실수 {
	public static void main(String[] args) {
		//실수란?
		//- 소수점이 있는 숫자
		//- 손해가 좀 발생하더라도 경량 형태(부동소수점 방식)로 저장하도록 구성
		//- float, double이 있으며 double이 기본 형태
		
		double a = 123.4567;
		System.out.println(a);
		
		float b = 123.4567F; //F는 대,소문자 구분 안해도 됨. 하지만 표시는 꼭.
		System.out.println(b);
		
		//소수점이 짧을거같으면 float 사용, 길 것 같으면 double 사용
		//- 실수가 하나라도 포함된 계산은 결과가 실수
		int s1 = 50;
		int s2 =55;
		int s3 = (s1 + s2) / 2;
		System.out.println(s3);
		
		double s4 = (s1 + s2) / 2.0; //정수+정수=정수 , 정수+실수=실수 이니까 하나는 실수 꼭.
		
		System.out.println(s4);
	}

}
