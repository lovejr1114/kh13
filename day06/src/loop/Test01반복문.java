package loop;

public class Test01반복문 {
	public static void main(String[] args) {
		//(Q) 화면에 Hello Java를 5번 출력하세요
		
		//반복을 위해서는 변수가 하나 필요하다 (반복수, 반복 변수)
		//- 반복수를 변화시켜 원하는 만큼의 횟수를 만든다
		for(int i=1 ; i <=5 ; i=i+1) {
			System.out.println("Hello Jave");
		}
		
		
		// i=1   선언부
		// i <= 5   조건부
		// i=i+1 증감부
	}

}
