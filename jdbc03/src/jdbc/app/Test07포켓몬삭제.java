package jdbc.app;

import jdbc.dao.PocketmonDao;

public class Test07포켓몬삭제 {
	public static void main(String[] args) {
		
		//데이터 준비 (메소드가 필요로 하는 매개변수)
		int pocketmonNo = 44;
		
		
		//처리
		PocketmonDao dao = new PocketmonDao();
		boolean result = dao.delete(pocketmonNo);
		
		//출력
		if(result) {
			System.out.println("포켓몬 삭제 완료");
		}
		else {
			System.out.println("존재하지않는 포켓몬 번호");
		}
	}
}
