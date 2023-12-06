package data;

public class Test08나눗셈 {
	public static void main(String[] args) {
		//위 숫자의 10의자리, 1의자리 숫자를 각각 출력
		int number = 75;
				
		System.out.println(number / 10);
		System.out.println(number % 10);
		
		//숫자의 100의 자리, 10의 자리, 1의자리를 각각 출력
		int number2 = 139;
		
		System.out.println(number2 /10 /10); //- /100도 가능
		System.out.println(number2 /10 % 10);
		System.out.println(number2 % 10);
		//중요한건 내가 원하는 숫자로 잘라낼 수 있느냐
		
		
	}

}
