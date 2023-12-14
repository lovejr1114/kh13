package array;

import java.util.Random;
import java.util.Scanner;

public class Test06점심메뉴추천기2 {
	public static void main(String[] args) {
		//사용자에게 5가지 점심메뉴를 입력 받아 배열에 저장한 뒤
		//무작위로 한 개를 골라 출력하도록 프로그램을 구현하세요
		
		Scanner sc = new Scanner(System.in);
		String[] menus = new String[5];
		//개수까지 사용자가 정하고싶으면 위에 5를 변수(int)로 만들어서 사용자가 입력하게 만들면 됨
		for(int i=0; i<menus.length; i++) {
			System.out.print("메뉴 입력 : ");
			menus[i] = sc.next();
		}
		
		//랜덤은 위치 하나만 추첨
		Random r = new Random();
		int position = r.nextInt(menus.length);
//		System.out.println("position = " +position);
		
		
		
		System.out.println("오늘은 "  + menus[position] + "드시죠");
	}

}
