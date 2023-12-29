package api.util.date;

import java.text.DecimalFormat;

public class Test04숫자형식 {
	public static void main(String[] args) {
		//Format 중 하나인 DecimalFormat으로 숫자의 형식을 제어할 수 있다
		//# = 해당 자리의 값이 있으면 출력 (유연하게 쓰고싶을 때)
		//0 = 해당 자리의 값을 출력(없으면 0으로 출력)
		
		int a = 1234567890;
		double b = 1234.56789;
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		System.out.println("a= "+df.format(a));
		System.out.println("b= "+df.format(b));
		
		//format 메소드는 반환형이 string
		
	}
}
