package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test03메뉴등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MenuDto dto = new MenuDto();
		System.out.print("메뉴명(한글) : ");
		dto.setMenuNameKor(sc.nextLine());
		System.out.print("메뉴명(영문) : ");
		dto.setMenuNameEng(sc.nextLine());
		System.out.print("메뉴 종류 : ");
		dto.setMenuType(sc.nextLine());
		System.out.print("메뉴 판매가(원) : ");
		dto.setMenuPrice(sc.nextInt());
		
		MenuDao dao = new MenuDao();
		dao.insert(dto);
		
		System.out.println("메뉴 등록 완료!");
	}
}
