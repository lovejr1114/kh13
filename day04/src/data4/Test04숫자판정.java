package data4;

public class Test04숫자판정 {
	public static void main(String[] args) {
		//어떤 두 자리 숫자가 주어졌을 때
		//이 숫자에 7이 포함 되어 있는지 검사하여 결과 출력
		
		//입력
		int number = 71;
		
		//계산
		//-논리에서는 말이 되는 것이 중요하다
		//- 7이 들어있는 숫자는 무엇인가?
		//- 10의 자리가 7 또는 1의 자리가 7
		//- 70부터 79사이 또난 1의 자리가 7
		boolean ten = number / 10 == 7;  //->첫 번 째 방법
		//boolean ten = number >= 70 && number < 80; //<- 두 번 째 방법
		boolean one = number % 10 ==7;
		//boolean seven = ten && one; //둘 다 7 (1개)
		boolean seven = ten || one; //둘 중 하나가 7 (19개)
		System.out.println(seven);
		
		
		System.out.println("7이 들어있나요? " + seven);
	
		//int two = number /10;
		//int one = number %10;
		//System.out.println(one);
		
		//출력
		//boolean in = one == 7 || two == 7; 
		//System.out.println("숫자가 포함 되어 있나요? " + in);
	}

}
