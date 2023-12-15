package array4;

public class Test04지그재그 {
	public static void main(String[] args) {
		
		//배열 생성
		int[][] map = new int[5][5];
		
		//데이터 초기화 - 위치 기준
		int number = 1;
		for(int i=0; i<map.length; i++) {
			if(i % 2 == 0) { //짝수 위치 일 때 (정방향)				
				for(int k=0; k<map[i].length; k++) {
					map[i][k] = number++;
				}
			}
			else { //홀수 위치일 때 (역방향)
				for(int k=map[i].length-1; k>=0; k--) {
					map[i][k] = number++;
				}
			}
		}
		
		//배열 출력
		for(int i=0; i<map.length; i++) {
			for(int k=0; k<map[i].length; k++) {
				System.out.print(map[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}
