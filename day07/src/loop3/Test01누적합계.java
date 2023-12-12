package loop3;

public class Test01누적합계 {
	public static void main(String[] args) {
		//(Q) 1부터 10까지 더해보세요
		
		int total = 0; //선언
		for(int i=1; i<=10; i++) { //조건
			total += i; //증감
		}
		System.out.println(total);
	}

}
