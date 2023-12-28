package api.lang.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03통합예외처리 {
	public static void main(String[] args) {
		
		//문제 : 예외를 다 해결했는지도 모르겠고.. catch가 너무 많다!
		//해결 :
		//- InputMismatchException 와 ArithmeticException의 공통된 상위클래스를 찾아 블록을 구현
		//- 결론 : 앞으로 모든 catch 블록은 Exception으로 만든다. 끝!
		
		
		try {//Plan A
			Scanner sc = new Scanner(System.in);
			System.out.print("귤 개수 : ");
			int mandarin = sc.nextInt(); //예외 발생 예상 위치
			System.out.print("인원 수 : ");
			int people = sc.nextInt(); //예외 발생 예상 위치
			
			int dist = mandarin / people; //예외 발생 예상 위치
			int rest = mandarin % people;
			
			System.out.println("한 사람당 "+dist+"개씩 줄 수 있습니다");
			System.out.println("다 주면 "+rest+"개 남네요");
		}
//		catch(RuntimeException e) {//Plan B
		catch(Exception e) {//Plan B ->예외만 처리해준다. 사용 가능
//		catch(Throwable e) {//Plan B -> 하위클래스에 에러까지 처리해준다는 내용있어서 쓰면 X
//		catch(Object e) { //error , 아무거나는 안된다.
			System.err.println("잘못된 입력입니다.");
		}
	}
}
