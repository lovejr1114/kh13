package jdbc.app;

import java.text.DecimalFormat;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test13메뉴상세 {
	public static void main(String[] args) {
//		MenuDao에 메소드를 만들고 메뉴번호로 메뉴를 조회한 결과를 출력하도록 구현
		
		int menuNo = 3;
		
		MenuDao dao = new MenuDao();
		MenuDto dto = dao.selectOne(menuNo);
		
		if(dto != null) {
			DecimalFormat fmt = new DecimalFormat("#,##0"); //가격에 콤마를 찍어주고싶을 때!
			//배운것을 활용해야 까먹지 않는다.
			
			System.out.println("<메뉴 정보>");
			System.out.println("메뉴 번호 : "+dto.getMenuNo());
			System.out.println("메뉴명(한글) : "+dto.getMenuNameKor());
			System.out.println("메뉴명(영문) : "+dto.getMenuNameEng());
			System.out.println("메뉴 종류 : "+dto.getMenuType());
			System.out.println("메뉴 가격 : "+fmt.format(dto.getMenuPrice())); //decimalformat 적용
		}
		else {
			System.out.println("존재하지 않는 메뉴 번호입니다.");
		}
	}
}
