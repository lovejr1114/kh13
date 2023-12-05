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
		//삼각김밥 가격
		int triangularKimbap = 1200;
		
		//삼각김밥 구매 개수
		int triangularKimbapCount = 7;
		
		//1+1 행사 적용 후 계산
		//삼각김밥 행사 = (삼각김밥 구매개수/2) 몫 + (삼각김밥구매개수%2) 나누기
		int triangularKimbapEvent =( triangularKimbapCount / 2) + (triangularKimbapCount % 2);
		//삼각김밥 무료 = 삼각김밥구매개수/2
		int triangularKimbapFree = triangularKimbapCount / 2;
		//결과 = 삼김 행사 * 삼김가격
		int total = triangularKimbapEvent * triangularKimbap;
		
		System.out.println(triangularKimbapCount);
		System.out.println(triangularKimbapFree);
		System.out.println(total);
	}


}
