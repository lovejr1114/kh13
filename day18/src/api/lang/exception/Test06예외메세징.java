package api.lang.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test06예외메세징 {
	public static void main(String[] args) {
		
		
		try {//Plan A
			Scanner sc = new Scanner(System.in);
			System.out.print("귤 개수 : ");
			int mandarin = sc.nextInt();
			if(mandarin < 0) { 
//				throw new Exception();
				throw new Exception("귤 개수는 음수일 수 없습니다.");
			}
			System.out.print("인원 수 : ");
			int people = sc.nextInt();
			if(people < 0) {
//				throw new Exception();
				throw new Exception("인원수는 음수일 수 없습니다.");
			}
			
			int dist = mandarin / people;
			int rest = mandarin % people;
			
			System.out.println("한 사람당 "+dist+"개씩 줄 수 있습니다");
			System.out.println("다 주면 "+rest+"개 남네요");
		}
		catch(Exception e) {//Plan B
			//다양한 예외들이 모이다보니... 구분 내지는 추가 정보를 얻고싶다
			//예외가 발생하면 catch 블록의 매개변수에 정보가 들어오니 이것을 분석하겠다
			
//			System.err.println(e); //java.lang.Exception: 인원수는 음수일 수 없습니다. 이렇게 영어도 다 나온다.
//			System.out.println(e.getMessage()); //예외 메세지만 추출
			
			if(e.getMessage() == null) { //예외 메세지가 없다면
				System.err.println("잘못된 입력입니다.");
			}
			else {
				System.err.println(e.getMessage());
			}
		}
	}
}
