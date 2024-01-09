package jdbc.delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.jdbcHelper;

public class Test03메뉴정보삭제 {
	public static void main(String[] args) {
		
		//
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 메뉴 번호 : ");
		int menuNo = sc.nextInt();
		sc.close();
		
		//
		 JdbcTemplate jdbcTemplate = jdbcHelper.getJdbcTemplate();
		 
		 String sql = "delete menu where menu_no=?";
		 Object[] data = {menuNo};
		 
		int result = jdbcTemplate.update(sql, data);
		
		if(result > 0) {
			System.out.println("메뉴 정보 삭제 완료!");
		}
		else {
			System.out.println("존재하지 않는 메뉴 번호");
		}
	}
}
