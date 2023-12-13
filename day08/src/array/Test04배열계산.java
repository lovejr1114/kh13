package array;

public class Test04배열계산 {
	public static void main(String[] args) {
		/*다음과 같은 학생 성적 정보가 있을 때 이를 배열하고 저장하고 계산하여 출력
		 * 90, 67, 75, 88, 52, 59, 90, 92, 61, 72
		 * 1. 불합격자(60점 미만) 점수만 출력
		 * 2. 성적우수자(90점 이상) 점수만 출력
		 * 3. 총점과 전체 평균을 출력
		 * 4. 만약 80점인 학생이 전학을 온다면 예상되는 등수를 출력
		 */
		
		
		int score = 0;
		int[] total = new int[] {90,67,75,88,52,59,90,92,61,72};
		for(int i=0; i<total.length; i++) {			
			if(total[i] < 60) {
				System.out.println(total[i]);
			}
		}
		for(int i=0; i<total.length; i++) {
			if(total[i]>=90) {
				System.out.println(total[i]);
			}
			}
		
//			if(total[i] == 80) {
//				System.out.println("");
//			}
//			
//
//			score += total[i];
//		double average = (double)score/total.length;
//		System.out.println("총점 : " +score);
//		System.out.println("평균 : " + average);
	}

}
