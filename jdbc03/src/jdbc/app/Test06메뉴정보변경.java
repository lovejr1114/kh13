package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test06메뉴정보변경 {
	public static void main(String[] args) {
		
//		MenuDao에 메소드를 구현하여 메뉴 정보를 변경하는 프로그램을 완성하세요
//		(완성한 뒤 입력을 추가하세요)
		
		Scanner sc = new Scanner(System.in);
		
		MenuDto dto = new MenuDto();
		
		System.out.print("수정 할 메뉴 번호 : ");
		dto.setMenuNo(sc.nextInt());
		sc.nextLine();
		System.out.print("한글 메뉴명 : ");
		dto.setMenuNameKor(sc.nextLine());
		System.out.print("영문 메뉴명 : ");
		dto.setMenuNameEng(sc.nextLine());
		System.out.print("메뉴 종류 : ");
		dto.setMenuType(sc.nextLine());
		System.out.print("판매가(원) : ");
		dto.setMenuPrice(sc.nextInt());
		sc.close();
		
		MenuDao dao = new MenuDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("메뉴 정보 변경 완료!");
		}
		else {
			System.out.println("존재하지 않는 메뉴 번호");
		}
	}
}
