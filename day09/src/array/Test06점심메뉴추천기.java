package array;

import java.util.Random;
import java.util.Scanner;

public class Test06점심메뉴추천기 {
	public static void main(String[] args) {
		//사용자에게 5가지 점심메뉴를 입력 받아 배열에 저장한 뒤
		//무작위로 한 개를 골라 출력하도록 프로그램을 구현하세요
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		String[] menu = new String[5];
		
		for(int i=0; i<menu.length; i++) {
			System.out.print("점심 메뉴를 입력해주세요 : ");
			menu[i] = sc.next();						
		}
		
		System.out.println("점심 메뉴는?");
			int random = r.nextInt(5);
			System.out.println("오늘은 " + menu[random] + " 드시죠");
	}

}
