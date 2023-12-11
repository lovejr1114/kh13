package condition3;

public class Test01스위치구문 {
	public static void main(String[] args) {
		//월을 입력받아 계절을 출력하는 프로그램
		
		//입력
		int month = 3;
		
		//출력
		switch(month) { //month에 있는 값에 따라 시작 지점이 달라진다.
		case 3:
			System.out.println("봄");
			break; //그만하고 탈출하세요
		case 4:
			System.out.println("봄");
			break;
		case 5:
			System.out.println("봄");
			break;
		case 6:
			System.out.println("여름");
			break;
		case 7:
			System.out.println("여름");
			break;
		}
	}

}
