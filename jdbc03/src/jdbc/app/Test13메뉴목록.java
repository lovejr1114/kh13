package jdbc.app;

import java.util.List;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test13메뉴목록 {
	public static void main(String[] args) {
//		MenuDao에 메소드를 만들어 메뉴목록을 출력
//		한글메뉴명과 가격만 출력
		
		MenuDao dao = new MenuDao();
		List<MenuDto> list = dao.selectList();
		
		
		if(list.isEmpty()) {
			System.out.println("메뉴 목록 없음");
		}
		else {
			for(MenuDto dto:list) {
				System.out.println(dto.getMenuNameKor()+" ("+dto.getMenuPrice()+"원)");
			}
		}
	}
}
