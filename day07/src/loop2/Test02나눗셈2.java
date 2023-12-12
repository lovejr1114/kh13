package loop2;

import java.util.Scanner;

public class Test02나눗셈2 {
	public static void main(String[] args) {
		//어떤 숫자가 입력 되었을 때, 이 숫자의 약수 개수를 구하여 출력
		//-어떤 숫자가 입력되면 1부터 해당 숫자까지 나누어서 떨어지는 숫자의 개수를 구하여 출력
		//-예를 들어서 5가 입력 될 경우 5를 1, 2, 3, 4, 5로 나눠서 떨어지는지 확인 (2개/1,5)
		//-예를 들어 6이 입력 될 경우 6을 1,2,3,4,5,6으로 나누어 떨어지는지 확인 (4개/1,2,3,6)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		int count = 0;
		System.out.println("나누어 떨어지는 숫자는 ");	
		for(int i=1; i<=num; i++) {
			if(num % i == 0) {
				System.out.print(i);
				if(i < num) {			//숫자를 나란히 나열하고싶다면 		
					System.out.print(", "); 
				}
				count++;
			}
		}
		System.out.println();
		System.out.println("약수 개수는 " + count + "개입니다.");
		
		if(count == 2) {
			System.out.println("이 숫자는 소수입니다");
		}
		else {
			System.out.println("이 숫자는 소수가 아닙니다.");
		}
	}	
}
