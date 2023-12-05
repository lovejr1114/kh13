package data;

public class Test05편의점 {
	//편의점에서 삼각김밥 '1+1' 판매중입니다.
	//아르바이트생은 여러분의 생각만큼 친절하지 않아서
	//5개를 가져간다한들 한 개 더 가져오면 공짜라는 말을 안합니다.
	//삼각김밥 한 개가 1200원이라고 할 때,
	//삼각김밥 7개를 사면
	//(1) 몇 개가 공짜 처리 되는지
	//(2) 다 해서 얼마인지
	//구해서 출력해보자.
	
	public static void main(String[] args) {
		//입력 - 김밥 가격, 개수
		//int price = 1200;
	//	int count = 7;
		
		//계산 - 무료든 유료든 한 쪽 개수를 구해야함
		//int free = count / 2; // 개수 / 2 -> 응용으로 2+1 하면 나누기 3이 됨
		//System.out.println(free);
		//int pay = count - free; //개수 - 무료개수
		//System.out.println(pay);
		//int total = pay * price;
		//System.out.println(total);
		
		//출력
		//System.out.println(free);
		//System.out.println(total);
		
		
		
		
		//편의점 음료 개당 2200원 3+1 행사, 9개사면 몇 개가 공짜? 얼마?
		//입력
		int drink = 2200;
		int count = 7;
		
		//계산
		int free = count / 3;
		//System.out.println(free);
		int buy = count - free;
		//System.out.println(buy);
		int pay = drink * buy;
		//System.out.println(pay);
		
		//출력
		System.out.println(free);
		System.out.println(buy);
		System.out.println(pay);
	}


}
