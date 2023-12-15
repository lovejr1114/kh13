package array4;

public class Test02이차원배열생성 {
	public static void main(String[] args) {
		//다음 데이터가 있을 때 이를 저장하고 출력하세요
		//-1반 : 180.3,	165.2,	177.9,	158.2
		//-2반 : 168.5,	155.3,	172.1,	169.7
		//-3반 : 158.5,	170.2,	182.5,	175.8
		//출력은 세로로 먼저 하고, 표처럼 배치되어 출력 되도록 변경해보세요.
		
		double[][] cm = new double[][] {
			{180.3,165.2,177.9, 158.2},
			{168.5, 155.3, 172.1, 169.7},
			{158.5, 170.2, 182.5, 175.8}
		};
		
		for(int i=0; i<cm[0].length; i++) {
			System.out.println(cm[0][i]);
		}
		for(int i=0; i<cm[1].length; i++) {
			System.out.println(cm[1][i]);
		}
		for(int i=0; i<cm[2].length; i++) {
			System.out.println(cm[2][i]);
		}
		System.out.println("------------------");
		
		
		
		for(int i=0; i<cm[0].length; i++) {
			System.out.println();
		}
		
		
	}

}
