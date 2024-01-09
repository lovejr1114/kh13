package jdbc.update;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.jdbcHelper;

public class Test03메뉴정보수정 {
	public static void main(String[] args) {
		//메뉴 번호로 메뉴명,종류,판매가 변경하도록 구현
		
		Scanner sc = new Scanner(System.in);
		System.out.print("한글 메뉴 : ");
		String menuNameKor = sc.nextLine();
		System.out.print("영문 메뉴 : ");
		String menuNameEng = sc.nextLine();
		System.out.print("메뉴 종류 : ");
		String menuType = sc.nextLine();
		System.out.print("판매가(원) : ");
		int menuPrice = sc.nextInt();
		int menuNo = 11;
		
		//
		JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		
		String sql = "update menu set menu_name_kor=?, menu_name_eng=?, menu_type=?, "
				+ "menu_price=? where menu_no=?";
		Object[] data = {menuNameKor, menuNameEng, menuType, menuPrice, menuNo};
		
		//
		int result = jdbcTemplate.update(sql, data);
		
		
		if(result > 0) {
			System.out.println("메뉴 정보 변경 완료!");
		}
		else {
			System.out.println("존재하지 않는 메뉴번호입니다.");
		}
	}
}
