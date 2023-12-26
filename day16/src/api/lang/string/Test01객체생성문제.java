package api.lang.string;

public class Test01객체생성문제 {
	public static void main(String[] args) {
		//객체 생성
		StringBuffer a = new StringBuffer();
		StringBuffer b = new StringBuffer("hello");
		
		//요약 정보 출력
		System.out.println("a = " + a.toString()); // toString을 생략해도 출력 시에 동일한 효과
		System.out.println("b = " + b.toString());

		//글자 수 출력
		System.out.println("a의 글자 수 = " + a.length());
		System.out.println("b의 글자 수 = " + b.length());
		
		//글자 추가 출력
		a.append("java");
		b.append("java");

		//요약정보와 글자 수 출력
		System.out.println("a = " + a.toString() + ", " + a.length());
		System.out.println("b = " + b.toString() +", "+ b.length());
	}
}
