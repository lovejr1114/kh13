package loop3;

public class Test03다이어트 {
	public static void main(String[] args) {
		//오늘부터 다이어트를 위해 줄넘기 하려고함.
		//첫날은 힘드니까 100개만하고 다음날부터는 전날보다 10개씩 더 하려고 함.
		// 1. 30일 동안 하게되는 일자별 줄넘기 개수 출력
		// 2. 30일 동안 하게되는 총 줄넘기 개수 출력
	
		//내가 푼 것 = 틀림 (누적합계산 줄 위치가 달랐음. 그래서 결과 값이 달라짐.)
		//다시 풀어보기
		
		int rope = 100;
		int day = 0;
		for(int i=1; i<=30; i++) {
			System.out.println(rope);
			day += rope; //누적합계 계산 위치에 따라 결과 달라짐.
			
			rope += 10; //다음 날로 넘어가기 위한 처리라서 제일 마지막에 위치해야함
		}
		System.out.println(day);
	}

}
