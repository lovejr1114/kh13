package io;

import java.util.Scanner;

public class Test06분식점2 {
	public static void main(String[] args) {
		
		//입력
		int ddeok = 3000;
		int fried = 500;
		int sundae = 2000;
		int rate = 10;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("떡볶이(" + ddeok + "원) : ");
		int ddeokCount = sc.nextInt();
		System.out.print("튀김(" + fried + "원) : ");
		int friedCount = sc.nextInt();
		System.out.print("순대(" + sundae + "원) : ");
		int sundaeCount = sc.nextInt();
		
		//계산
		int ddeokTotal = ddeok * ddeokCount;
		int friedTotal = fried * friedCount;
	    int sundaeTotal = sundae * sundaeCount;
	    
		int total = ddeokTotal + friedTotal + sundaeTotal;
		
		//int discount = (int) (total * 0.1); //이런 식은 괄호 때문에 위험할수있음
		int discount = total * rate /100; //나누기를 먼저하면 날라갈 수 있기 때문에 곱 먼저
		int result = total - discount;
		
		//출력
		System.out.println("총 금액 : " + total + "원");
		System.out.print("할인 금액 : " + discount + "원");
		System.out.println(" (" + rate + "% 할인)");
		System.out.println("결제 금액은 " + result + "원입니다.");
		
	}

}
