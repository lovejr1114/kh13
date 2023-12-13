package loop3;

import java.util.Scanner;

public class Test03합계구하기2 {
	public static void main(String[] args) {
		//사용자가 0을 입력하기 전까지 입력한 숫자들의 합계와 평균을 구하여 출력
		
		Scanner sc =  new Scanner(System.in);
		
		int count = 0;
		int total = 0;
		while(true) {
			System.out.print("숫자를 입력하세요 : ");
			double user = sc.nextDouble();
			
			if(user == 0) {
				break;
			}
			else {
				count++; //위치 매우 중요함				
				total += user; //위치
			}
		}
		//count와 total이 확정된 뒤 평균을 계산
		double div = (double)(total/count); //위치
		System.out.println("입력 횟수 : "+count);
		System.out.println("입력한 수의 총 합은 " + total + ", 평균 값은 "+ div);
	}

}
