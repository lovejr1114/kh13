package api.lang.exception;

public class Test09예외전가 {
	public static void main(String[] args) throws InterruptedException {
															//↑ 예외 전가
		System.out.println("시작!");
		
		//Plan B가 없으면 부를 수 없는 위험한 메소드
		Thread.sleep(3000L);
		
		System.out.println("종료!");
	}
}
