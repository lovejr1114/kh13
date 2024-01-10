package jdbc.app;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test04포켓몬수정 {
	public static void main(String[] args) {
		
		//포켓몬스터 정보 수정을 위한 코드 (DAO를 만들어 쓰겠다)
		PocketmonDto dto = new PocketmonDto();
		dto.setPocketmonNo(1);
		dto.setPocketmonName("바꾼이름");
		dto.setPocketmonType("테스트");
		
		PocketmonDao dao = new PocketmonDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("포켓몬스터 변경 완료!");
		}
		else {
			System.out.println("존재하지 않는 몬스터 번호");
		}
	}
}
