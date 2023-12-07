package data4;

public class Test04숫자판정 {
	public static void main(String[] args) {
		//어떤 두 자리 숫자가 주어졌을 때
		//이 숫자에 7이 포함 되어 있는지 검사하여 결과 출력
		
		int number = 71;
		
		int two = number /10;
		int one = number %10;
		//System.out.println(one);
		
		boolean in = one == 7 || two == 7; 
		System.out.println("숫자가 포함 되어 있나요? " + in);
	}

}
