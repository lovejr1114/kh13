package condition;

public class Test03과속카메라 {
	public static void main(String[] args) {
		
		//입력
		//Scanner sc = new Scanner(System.in);
		int km = 59; //sc.nextInt();
		
		//계산
		
		boolean excess = km > 50;
		
		int penalty = km / 10 * 10000 - 20000;

		
		//System.out.println();
		
		//출력
		if(excess) {
			int plus = penalty + 10000 * 10 / 10;
			System.out.println(plus);
		}
		
		else {
			System.out.println("벌금 0원");
		}
		}
	}


