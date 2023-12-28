package api.lang.etc;

public class Test04Wrapper클래스 {
	public static void main(String[] args) {
		//Wrapper 클래스
		//- 자바에 존재하는 8개의 원시형 데이터를 클래스로 만들어 놓은것
		//- boolean, byte, short, char, int, long, float, double
		//- Boolean. Byte, Short, Character, Integer, Long, Float, Double
		
		//객체 생성
//		Integer a = new Integer(10); //비추천(Java9부터, 8까진 됨)
//		Integer b = new Integer("10"); //비추천(Java9부터)
		
		//(변경이유) : -128부터 +127까지는 컴퓨터 기본 구조에서 사용하는 숫자 (1 byte)
		Integer a = Integer.valueOf(10); //추천
		Integer b = Integer.valueOf("10"); //추천
		
		System.out.println("a= "+ a);
		System.out.println("b= "+ b);
		
		//덧셈
		Integer c = Integer.sum(a, b);
		System.out.println("c= "+c);
		//이거 보다는 원시형이 더 좋다 (int)
		
		//진법변환
		int n = 100;
		StringBuffer buffer = new StringBuffer();
		for(int i=n; i>0; i/=2) {
//			System.out.println(i % 2);
			buffer.insert(0, i%2); // i를 2로 나눈 나머지를 제일 앞(0)에 넣어라
		}
		System.out.println(buffer.toString());
		
		System.out.println(Integer.toBinaryString(n)); //2진수(binary)
		System.out.println(Integer.toOctalString(n)); //8진수(octal)
		System.out.println(Integer.toHexString(n)); //16진수(hex)
		
		//요약 : 간단한 계산은 int , 복잡한 계산은 Integer
		
		//int와 Integer는 호환이 된다 (하이브리드)
		Integer x = 10;  //int --> Integer
		int y = x; //Integer --> int
		
		
		//int 와 Integer의 결정적인 차이
		// (1) null (참조 대상이 없음)
		
//		int p = null; //error
		Integer q = null; //ok
		
		//(2) 형태 검사 또는 지정
		Object r = 100;
		System.out.println(r instanceof String); //r의 데이터가 String형태예요? 라고 물어보는.
//		System.out.println(r instanceof int); // int는 자료형에 호환이 되지않음 (int에는 null이 들어갈 수 없음)
		System.out.println(r instanceof Integer);
	}
}
