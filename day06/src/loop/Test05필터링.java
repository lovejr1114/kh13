package loop;

public class Test05필터링 {
	public static void main(String[] args) {
		//다음 숫자를 화면에 출력해보세요
		//1. '1'부터 '20' 사이의 홀수
		//2. '1'부터 '50' 사이의 3의 배수
		
		System.out.println("1부터 20 사이의 홀수");
		//1부터 20까지 홀수 출력
		// 1부터 19까지 2씩 증가
		for(int i=1 ; i <= 19 ; i=i+2) {
				System.out.println(i);
		}
		System.out.println("1부터 50 사이의 3의 배수");
		//1부터 50까지 3의 배수 출력
		// 3부터 48까지 3씩 증가
		for(int i=3 ; i <= 48 ; i=i+3) {
				System.out.println(i);
		}
	}

}
