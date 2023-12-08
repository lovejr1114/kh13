package condition;

public class Test03과속카메라 {
	public static void main(String[] args) {
		//KH전자에서 개발한 과속단속 카메라는 다음 규칙에 따라 벌금을 계산하도록 만들어져 있습니다.

		//50km를 초과하여 달리는 차량을 단속
		//벌금은 시작이 30000원
		//제한속도인 50km보다 10km 빨라질 때마다 벌금은 10000원씩 증가

		//자동차 속도를 입력받아 예상되는 벌금을 출력하세요
		//(벌금이 없으면 0원이라고 출력하면 됩니다)
		
		
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


