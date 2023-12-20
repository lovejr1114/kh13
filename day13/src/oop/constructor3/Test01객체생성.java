package oop.constructor3;

import java.util.Scanner;

public class Test01객체생성 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		System.out.print("ID 입력 : " );
		String id = sc.next();
		System.out.print("직업 입력(전사/도적/마법사) : ");
		String job = sc.next();
		
		Game p = new Game(id, job);		
		
		
		//레벨 업
//		int level = p.getLevel();
//		p.setLevel(level + 1);
		
//		p.levelUp(); //클래스에 레벨업 기능을 넣어주고 출력하면 된다.
		p.information();
	}
}
