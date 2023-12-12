package loop3;

public class Test03다이어트3 {
	public static void main(String[] args) {
		//오늘부터 다이어트를 위해 줄넘기 하려고함.
		//첫날은 힘드니까 100개만하고 다음날부터는 전날보다 10개씩 더 하려고 함.
		// 1. 30일 동안 하게되는 일자별 줄넘기 개수 출력
		// 2. 30일 동안 하게되는 총 줄넘기 개수 출력
		
		int count = 100;
		int step = 10;
		int total = 0;
		
		for(int day=1; day<=30; day++) {
			System.out.println(day+"일차 : " + count + "개");
			total += count;
			count +=  step; 
		}
		System.out.println("총 개수 : " + total);
	}

}
