package loop3;

import java.util.Scanner;

public class Test03합계구하기5 {
	public static void main(String[] args) {
		//사용자가 0을 입력하기 전까지 입력한 숫자들의 합계와 평균을 구하여 출력
		
		Scanner sc =  new Scanner(System.in);
		
		int count = 0;
		double plus = 0;
		double div = 0;
		while(true) {
			System.out.print("숫자를 입력하세요 : ");
			double user = sc.nextDouble();
			count++;
			if(user == 0) {
				break;
			}
			plus += user;
			div = plus /count;
		}
		System.out.println("입력한 수의 총 합은 " + plus + ", 평균 값은 "+ div);
	}

}
