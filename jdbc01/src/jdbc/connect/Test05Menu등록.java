package jdbc.connect;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05Menu등록 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("한글메뉴 이름 : ");
		String menuNameKor = sc.nextLine();
		System.out.print("영어메뉴 이름 : ");
		String menuNameEng = sc.nextLine();
		System.out.print("메뉴 종류 : ");
		String menuType = sc.nextLine();
		System.out.print("판매가(원) : ");
		int menuPrice = sc.nextInt();
		
		//처리
		String sql = "insert into menu(menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)"
				+ "values(menu_seq.nextval, ?, ?, ?, ?)";
		
		Object[] data = {menuNameKor, menuNameEng, menuType, menuPrice};
		
		//연결
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13");
		dataSource.setPassword("kh13");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		//출력
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		jdbcTemplate.update(sql, data);
		System.out.println("메뉴 등록 완료!");
	}
}
