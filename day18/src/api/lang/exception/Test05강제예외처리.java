package api.lang.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test05강제예외처리 {
	public static void main(String[] args) {
		
		try {//Plan A
			Scanner sc = new Scanner(System.in);
			System.out.print("귤 개수 : ");
			int mandarin = sc.nextInt(); //예외 발생 예상 위치
			if(mandarin < 0) { //귤 개수가 음수라면 문제가 된다. (근데 자바는 모르네?)
//				Exception ex = new Exception();
//				throw ex; // Plan B로 넘겨준다.
				throw new Exception(); //위 코드를 줄여 쓴것.
			}
			System.out.print("인원 수 : ");
			int people = sc.nextInt(); //예외 발생 예상 위치
			if(people < 0) {//인원수가 음수라면 문제가 된다
				throw new Exception();
			}
			
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
