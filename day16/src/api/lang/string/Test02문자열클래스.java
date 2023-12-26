package api.lang.string;

public class Test02문자열클래스 {
	public static void main(String[] args) {
		//문자열 (String)
		//- 자바에서 제공하는 문자열 제어 클래스
		//- 정말 몇 개 안되는 new 없이 객체가 생성되는 클래스
		
		//객체 생성
		String a = new String();
		String b = new String("hello");
		
		StringBuffer c = new StringBuffer("hello");
		String d = new String(c); //문자열 아님
		
		String e = "hello";
		String f = "hello";
		
		
		//정보출력
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		
		//비교 연산 =객체에서는 사용하기가 까다롭다 (쓰는거 비추천)
		System.out.println("<비교 연산>");
		System.out.println("b랑 d랑 같나요? " + (b == d));
		System.out.println("d랑 e랑 같나요? " + (d == e));
		System.out.println("e랑 f랑 같나요? " + (e == f));
		System.out.println("b랑 f랑 같나요? " + (b == f));
		//new가 붙어있으면 다른 객체로 인식하기 때문에 같지 않음
		//반면에 e와 f는 new가 붙지도 않았고 똑같기 때문에 JVM이 같다고 판단함.
		
		
		//비교 메소드
		System.out.println("<비교 메소드>");
		System.out.println("b랑 d랑 같아요? " + b.equals(d));
		System.out.println("d랑 e랑 같아요? " + d.equals(e));
		System.out.println("e랑 f랑 같아요? " + e.equals(f));
		System.out.println("b랑 f랑 같아요? " + b.equals(f));
	}
}
