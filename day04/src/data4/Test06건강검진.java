package data4;

public class Test06건강검진 {
	public static void main(String[] args) {
		//입력
		int birth = 1985;
		int current = 2023;
		
		//계산
		//[1]30세 이상인가?
		//[2]올해가 짝수이고 출생년도도 짝수인가?
		//[3]올해가 홀수이고 출생년도도 홀수인가?
		
		//boolean thirty = thisY - ob + 1 >= 30;
		//System.out.println(thirty);
		//boolean even = thisY  == 0;
		//System.out.println(even);
	
		
		//- [1][2]을 만족하거나 [1][3]을 만족하면 건강검진 대상자
		
		int age = current - birth + 1;
		
	//	boolean first = 30세 이상;
		boolean first = age >= 30;
	//	boolean second = 올해가 짝수 && 출생년도 짝수;
		boolean second = current % 2 == 0 && birth % 2 == 0;
	//	boolean third = 올해가 홀수 && 출생년도 홀수;
		boolean third = current % 2 != 0 && birth % 2 != 0;
		//boolean third = current % 2 == 1 && birth % 2 == 1;   // -> 2로 나눌 때 1이 남으면 홀수니까 이렇게 판별해도 됨!
		
		boolean result = (first && second) || (first && third);
		
		//출력
		System.out.println("나이 = " + age + "세");
		System.out.println("30세 이상? " + first);
		System.out.println("짝수 대상자? " + second);
		System.out.println("홀수 대상자? " + third);		
		System.out.println("건강검진 대상자? " + result);
	}

}
