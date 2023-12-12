package loop2;

public class Test01카운트세기 {
	public static void main(String[] args) {
		//(Q) 1부터 100 사이의 짝수 개수
		//(A) 50개
		
		//1. 일단 1부터 100사이의 범위를 만든다. (for)
		//2. 조건을 추가하여 짝수만 출력하도록 구문을 만든다.
		//3. 2번에서 만든 영역에 대한 개수를 카운트 하겠다.
		//카운트는 하나당 한 종류만 가능
		
		int count = 0; //3번 (카운트는 반복문이 시작하기 전에 배치) /카운트 측정 위한 변수 선언.
		for(int i=1; i<=100; i++) { //1번
			if(i % 2 == 0) { //2번
				//System.out.println(i); // if문 확인용
				count++; //3번
			}
		}
		System.out.println("짝수 개수 = " + count); //최종 결과 확인
	}

}
