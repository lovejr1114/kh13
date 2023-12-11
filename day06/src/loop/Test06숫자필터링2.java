package loop;

public class Test06숫자필터링2 {
	public static void main(String[] args) {
		//1부터 99 사이 숫자 중 5가 포함 된 숫자들만 출력
		
	//for와 if를 사용하여 필터링
		for(int i=1; i <= 99; i=i+1) {
			if(i /10 == 5 || i % 10 == 5) {
				System.out.println(i);			
		}
			}		
		}
	}

