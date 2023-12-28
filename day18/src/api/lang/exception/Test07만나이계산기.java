package api.lang.exception;

import java.util.Scanner;

public class Test07만나이계산기 {
	public static void main(String[] args) {
		/*사용자에게 생년월일을 YYYY-MM 형식으로 입력받습니다.
		이 사용자의 한국나이와 만나이를 구하여 출력
		만나이는 태어난 달이거나 해당 달이 지나면 1살을 추가하는 방식으로 구현

		예를들어 2000년 1월이면 1월이 되면 한 살이 늘어납니다

		처리를 하면서 문제가 되는 상황이 발생하면 상황에 맞는 에러메세지를 출력
		예상 가능한 문제상황들은 다음과 같습니다.

		입력이 너무 짧은 경우
		숫자 변환이 올바로 되지 않는 경우
		생년월일을 미래의 값으로 입력하는 경우
		월을 1~12로 입력하지 않은 경우
		연도가 1900 미만인 경우

		한 개의 catch 블록으로 모든 예외를 처리할 수 있도록 구현하세요*/
		
		try {		
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월 입력 (YYYY-MM)\n:");
			String input = sc.nextLine();
			int currentYear = 2023;
			int currentMonth = 12;
//		LocalDate currentDate = LocalDate.now(); //현재날짜정보 가져오기.
			
			//연도와 월 자르기
			String yearStr = input.substring(0, 4);
			String monthStr = input.substring(5);
			//연도와 월 숫자로
			int userYear = Integer.parseInt(yearStr);
			int userMonth = Integer.parseInt(monthStr);
					
			if(input.length() != 7) {
				throw new Exception("글자수가 맞지 않습니다.");
			}
			if(userYear < 1900 || userYear > currentYear) {
				throw new Exception("연도가 잘못되었습니다.");
			}
			if(!(userMonth >= 1 && userMonth <=12)){
				throw new Exception("1월~12월까지만 입력 가능합니다.");
			}
			//한국나이
			int krAge = currentYear - userYear +1;
			//만나이
			int now = currentYear*12+currentMonth;
			int user = userYear*12+userMonth;
			int gap = now - user;
			int age = gap / 12;
			
			System.out.println("한국나이 = "+krAge);
			System.out.println("만 나이 = "+age);
		}

		catch(Exception e) {
			if(e.getMessage() == null) { //예외 메세지가 없다면
				System.err.println("잘못된 입력입니다.");
			}
			else {
				System.err.println(e.getMessage());
			}
		}
	}
}
