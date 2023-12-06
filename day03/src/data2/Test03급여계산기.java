package data2;

public class Test03급여계산기 {
	public static void main(String[] args) {
		//급여액이 주어졌을 때 각종 세금과 수령액을 계산하는 계산기를 구현합시다

//급여액 : 300만원
//국민연금 : 급여액의 4.5%
//건강보험료 : 급여액의 7.09%
//장기요양보험료 : 건강보험료의 12.81%
//고용보험료 : 급여액의 0.9%
		
		//입력
		double salary = 3000000;
		
		//계산
		double annuity = salary * 4.5 /100; 
		double health = salary * 7.09 /100; 
		double con = health * 12.81 /100; 
		double employ = salary * 0.9 /100; 
		double money = salary - annuity - health - con - employ;
		
		//출력
		System.out.println(money); //실수령액
		System.out.println(annuity);
		System.out.println(health);
		System.out.println(con);
		System.out.println(employ);

	}

}
