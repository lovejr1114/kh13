package array4;

public class Test03이차원배열초기화 {
	public static void main(String[] args) {
		
		//배열 생성
		int[][] dataset = new int[5/*줄*/][5/*칸*/]; //[1차원개수][0차원개수]
		
		//데이터 초기화 - 위치 기준
//		dataset[0][0] = 1;
//		dataset[0][1] = 2;
//		dataset[0][2] = 3;
//		dataset[0][3] = 4;
//		dataset[0][4] = 5;   //이렇게 수작업하기 보다는
		int number = 1;
		for(int i=0; i<dataset.length; i++) { //줄
			for(int k=0; k<dataset[i].length; k++) { //칸
				dataset[i][k] = number;
				number++;
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
