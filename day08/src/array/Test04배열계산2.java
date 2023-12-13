package array;

public class Test04배열계산2 {
	public static void main(String[] args) {
		/*다음과 같은 학생 성적 정보가 있을 때 이를 배열하고 저장하고 계산하여 출력
		 * 90, 67, 75, 88, 52, 59, 90, 92, 61, 72
		 * 1. 불합격자(60점 미만) 점수만 출력
		 * 2. 성적우수자(90점 이상) 점수만 출력
		 * 3. 총점과 전체 평균을 출력
		 * 4. 만약 80점인 학생이 전학을 온다면 예상되는 등수를 출력
		 */
		
		//점수 데이터 준비
		int[] scores = new int[] {90,67,75,88,52,59,90,92,61,72};
		
		//[1] 불합격자 (60점 미만) 점수를 출력 (+인원수,총점, 평균도 구할 수 있음)
		for(int i=0; i<scores.length; i++) {
			if(scores[i] < 60) { // 점수가 60점 미만이라면
			System.out.println("불합격자 점수 = " + scores[i]);
			}
		}
		System.out.println("-------------------");
		
		//[2] 성적우수자(90점 이상) 점수를 출력(+인원수,총점,평균도 구할 수 있음)
		for(int i=0; i<scores.length; i++) {
			if(scores[i]>=90) {
				System.out.println("성적우수자 점수 = " + scores[i]);				
			}
		}
		System.out.println("-------------------");
		
		//[3] 총점과 전체 평균을 출력
		int total = 0;
		for(int i=0; i<scores.length; i++) {
			total += scores[i];
		}
		System.out.println("총점 : " + total);
		
		double average = (double)total/ scores.length;
		System.out.println("평균 : "+average);
		
		//[4]만약 80점인 학생이 전학을 왔을 때 예상되는 등수를 구하세요
		//= 1 + 80점을 초과하는 학생의 카운트
		int rank = 1;
		int point = 80;
		for(int i=0; i<scores.length; i++) {
			if(scores[i] > point) { //80점 초과라면
//				System.out.println("점수 = "+scores[i]);
				rank++;
			}
		}
		System.out.println(point + "점의 예상 순위 = " + rank);
	}
}
