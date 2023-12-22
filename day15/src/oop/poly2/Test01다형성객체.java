package oop.poly2;

import java.util.Scanner;

public class Test01다형성객체 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("노트북을 먼저 선택하세요.");
	System.out.print("1.맥북   2.갤럭시북 : ");
	int type = sc.nextInt();
	System.out.println("테스트할 기능을 선택하세요");
	System.out.print("1.전원   2.동영상 재생   3.타이핑 : ");
	int action = sc.nextInt();
	
	NoteBook notebook;
	if(type == 1) {
		notebook = new MacBook(); //MacBook -> NoteBook (업캐스팅) //바꾸는게 아니라 보관만.
	}
	else {
		notebook = new GalaxyBook(); //GalaxyBook -> NoteBook (업캐스팅) //바꾸는게 아니라 보관만
	}
	
	//notebook에 뭐가 들어있든 기능을 실행하도록 구현
	if(action == 1) {
		notebook.power();
	}
	else if(action == 2) {
		notebook.video();
	}
	else {
		notebook.typing();
	}
}
}
