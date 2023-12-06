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
		int salary = 3000000;
		
		//계산
		//-변환 연산을 사용하여 double을 int로 바꿔서 저장 (당연히 소수점은 날라간다)
		int pension = (int) (salary * 0.045);//국민연금, 괄호 안 기능은 오른쪽 역할 바꿔줌
		//int pension = salary * 45 / 1000; //이렇게 하면 변환이 필요 없다.
		int health = (int) (salary * 0.0709);//건보료
		int care = (int) (health * 0.1281);//장기요양
		int emp = (int) (salary * 0.009);//고용보험
		int actual = salary - pension - health - care - emp;

		
		
		//출력
		System.out.println(actual); //실수령액
		System.out.println(pension);
		System.out.println(health);	
		System.out.println(care);
		System.out.println(emp);

	}

}
