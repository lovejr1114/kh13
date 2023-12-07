package io;

import java.util.Scanner;

public class Test06분식점 {
	public static void main(String[] args) {
		
		//입력
		int ddbkk = 3000;
		int fried = 500;
		int sundae = 2000;
		int event = 10;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주문 할 떡볶이 수량 : ");
		int orderdd = sc.nextInt();
		System.out.print("주문 할 튀김 수량 : ");
		int orderfri = sc.nextInt();
		System.out.print("주문 할 순대 수량 : ");
		int ordersun = sc.nextInt();
		
		//계산
		int ddbkkE = ddbkk - ddbkk /event;
		int friedE = fried - fried / event;
		int sundaeE = sundae - sundae / event;
		int pay = (ddbkkE * orderdd) + (friedE * orderfri) + (sundaeE * ordersun);
		
		//int price = (ddbkk * orderdd) + (fried * orderfri) + (sundae * ordersun);
		//int pay = price - price /10;
		
		//출력
		System.out.println();
		System.out.println("총 결제 금액은 " + pay + "원입니다.");
	}

}
