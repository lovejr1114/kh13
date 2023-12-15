package array4;

public class Test03이차원배열초기화2 {
	public static void main(String[] args) {
		
		//배열 생성
		int[][] dataset = new int[5/*줄*/][5/*칸*/]; //[1차원개수][0차원개수]
		
		//데이터 초기화 - 값 기준
		int x = 0, y = 0; 
		for(int i=1; i<=25; i++) { //1부터 25까지 넣겠다.
			dataset[x][y] = i;
			
			y++; //오른쪽으로 이동
			if(y == 5) { //넘어갈 것 같으면
				y=0;  //다음 줄 첫번 째 칸으로 위치를 변경
				x++;
			}
		}
		
		//배열 출력
		for(int i=0; i<dataset.length; i++) {
			for(int k=0; k<dataset[i].length; k++) {
				System.out.print(dataset[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
	}

}
