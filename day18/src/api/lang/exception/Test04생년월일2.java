package api.lang.exception;
import java.util.Scanner;

public class Test04생년월일2 {
	public static void main(String[] args) {
		/*사용자에게 생년월일을 YYYY-MM-DD 형태로 입력받아서
		연도, 월, 일을 각각 분리한 뒤 숫자로 변환해서 출력
		생년월일 입력 : 2023-12-28 (String)
		```int
		출생년도 : 2023년
		출생월 : 12월
		출생일 : 28일
		```
		문제가 발생하는 상황을 try~catch 구문을 이용해서 처리한 뒤 메세지 작성*/
		
		try {			
			Scanner sc = new Scanner(System.in);		
			System.out.print("생년월일 입력 (YYYY-MM-DD) \n:");
			String birthDate = sc.nextLine();
			
			String yearStr = birthDate.substring(0, 4);
			String monthStr = birthDate.substring(5,7);
			String dayStr = birthDate.substring(8);
			
			int year = Integer.parseInt(yearStr);
			int month = Integer.parseInt(monthStr);
			int day = Integer.parseInt(dayStr);
			
			System.out.println("출생년도 : " + year +"년");
			System.out.println("출생월 : "+month+"월");
			System.out.println("출생일 : "+day+"일");
		}
		catch(Exception e){
			System.err.println("입력이 잘못되었습니다.");
		}
	}
}
