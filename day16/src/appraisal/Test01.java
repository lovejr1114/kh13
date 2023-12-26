package appraisal;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력(1~5글자) : ");
		String firstName = sc.next();
		System.out.print("성 입력(1~2글자) : ");
		String lastName = sc.next();
		System.out.print("나이 입력(1세 이상) : ");
		int age =  sc.nextInt();
		System.out.print("직업 입력 : ");
		String job = sc.next();
		
		
		Person p = new Person(firstName, lastName, age, job);
		
		p.information();
	}
}
