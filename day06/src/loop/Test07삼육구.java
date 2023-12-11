package loop;

public class Test07삼육구 {
	public static void main(String[] args) {
		//1부터 99사이 숫자 중 369게임상에서 박수를 쳐야하는 숫자들만 골라서 출력
		
		for(int i=1; i<=99; i=i+1) {
			boolean ten = i / 10 == 3 || i /10 == 6 || i /10 == 9;
			boolean one = i % 10 ==3 ||  i % 10 == 6 || i % 10 == 9;
			if(ten || one) {				
				System.out.println(i);
			}	
		}
	}

}
