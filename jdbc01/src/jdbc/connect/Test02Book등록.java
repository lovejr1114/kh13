package jdbc.connect;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02Book등록 {
	public static void main(String[] args) {
		//연결 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13");
		dataSource.setPassword("kh13");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		//사용자 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("책 제목 : ");
		String book_titleInput = sc.nextLine();
		System.out.print("저자 : ");
		String book_authorInput = sc.nextLine();
		System.out.print("출판일자 : ");
		String book_publication_dateInput = sc.nextLine();
		System.out.print("가격 : ");
		int book_priceInput = sc.nextInt();
		System.out.print("발행자 : ");
		sc.nextLine();
		String book_publisherInput = sc.nextLine();
		System.out.print("페이지 수 : ");
		int book_page_countInput = sc.nextInt();
		System.out.print("장르 : ");
		sc.nextLine();
		String book_genreInput = sc.nextLine();
		sc.close();
		
		//명령 생성
		String sql = "insert into book(book_id, book_title, book_author, book_publication_date, book_price,"
				+ "book_publisher, book_page_count, book_genre)"
				+ "values(52,'" +book_titleInput+"', '"+book_authorInput+"', '"+book_publication_dateInput+
				"', "+book_priceInput+",'"+book_publisherInput+"', "+book_page_countInput+",'"+book_genreInput+"')";
		
		
		//명령처리 도구 생성
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//실행
		jdbcTemplate.update(sql);
		System.out.println("완료!");
	}
}
