package loop;

public class Test07삼육구4 {
	public static void main(String[] args) {
		//1부터 99사이 숫자 중 369게임상에서 박수를 쳐야하는 숫자들만 골라서 출력
		
		for(int i=1; i<=99; i++) {
			int ten = i/10; //10의자리 추출
			int one = i % 10; //1의 자리 추출
			
			
			boolean ten369 =  ten == 3 || ten == 6 || ten == 9;
			//boolean ten369 = ten % 3 == 0; 으로도 적을 수 있지만 이건 머리 쓴 것
			boolean one369 = one == 3 || one == 6 || one == 9;
			boolean has369 = ten369 || one369;
			
			if(ten369 && one369) { //십의자리 일의자리에 3,6,9가 포함된 숫자라면 - 박수두번
				System.out.println("짝짝");
			}
			else if(ten369 || one369) {
				System.out.println("짝");
			}
			else { //박수 X
				System.out.println(i); //출력
			}
		}
	
				}
			}	

