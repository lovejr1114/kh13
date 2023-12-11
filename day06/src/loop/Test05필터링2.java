package loop;

public class Test05필터링2 {
	public static void main(String[] args) {
		//다음 숫자를 화면에 출력해보세요
		//1. '1'부터 '20' 사이의 홀수
		//2. '1'부터 '50' 사이의 3의 배수
		
		System.out.println("1부터 20 사이의 홀수");
		for(int i=1 ; i <= 20 ; i=i+1) {
			if(i % 2 != 0) { //else는 문제에서 나머지를 묻지 않았으니 굳이 안적어도 된다
				System.out.println(i);
			}
		}
		System.out.println("1부터 50 사이의 3의 배수");
		for(int i=1 ; i <= 50 ; i=i+1) {
			if(i % 3 == 0) {
				System.out.println(i);
				}
		}
	}

}
